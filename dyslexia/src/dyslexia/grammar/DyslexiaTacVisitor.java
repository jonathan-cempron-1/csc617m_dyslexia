/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.gui.FrmDislexia;
import dyslexia.gui.PnlTac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Gaming
 */
public class DyslexiaTacVisitor extends DyslexiaBaseVisitor<ArrayList<Value>> {
    // GUI Components
    private PnlTac pnlTac;
    
    // Class Variables
    private String currentClassName = "";
    
    private Stack<Symbol> tempSymbols = new Stack<>();
    private Stack<Integer> tempSymbolCount = new Stack<>();
    
    // symbolTable
    private SymbolTable symbolTable = new SymbolTable();
    
    // functionTable
    private FunctionTable functionTable = new FunctionTable();
    private Stack<String> functionCalls = new Stack<>();
    
    private Stack<String> label = new Stack<>();
    private Stack<Integer> labelCount = new Stack<>();
    
    private Stack<Integer> ifCount = new Stack<>();
    
    private Stack<Integer> whileCount = new Stack<>();
    
    private Stack<String> currentFunctionReturn = new Stack<>();
    
    public DyslexiaTacVisitor(FrmDislexia frmDislexia) {
        this.pnlTac = frmDislexia.pnlTac;
    }
    
    // root node
    @Override public ArrayList<Value> visitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        // initialize global variables
        labelCount.push(0);
        tempSymbolCount.push(0);
        ifCount.push(0);
        whileCount.push(0);
        System.out.println(" ----- GENERATING THREE ADDRESS CODE ----- ");
        pnlTac.println("GENERATING THREE ADDRESS CODE");
        visitChildren(ctx);
        
        pnlTac.println("L " + labelCount.peek() + ": ");
        
        pnlTac.println("GENERATED THREE ADDRESS CODE");
        System.out.println(" ----- GENERATED THREE ADDRESS CODE ----- ");
        
        return values; 
    }
    
    // Fields
    // global variable
    @Override public ArrayList<Value> visitFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx) { 
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.fieldModifier().isEmpty() ) modifiers = visit(ctx.fieldModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        
        String variableName = "";
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        Value input = null;
        for( Value value : variableDeclaratorList ) {
            //System.out.println("varuableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) input = value;
            else variableInitializer.add(value);
        }
        
        //System.out.println("INPUT STRING: " + inputString + " EQUALS() " + inputString.equals("") + " !EQUALS(): " + !inputString.equals(""));
        //System.out.println("VARIABLE INITIALIZER: " + variableInitializer.isEmpty() );
        
        String definitionType = unannType.get(0).getStringValue();
        
        
        if ( input != null ) {
            // double check type here of definition to input String
            //symbol = new Symbol(variableName, definitionType, input.getStringValue(), this.currentClassName, "");
        } else if ( variableInitializer.isEmpty() ) {
            // no right hand side
            String initializedValue = "";
            if ( "tni".equals(definitionType) ) initializedValue = "0";
            else if ( "taolf".equals(definitionType) ) initializedValue = "0.0";
            else if ( "elbuod".equals(definitionType) ) initializedValue = "0.0";
            else if ( "rahc".equals(definitionType) ) initializedValue = "0";
            else if ( "naeloob".equals(definitionType) ) initializedValue = "eslaf";
            else if ( "gnirts".equals(definitionType) ) initializedValue = "";
            
            //symbol = new Symbol(variableName, definitionType, initializedValue, this.currentClassName, "");
        } else if ( variableInitializer.size() == 1) { 
            // only 1 variable
           
        } else {
            // It is an arrayType
            String[] strings = new String[variableInitializer.size()];
            
            for(int i = 0; i < strings.length; i++ ) {
                strings[i] = variableInitializer.get(i).getStringValue();
            }
            
            //symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, "");
        }
        
        //symbolTable.addSymbol(symbol);
        //pnlConsole.println("Declared Symbol: " + symbol.toString());
        
        if ( variableDeclaratorList.size() > 1 )
            pnlTac.println("L" + labelCount.peek() + ": " + variableName + " = " + variableDeclaratorList.get(1).getStringValue() );
        else // there is no initialization example tni i;
            pnlTac.println("L" + labelCount.peek() + ": " + variableName + " = " + variableDeclaratorList.get(0).getStringValue() );
        labelCount.push(labelCount.peek() + 1);
        
        return null;
    }
    
    // Methods
    // methodDeclaration
    // contains the nodes methodHeader and methodBody 
    @Override public ArrayList<Value> visitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx) { 
        System.out.println("VISITING METHOD DECLARATION");
        // Check first if name is equal to niam then execute
        // TODO: Functions get method body and function name and save to another list;
        ArrayList<Value> methodHeader = visit(ctx.methodHeader());
        Value functionName = ValueArrayList.getFunctionName(methodHeader);
        ArrayList<Value> functionParameters = ValueArrayList.getFunctionParameters(methodHeader);
        Value functionReturnType = ValueArrayList.getFunctionReturnType(methodHeader);
        
        //System.out.println("Function Name: " + functionName.toString() );
        
        if ( "niam".equals(functionName.getStringValue()) ) {
            // push function into functionString stack
            //this.functionCalls.peek() = functionName.getStringValue();
            pnlTac.println("L" + labelCount.peek() + ": main:");
            labelCount.push(labelCount.peek() + 1);
            this.functionCalls.push(functionName.getStringValue());
            return visit(ctx.methodBody());
        } else {
            // store function
            
            LinkedList<Parameter> parameters = new LinkedList<>();
            for( Value parameter : functionParameters ){
                parameters.add( new Parameter(parameter.getStringValue(), parameter.getType()) );
            }
            Function function = new Function(functionName.getStringValue(), null, parameters, functionReturnType);
            functionTable.addFunction(function);
            
            
            // create strings
            String functionReturn = functionName.getStringValue().concat("ret");
            
            currentFunctionReturn.push(functionReturn);
            
            ArrayList<String> functionArguments = new ArrayList<>();
            
            for( Value parameter : functionParameters ){
                // get parameter type to initialize properly
                functionArguments.add(functionName.getStringValue().concat("Arg").concat(parameter.getStringValue()));
            }
            
            // print return value
            pnlTac.println("L" + labelCount.peek() + ": " + functionReturn + " = 0");
            labelCount.push(labelCount.peek() + 1);
            
            for(String functionArgument : functionArguments){
                pnlTac.println("L" + labelCount.peek() + ": " + functionArgument + " = 0");
                labelCount.push(labelCount.peek() + 1);
            }
            
            pnlTac.println("L " + labelCount.peek() + ": " + functionName.getStringValue() + ":" );
            labelCount.push(labelCount.peek() + 1);
            visit(ctx.methodBody());
     
            currentFunctionReturn.pop();
        }
        System.out.println("VISITED METHOD DECLARATION");
        return null;
        //return visitChildren(ctx); 
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
            values.add(new Value("input", "input()"));
        } else {
            // it is not an input method
            // when input is here it can be + + only returning the value up the tree
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            
            //int functionCallCount = FunctionTable.countFunctionInstance(functionCalls, functionCall.getName());
            //String functionCallInstance = functionCall.getName().concat("-" + functionCallCount);
            
            // check argument list
            if ( !argumentList.isEmpty() ){
                // there are arguments
                for(int i = 0; i < argumentList.size() ; i++) {
                    // all arguments should be put into the symbol table with the corresponding parameter
                    Parameter parameter = functionCall.getParameter(i);
                    Value argument = argumentList.get(i);
                    //if ( "variable".equals(argument.getType()) ) {
                    //    Symbol variable = symbolTable.findSymbol(argument.getStringValue(), this.functionCalls.peek());
                    //    argument = new Value( variable.getType(), variable.getSingleValue() );
                    //} 
                    //symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                    pnlTac.println("L" + labelCount.peek() + " " + functionCall.getName().concat("Arg").concat(parameter.getName()) + " = " + argument.getStringValue());
                    labelCount.push(labelCount.peek() + 1);
                }
            }
            
            int jumpReturnAddress = labelCount.peek() + 1;
            pnlTac.println("L" + labelCount.peek() + ": L" + jumpReturnAddress + " = ipstack.push");
            labelCount.push(labelCount.peek() + 1);
            
            // pass up the return value of the function
            values.add(new Value("return", functionCall.getName().concat("Ret")));
            //this.functionCalls.push(functionCallInstance);
            // execute the body
            // check the value returned
            //ArrayList<Value> returnValues = visit(functionCall.getMethodBodyContextCtx());
            // only 1 return value
            //if ( !returnValues.isEmpty() ){
            //    Value returnValue = returnValues.get(0);
            //    values.add(returnValue);
            //}
            // pop the function call
            //this.functionCalls.pop();
            // clear the symbol table
            //symbolTable.removeSymbols(this.currentClassName, functionCallInstance);
            //System.out.println("Function is not output");
        }
        return values; 
    }
    
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
            for ( Value value : argumentList ) {
                if ( "variable".equals(value.getType()) ) {
                    //Symbol symbol = symbolTable.findSymbol(value.getStringValue(), this.functionCalls.peek());
                    //value = new Value(symbol.getType(), symbol.getSingleValue());
                    pnlTac.println("L" + labelCount.peek() + ": " + value.getStringValue() + " = output()");
                    labelCount.push(labelCount.peek() + 1);
                    
                } else {
                    
                    pnlTac.println("L" + labelCount.peek() + ": t" + tempSymbolCount.peek() + " = " + value.getStringValue());
                    labelCount.push(labelCount.peek() + 1);
                    pnlTac.println("L" + labelCount.peek() + ": t" + tempSymbolCount.peek() + " = output()");
                    labelCount.push(labelCount.peek() + 1);
                    
                    tempSymbolCount.push(tempSymbolCount.peek() + 1);
                }
            }
        } else if ( "nltuptuo".equals(methodName.getStringValue()) ) {
            // output line
            for ( Value value : argumentList ) {
               if ( "variable".equals(value.getType()) ) {
                    //Symbol symbol = symbolTable.findSymbol(value.getStringValue(), this.functionCalls.peek());
                    //value = new Value(symbol.getType(), symbol.getSingleValue());
                    pnlTac.println("L" + labelCount.peek() + ": " + value.getStringValue() + " = outputln()");
                    labelCount.push(labelCount.peek() + 1);
                    
                } else {
                    
                    pnlTac.println("L" + labelCount.peek() + ": t" + tempSymbolCount.peek() + " = " + value.getStringValue());
                    labelCount.push(labelCount.peek() + 1);
                    pnlTac.println("L" + labelCount.peek() + ": t" + tempSymbolCount.peek() + " = outputln()");
                    labelCount.push(labelCount.peek() + 1);
                    
                    tempSymbolCount.push(tempSymbolCount.peek() + 1);
                }
            }
        } else {
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            
            // check argument list
            if ( !argumentList.isEmpty() ){
                // there are arguments
                for(int i = 0; i < argumentList.size() ; i++) {
                    // all arguments should be put into the symbol table with the corresponding parameter
                    Parameter parameter = functionCall.getParameter(i);
                    Value argument = argumentList.get(i);
                    //if ( "variable".equals(argument.getType()) ) {
                    //    Symbol variable = symbolTable.findSymbol(argument.getStringValue(), this.functionCalls.peek());
                    //    argument = new Value( variable.getType(), variable.getSingleValue() );
                    //} 
                    //symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                    pnlTac.println("L" + labelCount.peek() + " " + functionCall.getName().concat("Arg").concat(parameter.getName()) + " = " + argument.getStringValue());
                    labelCount.push(labelCount.peek() + 1);
                }
            
            }
            
            int jumpReturnAddress = labelCount.peek() + 1;
            pnlTac.println("L" + labelCount.peek() + ": L" + jumpReturnAddress + " = ipstack.push");
            labelCount.push(labelCount.peek() + 1);
            
            //this.functionCalls.push(functionCallInstance);
            // execute the body
            // check the value returned
            //ArrayList<Value> returnValues = visit(functionCall.getMethodBodyContextCtx());
            // only 1 return value
            
            // ( !returnValues.isEmpty() ) {
            //    Value returnValue = returnValues.get(0);
            //    values.add(returnValue);
            //}
            // pop the function call
            //this.functionCalls.pop();
            // clear the symbol table
            //symbolTable.removeSymbols(this.currentClassName, functionCallInstance);
            //System.out.println("Function is not output");
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
    
    // returnStatement
    @Override public ArrayList<Value> visitReturnStatement(DyslexiaParser.ReturnStatementContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions = visit(ctx.expression());
        
        //values.addAll( expressions );
        pnlTac.println("L" + labelCount.peek() + ": " + currentFunctionReturn.peek() + " = " + expressions.get(0).getStringValue());
        labelCount.push(labelCount.peek() + 1);
       
        pnlTac.println("L" + labelCount.peek() + ": retaddr = ipstack.pop");
        labelCount.push(labelCount.peek() + 1);
            
        pnlTac.println("L" + labelCount.peek() + ": jump retaddr");
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // Loops
    // whileStatement
    @Override public ArrayList<Value> visitWhileStatement(DyslexiaParser.WhileStatementContext ctx) { 
        ArrayList<Value> values = new ArrayList<>(); 
        ArrayList<Value> expressions = visit(ctx.expression());
        Value expression = expressions.get(0);
        
        int currentWhileCount = whileCount.peek();
        int currentIfCount = ifCount.peek();
        
        pnlTac.println("L" + labelCount.peek() + ": w" + currentWhileCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": jumpfalse " + expression.getStringValue() + ", if" + currentIfCount);
        labelCount.push(labelCount.peek() + 1);
        visit(ctx.statement());
        
        
        pnlTac.println("L" + labelCount.peek() + ": jump w" + currentWhileCount);
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": if" + currentIfCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        ifCount.push(ifCount.peek() + 1);
        whileCount.push(whileCount.peek() + 1);
        return null;
    }
    
    // doStatement
    @Override public ArrayList<Value> visitDoStatement(DyslexiaParser.DoStatementContext ctx) { 
        ArrayList<Value> values = new ArrayList<>(); 
        ArrayList<Value> expressions;
        Value expression;
        
        // print statements first
        visit(ctx.statement());
        
        // get expression
        expressions = visit(ctx.expression());
        expression = expressions.get(0);
        
        int currentWhileCount = whileCount.peek();
        int currentIfCount = ifCount.peek();
        
        pnlTac.println("L" + labelCount.peek() + ": w" + currentWhileCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": jumpfalse " + expression.getStringValue() + ", if" + currentIfCount );
        labelCount.push(labelCount.peek() + 1);
        visit(ctx.statement());
        
        pnlTac.println("L" + labelCount.peek() + ": jump w" + currentWhileCount);
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": if" + currentIfCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        ifCount.push(ifCount.peek() + 1);
        whileCount.push(whileCount.peek() + 1);
        
        return null;
    }
    
    // basicForStatement
    @Override public ArrayList<Value> visitBasicForStatement(DyslexiaParser.BasicForStatementContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions;
        Value expression;
        
        int currentWhileCount = whileCount.peek();
        int currentIfCount = ifCount.peek();
        
        // visit initialization
        visit(ctx.forInit());
        
         // visit expression
        expressions = visit(ctx.expression());
        expression = expressions.get(0);
        
        
        pnlTac.println("L" + labelCount.peek() + ": w" + currentWhileCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": jumpfalse " + expression.getStringValue() + ", if" + currentIfCount);
        labelCount.push(labelCount.peek() + 1);
        visit(ctx.statement());
        visit(ctx.forUpdate());
        pnlTac.println("L" + labelCount.peek() + ": jump w" + currentWhileCount);
        labelCount.push(labelCount.peek() + 1);
        
        pnlTac.println("L" + labelCount.peek() + ": if" + currentIfCount + ":");
        labelCount.push(labelCount.peek() + 1);
        
        ifCount.push(ifCount.peek() + 1);
        whileCount.push(whileCount.peek() + 1);
        return null; 
    }
    
    // IfThen Statememnts
    // ifThenStatement
    @Override public ArrayList<Value> visitIfThenStatement(DyslexiaParser.IfThenStatementContext ctx) { 
        System.out.println("VISITING IFTHENSTATEMENT");
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions = visit(ctx.expression());
        Value expression = expressions.get(0);
        
        
        // check if expression is a variable
        //if ( "variable".equals(expression.getType()) ) {
        //    Symbol symbol = symbolTable.findSymbol(expression.getStringValue(), this.functionCalls.peek());
        //    expression = new Value(symbol.getType(), symbol.getSingleValue() );
            //System.out.println(" SYMBOL: " + symbol.toString());
        //}
        
        
        System.out.println(" IFTHEN EXPRESSION: " + expression.toString() );
        
        //if ( "boolean".equals(expression.getType()) && ( true == expression.getBooleanValue() ) ) {
        //   ArrayList<Value> statement = visit(ctx.statement());
        //    if ( statement != null ) values.addAll(statement);
        //}
        
        int currentIfCount = ifCount.peek();
        
        pnlTac.println("L" + labelCount.peek() + ": jumpfalse " + expression.getStringValue() + ", if" + currentIfCount );
        labelCount.push(labelCount.peek() + 1);
        visit(ctx.statement());
        pnlTac.println("L" + labelCount.peek() + ": if" + currentIfCount + ": ");
        labelCount.push(labelCount.peek() + 1);
        
        // adding of global functions
        ifCount.push(ifCount.peek() + 1);
        System.out.println("VISITED IFTHENSTATEMENT");
        return values; 
    }
    
    // Assignments
    // assignment
    @Override public ArrayList<Value> visitAssignment(DyslexiaParser.AssignmentContext ctx) { 
        ArrayList<Value> values = new ArrayList<Value>();
        ArrayList<Value> leftHandSide = visit(ctx.leftHandSide());
        Value expression = visit(ctx.expression()).get(0);
        Symbol symbol = symbolTable.findSymbol(leftHandSide.get(0).getStringValue(), this.functionCalls.peek());
        Symbol variableReference = null;
        Symbol newSymbol = null;
        if ( "variable".equals(expression.getType()) )  variableReference = symbolTable.findSymbol(expression.getStringValue(), this.functionCalls.peek());
        
        symbolTable.removeSymbol(symbol);
        
        //pnlConsole.println("Assignment Statement: ");
        //pnlConsole.println("Replacing Symbol: " + symbol.toString());
        if ( leftHandSide.size() > 1 ) { 
            // leftHandSide is an array and has index
            int index = leftHandSide.get(1).getIntValue();
            String[] strings = new String[symbol.getMultiValue().length];
            for (int i = 0; i < strings.length;  i++ ) {
                if ( i == index )
                    strings[i] = expression.getStringValue();
                else
                    strings[i] = symbol.getMultiValue()[i];
            }
            
            //newSymbol = new Symbol(symbol.getName(), symbol.getType(), strings, symbol.getClassInstance(), symbol.getFunctionInstance());
        } else {
            // leftHandSide only contains 1 expresion
            if ( variableReference != null ) {
                //newSymbol = new Symbol(symbol.getName(), symbol.getType(), variableReference.getSingleValue(), symbol.getClassInstance(), symbol.getFunctionInstance());            }
            }
        }
        
        //pnlConsole.println("With Symbol: " + newSymbol.toString() );
        
        //symbolTable.addSymbol(newSymbol);
        
        pnlTac.println("L" + labelCount.peek() + ": " + leftHandSide.get(0).getStringValue() + " = " + expression.getStringValue() );
        labelCount.push(labelCount.peek() + 1);
        return values; 
    }
    
    // localVariableDeclaration
    @Override public ArrayList<Value> visitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx) { 
        System.out.println("VISITING LOCAL VARIABLE DECLARATION");
        System.out.println(" STATEMENT: " + ctx.getText());
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.variableModifier().isEmpty() ) modifiers = visit(ctx.variableModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        
        String variableName = "";
        String inputString = "";
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        for( Value value : variableDeclaratorList ) {
            System.out.println("  varuableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) inputString = value.getStringValue();
            else variableInitializer.add(value);
        }
        
        System.out.println(" variableDeclaratorList");
        for( Value value : variableDeclaratorList ) {
            System.out.println("  - value: " + value.toString());
        }
        System.out.println(" variableDeclaratorList");
        
        //System.out.println("INPUT STRING: " + inputString + " EQUALS() " + inputString.equals("") + " !EQUALS(): " + !inputString.equals(""));
        //System.out.println("VARIABLE INITIALIZER: " + variableInitializer.isEmpty() );
        
        String definitionType = unannType.get(0).getStringValue();
        
        String machineDefinitionType = "";
        if ( "tni".equals(definitionType) ) machineDefinitionType = "int";
        else if ( "taolf".equals(definitionType) ) machineDefinitionType = "float";
        else if ( "elbuod".equals(definitionType) ) machineDefinitionType = "double";
        else if ( "rahc".equals(definitionType) ) machineDefinitionType = "char";
        else if ( "naeloob".equals(definitionType) ) machineDefinitionType = "boolean";
        else if ( "gnirts".equals(definitionType) ) machineDefinitionType = "string";
        
        if ( !inputString.equals("") ) {
            // double check type here of definition to input String
            symbol = new Symbol(variableName, definitionType, inputString, this.currentClassName, this.functionCalls.peek());
        } else if ( variableInitializer.isEmpty() ) {
            // no right hand side
            String initializedValue = "";
            if ( "int".equals(definitionType) ) initializedValue = "0";
            else if ( "float".equals(definitionType) ) initializedValue = "0.0";
            else if ( "double".equals(definitionType) ) initializedValue = "0.0";
            else if ( "char".equals(definitionType) ) initializedValue = "0";
            else if ( "boolean".equals(definitionType) ) initializedValue = "eslaf";
            else if ( "string".equals(definitionType) ) initializedValue = "";
            
            symbol = new Symbol(variableName, definitionType, initializedValue, this.currentClassName, this.functionCalls.peek());
        } else if ( variableInitializer.size() == 1) { 
            // only 1 variable
            if ( modifiers.isEmpty() ) {
                // no final modifier
                //symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek());
            } else {
                // with modifier
                //symbol = new Symbol(variableName, definitionType, variableInitializer.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek(), true);
            }
        } else {
            // It is an arrayType
            String[] strings = new String[variableInitializer.size()];
            
            for(int i = 0; i < strings.length; i++ ) {
                strings[i] = variableInitializer.get(i).getStringValue();
            }
            
            //symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, this.functionCalls.peek());
        }
        
        // print out the left side of the = side
        
        //if ( variableInitializer.size() == 1)
        //    System.out.print(" " + machineDefinitionType + " " + variableName + " = " + variableInitializer.get(1).getStringValue());
        //else
        //    System.out.println(" " + machineDefinitionType + " " + variableName + " = ");
        //symbolTable.addSymbol(symbol);
        //pnlConsole.println("Declared Symbol: " + symbol.toString());
        //return visitChildren(ctx);
        
        if ( variableDeclaratorList.size() > 1 )
            pnlTac.println("L" + labelCount.peek() + ": " + variableName + " = " + variableDeclaratorList.get(1).getStringValue() );
        else // there is no initialization example tni i;
            pnlTac.println("L" + labelCount.peek() + ": " + variableName + " = " + variableDeclaratorList.get(0).getStringValue() );
        labelCount.push(labelCount.peek() + 1);
        
        System.out.print("\n"); 
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
    
    // Math Expressions
    // additiveExpression_add
    @Override public ArrayList<Value> visitAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx) { 
        System.out.println("VISITING ADDITIVE EXPRESSION ADD");
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.additiveExpression());
        ArrayList<Value> rightExpressions = visit(ctx.multiplicativeExpression());
     
        
        
        System.out.println("START LEFT EXPRESSIONS");
        for(Value value : leftExpressions ) {
            System.out.println(value.toString());
        }
        System.out.println("END LEFT EXPRESSIONS");
        
        System.out.println("START RIGHT EXPRESSIONS");
        for(Value value : rightExpressions ) {
            System.out.println(value.toString());
        }
        System.out.println("END LEFT EXPRESSIONS");
        
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        int intResult = 0;
        float floatResult = 0;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " + " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        System.out.println("VISITED ADDITIVE EXPRESSION ADD");
        return values; 
    }
    
    // additiveExpression_minus
    @Override public ArrayList<Value> visitAdditiveExpression_minus(DyslexiaParser.AdditiveExpression_minusContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.additiveExpression());
        ArrayList<Value> rightExpressions = visit(ctx.multiplicativeExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        int intResult = 0;
        float floatResult = 0;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " - " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // multiplicativeExpression_mult
    @Override public ArrayList<Value> visitMultiplicativeExpression_mult(DyslexiaParser.MultiplicativeExpression_multContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.multiplicativeExpression());
        ArrayList<Value> rightExpressions = visit(ctx.unaryExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        int intResult = 0;
        float floatResult = 0;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " * " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // multiplicativeExpression_div
    @Override public ArrayList<Value> visitMultiplicativeExpression_div(DyslexiaParser.MultiplicativeExpression_divContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.multiplicativeExpression());
        ArrayList<Value> rightExpressions = visit(ctx.unaryExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        int intResult = 0;
        float floatResult = 0;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " / " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // multiplicativeExpression_modulo
    @Override public ArrayList<Value> visitMultiplicativeExpression_modulo(DyslexiaParser.MultiplicativeExpression_moduloContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.multiplicativeExpression());
        ArrayList<Value> rightExpressions = visit(ctx.unaryExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        int intResult = 0;
        float floatResult = 0;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " % " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // Logical Operators
    // equalityExpression_equal
    @Override public ArrayList<Value> visitEqualityExpression_equal(DyslexiaParser.EqualityExpression_equalContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.equalityExpression());
        ArrayList<Value> rightExpressions = visit(ctx.relationalExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " == " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // equalityExpression_notEqual
    @Override public ArrayList<Value> visitEqualityExpression_notEqual(DyslexiaParser.EqualityExpression_notEqualContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.equalityExpression());
        ArrayList<Value> rightExpressions = visit(ctx.relationalExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " != " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // relationExpression
    // relationExpresion_lessThan
    @Override public ArrayList<Value> visitRelationalExpression_lessThan(DyslexiaParser.RelationalExpression_lessThanContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.relationalExpression());
        ArrayList<Value> rightExpressions = visit(ctx.shiftExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " < " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // relationalExpression_greaterThan
    @Override public ArrayList<Value> visitRelationalExpression_greaterThan(DyslexiaParser.RelationalExpression_greaterThanContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.relationalExpression());
        ArrayList<Value> rightExpressions = visit(ctx.shiftExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " > " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values; 
    }
    
    // relationalExpression_lessThanEqual
    @Override public ArrayList<Value> visitRelationalExpression_lessThanEqual(DyslexiaParser.RelationalExpression_lessThanEqualContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.relationalExpression());
        ArrayList<Value> rightExpressions = visit(ctx.shiftExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " <= " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // relationalExpression_greaterThanEqual
    @Override public ArrayList<Value> visitRelationalExpression_greaterThanEqual(DyslexiaParser.RelationalExpression_greaterThanEqualContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.relationalExpression());
        ArrayList<Value> rightExpressions = visit(ctx.shiftExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " >= " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // conditionalAndExpression
    @Override public ArrayList<Value> visitConditionalAndExpression_conditionalAndExpression(DyslexiaParser.ConditionalAndExpression_conditionalAndExpressionContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.conditionalAndExpression());
        ArrayList<Value> rightExpressions = visit(ctx.inclusiveOrExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " && " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // conditionalOrExpression_conditionalOrExpression
    @Override public ArrayList<Value> visitConditionalOrExpression_conditionalOrExpression(DyslexiaParser.ConditionalOrExpression_conditionalOrExpressionContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> leftExpressions = visit(ctx.conditionalOrExpression());
        ArrayList<Value> rightExpressions = visit(ctx.conditionalAndExpression());
        
        Value leftExpression = leftExpressions.get(0);
        Value rightExpression = rightExpressions.get(0);
        
        boolean result = false;
        
        pnlTac.println("L" + labelCount.peek() + ": " + " t" + tempSymbolCount.peek() + " = " + leftExpression.getStringValue() + " || " + rightExpression.getStringValue());
        // then add to the return values the used temp symbol
        values.add( new Value("temp", "t" + tempSymbolCount.peek()) );
        tempSymbolCount.push(tempSymbolCount.peek() + 1);
        labelCount.push(labelCount.peek() + 1);
        
        return values;
    }
    
    // expressionName
    // expressionName_Identifier
    @Override public ArrayList<Value> visitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        
        // Don't check symbol table yet just return
        String identifier = ctx.Identifier().getText();
        values.add( new Value("variable", identifier) );
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
        if ( "tni".equals(type) ) values.add(new Value("type", "tni"));
        else if ( "rahc".equals(type) ) values.add(new Value("type", "rahc"));
        return values;
        //return visitChildren(ctx); 
    }
    
    // floatingPointType
    @Override public ArrayList<Value> visitFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        if ( "taolf".equals(type) ) values.add( new Value("type", "taolf") );
        else if ( "elbuod".equals(type) ) values.add( new Value("type", "elbuod") );
        return values;
    }
    
    // unannPrimitiveType_boolean
    @Override public ArrayList<Value> visitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        if ( "naeloob".equals(type) ) values.add( new Value("type", "naeloob") );
        return values;
    }
    
    // String type
    @Override public ArrayList<Value> visitUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.Identifier().getText();
        if ( "gnirts".equals(type) ) values.add(new Value("type", "gnirts") );
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
        //if ( ctx.unannPrimitiveType() != null ) values.addAll(visit(ctx.unannPrimitiveType()));
        //else if ( ctx.unannClassOrInterfaceType() != null ) values.addAll(visit(ctx.unannClassOrInterfaceType()));
        //else if ( ctx.unannTypeVariable() != null ) values.addAll(visit(ctx.unannTypeVariable()));
        //ArrayList<Value> unannPrimitiveType = ctx.;
        
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
        values.add( new Value("llun", "llun") );
        return values; 
    }
}
