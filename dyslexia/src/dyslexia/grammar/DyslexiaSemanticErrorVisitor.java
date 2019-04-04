/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.gui.PnlSemantic;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Gaming
 */
public class DyslexiaSemanticErrorVisitor extends DyslexiaBaseVisitor<ArrayList<Value>> {
    public ArrayList<Error> errors = new ArrayList<>();
    
    private PnlSemantic pnlSemantic;
    
    private String currentClassName = "";
    
    private SymbolTable symbolTable = new SymbolTable();
    
    private FunctionTable functionTable = new FunctionTable();
    
    private Stack<String> functionCalls = new Stack<>();

    public DyslexiaSemanticErrorVisitor(PnlSemantic pnlSemantic) {
        this.pnlSemantic = pnlSemantic;
    }
    
    public void printSymbolTable(){
        pnlSemantic.println("SYMBOL TABLE START ");
        for(Symbol symbol : symbolTable.symbolTable){
            pnlSemantic.println("SYMBOL: " + symbol.toString());
        }
        pnlSemantic.println("SYMBOL TABLE END");
    }
    
    public void printFunctionTable(){
        pnlSemantic.println("FUNCTION TABLE START ");
        for(Function function : functionTable.functions) {
            pnlSemantic.println("Function: " + function.toString());
        }
        pnlSemantic.println("FUNCTION TABLE END");
    }
    
    public void printFunctionCalls(){
        pnlSemantic.println("FUNCTION CALLS START");
        for(String functionCall : functionCalls ){
            pnlSemantic.println("FunctionCall: " + functionCall);
        }
        pnlSemantic.println("FUNCTION CALLS END");
    }
    
    // root node
    @Override public ArrayList<Value> visitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        //errors.add(new Error(0, "DEBUGGING")); // to not evaluate program
        //pnlSemantic.println("DEBUGGING");
        // in symbol table add keywords so that it won't be able to be initialized as variables
        // in functionTable add keywords so that it won't be able to be initialized as functions
        visitChildren(ctx); // visit children
        //printSymbolTable();
        //printFunctionTable();
        //printFunctionCalls();
        return values; 
    }
    
    // Class Declaration
    @Override public ArrayList<Value> visitNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx) { 
        //System.out.println("CLASS IDENTIFIER: " + ctx.Identifier().getText() );
        this.currentClassName = ctx.Identifier().getText();
        return visitChildren(ctx); 
    }
    
    // Methods
    // methodDeclarator
    // This contains the identifier and the parameter list of the methods
    @Override public ArrayList<Value> visitMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx) { 
        //System.out.println("VISIT METHOD DECLARATOR: " + ctx.Identifier().getText());
        ArrayList<Value> values = new ArrayList<>();
        values.add(new Value("function", ctx.Identifier().getText()));
        if ( ctx.formalParameterList() != null ) values.addAll( visit(ctx.formalParameterList()) );
        return values; 
    }
    
    // methodHeader
    // contains the return type of the function and the methoddeclarator   
    @Override public ArrayList<Value> visitMethodHeader(DyslexiaParser.MethodHeaderContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        values.addAll(visit(ctx.methodDeclarator()));
        values.addAll(visit(ctx.result()));
        return values;
        //return visitChildren(ctx); 
    }
    
    // methodDeclaration
    // contains the nodes methodHeader and methodBody 
    @Override public ArrayList<Value> visitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx) { 
        ArrayList<Value> methodHeader = visit(ctx.methodHeader());
        Value functionName = ValueArrayList.getFunctionName(methodHeader);
        ArrayList<Value> functionParameters = ValueArrayList.getFunctionParameters(methodHeader);
        Value functionReturnType = ValueArrayList.getFunctionReturnType(methodHeader);
        System.out.println("Function Name: " + functionName.toString() );
        
        if ( !"niam".equals(functionName.getStringValue()) ) {
            // store functions that are not equal to niam
            // check first if function has already been defined
            Function duplicateFunction = functionTable.findFunction(functionName.getStringValue());
            if ( duplicateFunction != null )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Function already declared. Function name: '" + functionName.getStringValue() + "'"));
            LinkedList<Parameter> parameters = new LinkedList<>();
            for( Value parameter : functionParameters ){
                parameters.add( new Parameter(parameter.getStringValue(), parameter.getType()) );
                // for every parameter also add in symbol table of that function
                // will always have no right hand side
                String initializedValue = "";
                if ( "tni".equals(parameter.getType()) ) initializedValue = "0";
                else if ( "taolf".equals(parameter.getType()) ) initializedValue = "0.0";
                else if ( "elbuod".equals(parameter.getType()) ) initializedValue = "0.0";
                else if ( "rahc".equals(parameter.getType()) ) initializedValue = "0";
                else if ( "naeloob".equals(parameter.getType()) ) initializedValue = "eslaf";
                else if ( "gnirts".equals(parameter.getType()) ) initializedValue = "";
            
                Symbol symbol = new Symbol(parameter.getStringValue(), parameter.getType(), initializedValue, this.currentClassName, functionName.getStringValue());
                symbolTable.addSymbol(symbol);
            }
            Function function = new Function(functionName.getStringValue(), null, parameters, functionReturnType);
            functionTable.addFunction(function);
        } 
        
        
        this.functionCalls.push(functionName.getStringValue());
        visit(ctx.methodBody());
        return null;
    }
    
    // parameters of the function
    // formalParameterList_formalParameters
    @Override public ArrayList<Value> visitFormalParameterList_formalParameters(DyslexiaParser.FormalParameterList_formalParametersContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        values.addAll( visit(ctx.formalParameters()) );
        values.addAll( visit(ctx.lastFormalParameter()) );
        return values; 
    }
    
    // formalParameter
    @Override public ArrayList<Value> visitFormalParameter(DyslexiaParser.FormalParameterContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorId = visit(ctx.variableDeclaratorId());
        Value type = unannType.get(0);
        Value name = variableDeclaratorId.get(0);
        values.add(new Value(type.getStringValue(), name.getStringValue(), true));
        return values; 
    }
    
    // method of type void
    // visitResult_void
    @Override public ArrayList<Value> visitResult_void(DyslexiaParser.Result_voidContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        //String type = ctx.getText();
        values.add(new Value("type", "void") );
        return values; 
    }
    
    // Execution of method
    // methodInvocation
    // methodInvocation_methodName
    @Override public ArrayList<Value> visitMethodInvocation_methodName(DyslexiaParser.MethodInvocation_methodNameContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> methodNames = visit(ctx.methodName());
        ArrayList<Value> argumentList = new ArrayList<>();
        if ( ctx.argumentList() != null ) argumentList.addAll( visit(ctx.argumentList()) );
        
        Value methodName = methodNames.get(0);
        
        // argumentList can be list of variables
        System.out.println("METHOD NAME: " + methodName.toString() ); 
        System.out.println("START ARGUMENT LIST");
        for(Value value : argumentList ) {
            System.out.println(value.toString());
        }
        System.out.println("END LARGUMENT LIST");
        
        // check first if method name is tuptuo
        if ( "tuptuo".equals(methodName.getStringValue()) ){
            // only output
            /*
            for ( Value value : argumentList ) {
                if ( "variable".equals(value.getType()) ) {
                    Symbol symbol = symbolTable.findSymbol(value.getStringValue(), this.functionCalls.peek());
                    value = new Value(symbol.getType(), symbol.getSingleValue());
                }
            }
            */
        } else if ( "nltuptuo".equals(methodName.getStringValue()) ) {
            // output line
            /*
            for ( Value value : argumentList ) {
                if ( "variable".equals(value.getType()) ) {
                    Symbol symbol = symbolTable.findSymbol(value.getStringValue(), this.functionCalls.peek());
                    value = new Value(symbol.getType(), symbol.getSingleValue());
                }
            }
            */
        } else {
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            if ( functionCall != null ) {
                //int functionCallCount = FunctionTable.countFunctionInstance(functionCalls, functionCall.getName());
                //String functionCallInstance = functionCall.getName().concat("-" + functionCallCount);
                // check argument list if it is not empty
                if ( !argumentList.isEmpty() ){
                    // there are arguments
                    for(int i = 0; i < argumentList.size() ; i++) {
                        // all arguments should be put into the symbol table with the corresponding parameter
                        Parameter parameter = functionCall.getParameter(i);
                        Value argument = argumentList.get(i);
                        if ( "expressionName".equals(argument.getType()) ) {
                            // local symbol
                            Symbol localSymbol = symbolTable.findSymbol(argument.getStringValue(), this.currentClassName, this.functionCalls.peek());

                            // global symbol
                            Symbol globalSymbol = symbolTable.findSymbol(argument.getStringValue(), this.currentClassName, "");
                            
                            Symbol variable = null;
                            if ( localSymbol != null )
                                variable = localSymbol;
                            else
                                variable = globalSymbol;
                            
                            argument = new Value( variable.getType(), variable.getSingleValue() );
                        } 
                        
                        if ( parameter != null){
                        //System.out.println(" Parameter: " + parameter.toString());
                        //System.out.println(" Argument: " + argument.toString());
                        if ( !parameter.getType().equals(argument.getType()) )
                            errors.add(new Error(ctx.getStart().getLine(), "Error: Parameter Type mismatch. Function Parameter type: '" + parameter.getType() + "' Argument type: '" + argument.getType() + "'"));
                        //symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                        } else {
                            errors.add(new Error(ctx.getStart().getLine(), "Error: Too much arguments. Function Name: '" + methodName.getStringValue() + "'"));
                        }
                    }

                } else {
                    // if argument list is empty check if function needs additional parameters
                    // System.out.println(" FunctionCall parameters: " + (functionCall.getParameters().isEmpty()) );
                    if ( !functionCall.getParameters().isEmpty() )
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Calling function with parameters without arguments. Function name: '" + methodName.getStringValue() + "'"));
                }
            } else {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Function was not declared. Calling function: '" + methodName.getStringValue() + "'"));
            }
            
 
        }
        return values; 
    }
    
    // methodInvocation_lfno_primary_methodName
    @Override public ArrayList<Value> visitMethodInvocation_lfno_primary_methodName(DyslexiaParser.MethodInvocation_lfno_primary_methodNameContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> methodNames = visit(ctx.methodName());
        ArrayList<Value> argumentList = new ArrayList<>();
        if (ctx.argumentList() != null) argumentList = visit(ctx.argumentList());
        
        Value methodName = methodNames.get(0);
        
        if ( "tupni".equals(methodName.getStringValue()) ) {
            //String userInput = (String)JOptionPane.showInputDialog(this.frmDislexia,"Input:\n","Input",JOptionPane.PLAIN_MESSAGE,null, null, null);
            // use the argumentList for type
            //Value type = argumentList.get(0);
            
            // create in symbol table
            // get the value type of the user input
            //System.out.println("INPUT TYPE: " + type.toString());
            //values.add( new Value(, userInput));
            //values.add(new Value(methodName.getStringValue(), userInput));
        } else {
            // it is not an input method
            // when input is here it can be + + only returning the value up the tree
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            if ( functionCall != null ) {
                //int functionCallCount = FunctionTable.countFunctionInstance(functionCalls, functionCall.getName());
                //String functionCallInstance = functionCall.getName().concat("-" + functionCallCount);
                // check argument list if it is not empty
                if ( !argumentList.isEmpty() ){
                    // there are arguments
                    for(int i = 0; i < argumentList.size() ; i++) {
                        // all arguments should be put into the symbol table with the corresponding parameter
    
                        Parameter parameter = functionCall.getParameter(i);
                        Value argument = argumentList.get(i);
                        if ( "expressionName".equals(argument.getType()) ) {
                            // local symbol
                            Symbol localSymbol = symbolTable.findSymbol(argument.getStringValue(), this.currentClassName, this.functionCalls.peek());

                            // global symbol
                            Symbol globalSymbol = symbolTable.findSymbol(argument.getStringValue(), this.currentClassName, "");
                            
                            Symbol variable = null;
                            if ( localSymbol != null )
                                variable = localSymbol;
                            else
                                variable = globalSymbol;
                            
                            argument = new Value( variable.getType(), variable.getSingleValue() );
                        } 
                        
                        if ( parameter != null){
                        //System.out.println(" Parameter: " + parameter.toString());
                        //System.out.println(" Argument: " + argument.toString());
                        if ( !parameter.getType().equals(argument.getType()) )
                            errors.add(new Error(ctx.getStart().getLine(), "Error: Parameter Type mismatch. Function Parameter type: '" + parameter.getType() + "' Argument type: '" + argument.getType() + "'"));
                        //symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                        } else {
                            errors.add(new Error(ctx.getStart().getLine(), "Error: Too much arguments. Function Name: '" + methodName.getStringValue() + "'"));
                        }
                    }

                } else {
                    // if argument list is empty check if function needs additional parameters
                    // System.out.println(" FunctionCall parameters: " + (functionCall.getParameters().isEmpty()) );
                    if ( !functionCall.getParameters().isEmpty() )
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Calling function with parameters without arguments. Function name: '" + methodName.getStringValue() + "'"));
                }
                values.add(new Value(functionCall.getReturnValue().getStringValue()));
            } else {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Function was not declared. Calling function: '" + methodName.getStringValue() + "'"));
                values.add( new Value("llun", "llun"));
            }
        }
        return values; 
    }
    
    // methodName
    @Override public ArrayList<Value> visitMethodName(DyslexiaParser.MethodNameContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String functionName = ctx.Identifier().getText();
        values.add(new Value("function", functionName));
        return values; 
    }
    
    // argumentList
    @Override public ArrayList<Value> visitArgumentList(DyslexiaParser.ArgumentListContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        for( DyslexiaParser.ExpressionContext eCtx : ctx.expression() ) {
            values.addAll(visit(eCtx));
        }
        return values; 
    }
    
    // Declarations
    // localVariableDeclaration
    // This is to check if it is equal to the definition and to the type of the right hand side
    // only accepts one variable at the left hand side
    @Override public ArrayList<Value> visitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx) { 
        System.out.println("VISITING LOCAL VARIABLE DECLARATION");
        System.out.println("CODE: " + ctx.getText());
        //System.out.println("THIS IS LINE: " + ctx.getStart().getLine());
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.variableModifier().isEmpty() ) modifiers = visit(ctx.variableModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        Symbol duplicateSymbol = null;
        Symbol globalSymbol = null;
        String variableName = "";
        Value input = null;
        Value expression = null;
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        for( Value value : variableDeclaratorList ) {
            System.out.println(" variableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) input = value;
            else if ( "expressionName".equals(value.getType())) expression = value;
            else variableInitializer.add(value);
        }
        
        String definitionType = unannType.get(0).getStringValue();
        
        // before creating symbol check first if symbol exists
        duplicateSymbol = symbolTable.findSymbol(variableName, this.currentClassName, this.functionCalls.peek());
        
        // also check if global symbol exists
        globalSymbol = symbolTable.findSymbol(variableName, this.currentClassName, "");
        
        // before declaring 
        if ( globalSymbol != null ) {
            errors.add(new Error(ctx.getStart().getLine(), "Error: Variable '" + variableName + "' already globally declared use another name."));
        } else if( duplicateSymbol != null ) {
            errors.add( new Error( ctx.getStart().getLine(), "Error: Variable '" + variableName + "' already locally declared use another name."));
        } else if ( input != null ) {
            // double check type here of definition to input String
            symbol = new Symbol(variableName, definitionType, input.getStringValue(), this.currentClassName, this.functionCalls.peek());
        } else if ( expression != null ) {
            // local symbol
            Symbol localExpressionReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalExpressionReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol expressionReference = null;
            if ( localExpressionReference != null )
                expressionReference = localExpressionReference;
            else
                expressionReference = globalExpressionReference;
            
            if ( expressionReference != null){
                if ( !definitionType.equals(expressionReference.getType()) ){
                    errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch. DefinitionType: '" + definitionType + "' Reference Type: '" + expressionReference.getType() + "' Reference Variable Name: '" + expressionReference.getName() + "'"));
                } else {
                    System.out.println( " Expression Reference: " + expressionReference.toString() );
                    if ( modifiers.isEmpty() ) {
                        // no final modifier
                        symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, this.functionCalls.peek());
                    } else {
                        // with modifier
                        symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, this.functionCalls.peek(), true);
                    }
                }
                
            } else {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Variable is not declared. Variable Name: '" + expression.getStringValue() + "'"));
            }
            
        } else if ( variableInitializer.isEmpty() ) {
            // no right hand side
            String initializedValue = "";
            if ( "tni".equals(definitionType) ) initializedValue = "0";
            else if ( "taolf".equals(definitionType) ) initializedValue = "0.0";
            else if ( "elbuod".equals(definitionType) ) initializedValue = "0.0";
            else if ( "rahc".equals(definitionType) ) initializedValue = "0";
            else if ( "naeloob".equals(definitionType) ) initializedValue = "eslaf";
            else if ( "gnirts".equals(definitionType) ) initializedValue = "";
            
            
            symbol = new Symbol(variableName, definitionType, initializedValue, this.currentClassName, this.functionCalls.peek());
        } else if ( variableInitializer.size() == 1) { 
            // check first if definitionType is equal to the literal on the right side
            //System.out.println("definitionType: " + definitionType + " Right side literal type: " + variableInitializer.get(0).getType());
            //System.out.println("!definitionType.equals(variableInitializer.get(0).getType()): " + !definitionType.equals(variableInitializer.get(0).getType()));
            
            if ( !definitionType.equals(variableInitializer.get(0).getType())) {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Incompatible types definitionType: '" + definitionType + "' Value literal: '" + variableInitializer.get(0).getType() + "' Value: '" + variableInitializer.get(0).getStringValue() + "'"));
            }
            
            // only 1 variable
            if ( modifiers.isEmpty() ) {
                // no final modifier
                symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek());
            } else {
                // with modifier
                symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek(), true);
            }
        } else {
            // It is an arrayType
            //System.out.println("IT IS AN ARRAY TYPE");
            String[] strings = new String[variableInitializer.size()];
            boolean declareArray = true;
            for(Value value : variableInitializer ){
                if ( !definitionType.equals(value.getType())) {
                    errors.add(new Error(ctx.getStart().getLine(), "Error: Incompatible types. DefinitionType: '" + definitionType + "' Value literal: '" + value.getType() + "' Value: '" +  value.getStringValue() + "'"));
                    declareArray = false;
                }
            }
            
            if ( declareArray ){
                for(int i = 0; i < strings.length; i++ ) {
                    //System.out.println("variableInitializer: " + variableInitializer.get(i).getStringValue());
                    strings[i] = variableInitializer.get(i).getStringValue();
                }

                symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, this.functionCalls.peek());
            }
            
        }
        
        if ( symbol != null)
            symbolTable.addSymbol(symbol);
        
        System.out.println("VISITED LOCAL VARIABLE DECLARATION");
        return null;
    }
    
    // variableDeclarator
    @Override public ArrayList<Value> visitVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx) { 
        // Pass both variable identifier and the right hand side
        ArrayList<Value> values = new ArrayList<>();
        values.addAll(visit(ctx.variableDeclaratorId()));
        // If there is right hand side
        if ( ctx.variableInitializer() != null ) values.addAll(visit(ctx.variableInitializer()));
        return values; 
    }
    
    // variableDeclaratorId
    @Override public ArrayList<Value> visitVariableDeclaratorId(DyslexiaParser.VariableDeclaratorIdContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        values.add( new Value("variable", ctx.Identifier().getText()) );
        return values;
        //return null;
        //return visitChildren(ctx); 
    }
    
    // variableInitializerList
    // being used for arrays
    @Override public ArrayList<Value> visitVariableInitializerList(DyslexiaParser.VariableInitializerListContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        if ( ctx.variableInitializer() != null ) {
            for( DyslexiaParser.VariableInitializerContext viCtx : ctx.variableInitializer()){
                values.addAll(visit(viCtx));
            }
        }
        return values; 
    }
    
    // arrayInitializer
    @Override public ArrayList<Value> visitArrayInitializer(DyslexiaParser.ArrayInitializerContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        if ( ctx.variableInitializerList() != null ) values.addAll(visit(ctx.variableInitializerList()));
        return values; 
    }
    
    // arrayAccess
    @Override public ArrayList<Value> visitArrayAccess(DyslexiaParser.ArrayAccessContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        Value variableName = visit(ctx.expressionName()).get(0);
        Value expression = visit(ctx.expression(0)).get(0);
        values.add(variableName);
        // before adding expression make sure that it is type int
        values.add(new Value("index", expression.getStringValue()));
        return values; 
    }
    
    // arrayAccess_lfno_primary
    @Override public ArrayList<Value> visitArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx) { 
        System.out.println("VISITING ARRAY ACCESS LFNO PRIMARY");
        ArrayList<Value> values = new ArrayList<>();
        Value variableName = visit(ctx.expressionName()).get(0);
        Value expression = visit(ctx.expression(0)).get(0);
        
        System.out.println(" EXPRESSION: " + expression.toString());
        
        // local symbol
        Symbol localSymbol = symbolTable.findSymbol(variableName.getStringValue(), this.currentClassName, this.functionCalls.peek());
        
        // global symbol
        Symbol globalSymbol = symbolTable.findSymbol(variableName.getStringValue(), this.currentClassName, "");
        
        Symbol symbol = null;
        if ( localSymbol != null)
            symbol = localSymbol;
        else
            symbol = globalSymbol;
        
        // if the expression inside the 
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localVariable = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalVariable = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");
            
            Symbol variable = null;
            if ( localVariable != null )
                variable = localVariable;
            else
                variable = globalVariable;
            int index = Integer.parseInt(variable.getSingleValue());
            int maxArraySize = symbol.getMultiValue().length - 1;
            if ( index < 0 )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Minimum array index: 0"));
            else if ( index > maxArraySize )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Maximum array index: '" + maxArraySize + "'"));
            else
                values.add( new Value(symbol.getType(), symbol.getMultiValue()[index]));
        } else {
            int index = Integer.valueOf(expression.getStringValue());
            int maxArraySize = symbol.getMultiValue().length - 1;
            if ( index < 0 )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Minimum array index: 0"));
            else if ( index > maxArraySize )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Maximum array index: '" + maxArraySize + "'"));
            else
                values.add( new Value(symbol.getType(), symbol.getMultiValue()[expression.getIntValue()]));
        }
        
        System.out.println("VISITED ARRAY ACCESS LFNO PRIMARY");
        return values; 
    }
    
    // Fields
    // global variable
    @Override public ArrayList<Value> visitFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx) { 
        System.out.println("VISITING FIELD DECLARATION");
        System.out.println("CODE: " + ctx.getText());
        //System.out.println("THIS IS LINE: " + ctx.getStart().getLine());
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.fieldModifier().isEmpty() ) modifiers = visit(ctx.fieldModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        Symbol duplicateSymbol = null;
        String variableName = "";
        Value input = null;
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        Value expression = null;
        for( Value value : variableDeclaratorList ) {
            //System.out.println("variableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) input = value;
            else if ( "expressionName".equals(value.getType())) expression = value;
            else variableInitializer.add(value);
        }
        
        String definitionType = unannType.get(0).getStringValue();
        
        // before creating symbol check first if symbol exists
        duplicateSymbol = symbolTable.findSymbol(variableName, this.currentClassName, "");
        
        // before declaring 
        if( duplicateSymbol != null ) {
            errors.add( new Error( ctx.getStart().getLine(), "Error: Variable '" + variableName + "' already declared use another name."));
        } else if ( input != null ) {
            // double check type here of definition to input String
            symbol = new Symbol(variableName, definitionType, input.getStringValue(), this.currentClassName, "");
        } else if ( expression != null ) {
            // global symbol
            Symbol globalExpressionReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol expressionReference = null;

            expressionReference = globalExpressionReference;
            
            if ( expressionReference != null){
                if ( !definitionType.equals(expressionReference.getType()) ){
                    errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch. DefinitionType: '" + definitionType + "' Reference Type: '" + expressionReference.getType() + "' Reference Variable Name: '" + expressionReference.getName() + "'"));
                } else {
                    System.out.println( " Expression Reference: " + expressionReference.toString() );
                    if ( modifiers.isEmpty() ) {
                        // no final modifier
                        symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, "");
                    } else {
                        // with modifier
                        symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, "", true);
                    }
                }
                
            } else {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Variable is not declared. Variable Name: '" + expression.getStringValue() + "'"));
            }

        } else if ( variableInitializer.isEmpty() ) {
            // no right hand side
            String initializedValue = "";
            if ( "tni".equals(definitionType) ) initializedValue = "0";
            else if ( "taolf".equals(definitionType) ) initializedValue = "0.0";
            else if ( "elbuod".equals(definitionType) ) initializedValue = "0.0";
            else if ( "rahc".equals(definitionType) ) initializedValue = "0";
            else if ( "naeloob".equals(definitionType) ) initializedValue = "eslaf";
            else if ( "gnirts".equals(definitionType) ) initializedValue = "";
            
            
            symbol = new Symbol(variableName, definitionType, initializedValue, this.currentClassName, "");
        } else if ( variableInitializer.size() == 1) { 
            // check first if definitionType is equal to the literal on the right side
            //System.out.println("definitionType: " + definitionType + " Right side literal type: " + variableInitializer.get(0).getType());
            //System.out.println("!definitionType.equals(variableInitializer.get(0).getType()): " + !definitionType.equals(variableInitializer.get(0).getType()));
            if ( !definitionType.equals(variableInitializer.get(0).getType())) {
                errors.add(new Error(ctx.getStart().getLine(), "Error: Incompatible types definitionType: '" + definitionType + "' Value literal: '" + variableInitializer.get(0).getType() + "' Value: '" + variableInitializer.get(0).getStringValue() + "'"));
            }
            
            // only 1 variable
            if ( modifiers.isEmpty() ) {
                // no final modifier
                symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, "");
            } else {
                // with modifier
                symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, "", true);
            }
        } else {
            // It is an arrayType
            //System.out.println("IT IS AN ARRAY TYPE");
            String[] strings = new String[variableInitializer.size()];
            boolean declareArray = true;
            for(Value value : variableInitializer ){
                if ( !definitionType.equals(value.getType())) {
                    errors.add(new Error(ctx.getStart().getLine(), "Error: Incompatible types. DefinitionType: '" + definitionType + "' Value literal: '" + value.getType() + "' Value: '" +  value.getStringValue() + "'"));
                    declareArray = false;
                }
            }
            
            if ( declareArray ){
                for(int i = 0; i < strings.length; i++ ) {
                    //System.out.println("variableInitializer: " + variableInitializer.get(i).getStringValue());
                    strings[i] = variableInitializer.get(i).getStringValue();
                }

                symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, "");
            }
        }
        
        if ( symbol != null)
            symbolTable.addSymbol(symbol);
        
        System.out.println("VISITED FIELD DECLARATION");
        return null;
    }
    
    
    // fieldModifier
    @Override public ArrayList<Value> visitFieldModifier_final(DyslexiaParser.FieldModifier_finalContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String modifier = ctx.getText();
        values.add(new Value("modifier", modifier));
        return values; 
    }
    
    // Assignments
    // assignment
    @Override public ArrayList<Value> visitAssignment(DyslexiaParser.AssignmentContext ctx) { 
        System.out.println("VISITING ASSIGNMENT STATEMENT");
        System.out.println("CODE: " + ctx.getText());
        // also check if variable exists in symbol table before executing
        ArrayList<Value> values = new ArrayList<Value>();
        ArrayList<Value> leftHandSide = visit(ctx.leftHandSide());
        Value expression = visit(ctx.expression()).get(0);
        Symbol symbol = null;
        
        //System.out.println(" START LEFT HAND SIDE ");
        //for(Value value : leftHandSide ){
        //    System.out.println("  LEFTHANDSIDE: " + value.toString());
        //}
        //System.out.println(" END LEFT HAND SIDE ");
        
        System.out.println(" leftHandSide.get(0): " + leftHandSide.get(0).toString() );
        
        try{
            symbol = symbolTable.findSymbol(leftHandSide.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek());
        } catch (NullPointerException e) {
            
        }
        
        if ( symbol == null ) {
            try {
                symbol = symbolTable.findSymbol(leftHandSide.get(0).getStringValue(), this.currentClassName, "");
            } catch (NullPointerException e ) {
                
            }
        }
        
        // check first if symbol is final then do not execute assignment statement and add error
        Symbol variableReference = null;
        Symbol newSymbol = null;

        // if symbol is still null it wasn't declared
        if ( "expressionName".equals(expression.getType()) )  {
            // If it is local
            variableReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());
            if ( variableReference == null ) // If it is global
                variableReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");
        }

        //System.out.println(" Expression" + expression.toString());
        //System.out.println(" VariableReference: " + variableReference.toString());



        //System.out.println.println("Assignment Statement: ");
        //pnlConsole.println("Replacing Symbol: " + symbol.toString());
        // if variable is final do not execute next statements??????
        if ( symbol == null) { // show variable is not declared
            errors.add(new Error(ctx.getStart().getLine(), "Error: Variable not declared. Variable Name: '" + leftHandSide.get(0).getStringValue() + "'"));
        } else {
            if ( symbol.isFinal ){
                 errors.add(new Error(ctx.getStart().getLine(), "Error: Variable is final. Assignment not valid. VariableName: '" + symbol.getName() + "'"));
            }
        }
        
        if ( leftHandSide.size() > 1 ) { 
            // leftHandSide is an array and has index
            System.out.println(" ARRAY ACCESS");
            int index = Integer.valueOf(leftHandSide.get(1).getStringValue());
            String[] strings = new String[symbol.getMultiValue().length];
            
            for (int i = 0; i < strings.length;  i++ ) {
                if ( i == index )
                    strings[i] = expression.getStringValue();
                else
                    strings[i] = symbol.getMultiValue()[i];
            }
            
            System.out.println(" ARRAY INDEX: " + index);
            System.out.println(" MAX ARRAY SIZE: " + symbol.getMultiValue().length);
            int maxArraySize = symbol.getMultiValue().length - 1;
            
            if ( index < 0 )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Minimum array index: 0"));
            else if ( index > maxArraySize )
                errors.add(new Error(ctx.getStart().getLine(), "Error: Array out of bounds of index: '" + index + "' Maximum array index: '" + maxArraySize + "'"));
            
            System.out.println(" expression: " + expression.toString());
            System.out.println(" variableReference is null: " + (variableReference == null));
            if ( variableReference != null ) System.out.println( " Variable reference " + variableReference.toString());
            
            if ( symbol != null ){
                if ( variableReference != null) {
                    // check data type mismatch
                    if ( !symbol.getType().equals(variableReference.getType()) )
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch."));
                } else if ( variableReference == null && !"expressionName".equals(expression.getType())) {
                    if ( !symbol.getType().equals(expression.getType()))
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch."));
                } else if ( variableReference == null && "expressionName".equals(expression.getType()) ){
                    errors.add(new Error(ctx.getStart().getLine(), "Error: Variable not declared. Variable Name: '" + expression.getStringValue() + "'"));
                }
            } 
        } else {
            // leftHandSide only contains 1 expresion
            if ( symbol != null ){
                if ( variableReference != null) {
                    // check data type mismatch
                    if ( !symbol.getType().equals(variableReference.getType()) )
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch."));
                } else if ( variableReference == null && !"expressionName".equals(expression.getType())) {
                    if ( !symbol.getType().equals(expression.getType()))
                        errors.add(new Error(ctx.getStart().getLine(), "Error: Data type mismatch."));
                }
            } else if ( variableReference == null && "expressionName".equals(expression.getType()) ){
                 errors.add(new Error(ctx.getStart().getLine(), "Error: Variable not declared. Variable Name: '" + expression.getStringValue() + "'"));
            }
        }        

        System.out.println("VISITED ASSIGNMENT STATEMENT");
        return values; 
    }
    
    // expressionName
    // expressionName_Identifier
    @Override public ArrayList<Value> visitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        
        // Don't check symbol table yet just return
        String identifier = ctx.Identifier().getText();
        System.out.println("EXPRESSION IDENTIFIER: " + identifier);
        values.add( new Value("expressionName", identifier) );
        return values; 
    }
    
    // unaryExpressions
    // - ( unaryExpression )
    @Override public ArrayList<Value> visitUnaryExpression_minusUnaryExpression(DyslexiaParser.UnaryExpression_minusUnaryExpressionContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        // check first if value is variable
        Value expression = visit(ctx.unaryExpression()).get(0);
        
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            values.add(new Value(variable.getType(), "-".concat(variable.getSingleValue()) ));
        } else
            values.add(new Value(expression.getType(), "-".concat(expression.getStringValue())));
        return values; 
    }
    
    // Grouping Symbols
    // ( expression )
    // primaryNoNewArray_lfno_primary_expression
    @Override public ArrayList<Value> visitPrimaryNoNewArray_lfno_primary_expression(DyslexiaParser.PrimaryNoNewArray_lfno_primary_expressionContext ctx) { 
        return visit(ctx.expression()); 
    }
    
    // Data Types
    // integralType
    @Override public ArrayList<Value> visitIntegralType(DyslexiaParser.IntegralTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        values.add(new Value("type", type));
        return values;
    }
    
    // floatingPointType
    @Override public ArrayList<Value> visitFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        values.add( new Value("type", type) );
        return values;
    }
    
    // unannPrimitiveType_boolean
    @Override public ArrayList<Value> visitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        values.add( new Value("type", type) );
        return values;
    }
    
    // String type
    @Override public ArrayList<Value> visitUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.Identifier().getText();
        values.add( new Value("type", type) );
        return values; 
    }
    
    // Data Type Modifier
    // final
    @Override public ArrayList<Value> visitVariableModifier_final(DyslexiaParser.VariableModifier_finalContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        values.add( new Value("type", "lanif") );
        return values;
    }
    
    
    
    // array
    @Override public ArrayList<Value> visitUnannArrayType(DyslexiaParser.UnannArrayTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        
        if ( ctx.unannPrimitiveType() != null ) {
            Value value = visit(ctx.unannPrimitiveType()).get(0);
            values.add( new Value ("array", value.getStringValue()) );
        }
        
        return values; 
    }
    
    // Literals
    @Override public ArrayList<Value> visitIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String intText = ctx.IntegerLiteral().getText();
        values.add( new Value("tni", intText) );
        return values; 
    }
    
    @Override public ArrayList<Value> visitFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String floatText = ctx.FloatingPointLiteral().getText();
        values.add( new Value("taolf", floatText) );
        return values; 
    }
    
    @Override public ArrayList<Value> visitBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String booleanText = ctx.BooleanLiteral().getText();
        if ( "eurt".equals(booleanText) ) values.add( new Value("naeloob", "eurt") );
        else values.add( new Value("naeloob", "eslaf") );
        return values;
    }
    
    @Override public ArrayList<Value> visitCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String charText = ctx.CharacterLiteral().getText();
        values.add( new Value("rahc", charText) );
        return values; 
    }
    
    @Override public ArrayList<Value> visitStringLiteral(DyslexiaParser.StringLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String stringText = ctx.StringLiteral().getText();
        values.add( new Value("gnirts", stringText) );
        return values; 
    }
    
    @Override public ArrayList<Value> visitNullLiteral(DyslexiaParser.NullLiteralContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        values.add( new Value("llun", "null") );
        return values; 
    }
}
