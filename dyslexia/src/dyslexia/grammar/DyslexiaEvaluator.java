/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.grammar.DyslexiaParser.BlockStatementContext;
import dyslexia.grammar.DyslexiaParser.ExpressionContext;
import dyslexia.grammar.DyslexiaParser.VariableInitializerContext;
import dyslexia.gui.FrmDislexia;
import dyslexia.gui.PnlConsole;
import dyslexia.gui.PnlScanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class DyslexiaEvaluator extends DyslexiaBaseVisitor<ArrayList<Value>>{
    // GUI Components
    private PnlConsole pnlConsole;
    private FrmDislexia frmDislexia;
    private PnlScanner pnlDebugger;
    private int breakPoint = 0;
    
    // Class Variables
    private String currentClassName = "";
    private String currentMethodName = "";
    
    // List that contains all the symbols in the program
    private SymbolTable symbolTable = new SymbolTable();
    // List that contains all of the functions of the program
    // maybe should not be constructed here so that functions can be declared
    // after the main function
    private FunctionTable functionTable = new FunctionTable();
    private Stack<String> functionCalls = new Stack<>();
    
    public DyslexiaEvaluator(PnlConsole pnlConsole, FrmDislexia frmDislexia){
        this.pnlConsole = pnlConsole;
        this.frmDislexia = frmDislexia;
        this.pnlDebugger = frmDislexia.pnlDebugger;
        this.breakPoint = pnlDebugger.breakPoint;
    }
    
    public void printSymbolTable(){
        pnlDebugger.println("SYMBOL TABLE START");
        for ( Symbol symbol : symbolTable.symbolTable ) {
            pnlDebugger.println(symbol.toString());
        }
        pnlDebugger.println("SYMBOL TABLE END");
    }
    
    
    @Override public ArrayList<Value> visitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        //pnlDebugger.println("Breakpoint: " + pnlDebugger.breakPoint);
        pnlDebugger.println("DEBUGGING TREE");
        pnlConsole.println("PROGRAM START");
        visitChildren(ctx);
        pnlDebugger.println("DEBUGGED TREE");
        pnlConsole.println("PROGRAM END");
        printSymbolTable();
        return values; 
    }
    
    
    @Override public ArrayList<Value> visitNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx) { 
        //System.out.println("CLASS IDENTIFIER: " + ctx.Identifier().getText() );
        this.currentClassName = ctx.Identifier().getText();
        return visitChildren(ctx); 
    }
    
    // blocks
    // block
    @Override public ArrayList<Value> visitBlock(DyslexiaParser.BlockContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();       
        ArrayList<Value> blockStatements = visit(ctx.blockStatements());
        if ( blockStatements != null ) values.addAll(blockStatements);
        return values; 
    }
    
    // blockStatements
    @Override public ArrayList<Value> visitBlockStatements(DyslexiaParser.BlockStatementsContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        // when a block statement has already returned something end the execution of successding blocks
        
        for(BlockStatementContext blockStatement : ctx.blockStatement()){
            ArrayList<Value> blockStatementResult = visit(blockStatement);
            if ( blockStatementResult != null ) 
                if ( !blockStatementResult.isEmpty() )
                    return blockStatementResult;
        }
        return values; 
    }
    
    // Fields
    // global variable
    @Override public ArrayList<Value> visitFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.fieldModifier().isEmpty() ) modifiers = visit(ctx.fieldModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        
        String variableName = "";
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        Value input = null;
        Value expression = null;
        for( Value value : variableDeclaratorList ) {
            //System.out.println("varuableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) input = value;
            else if ( "expressionName".equals(value.getType())) expression = value;
            else variableInitializer.add(value);
        }
        
        //System.out.println("INPUT STRING: " + inputString + " EQUALS() " + inputString.equals("") + " !EQUALS(): " + !inputString.equals(""));
        //System.out.println("VARIABLE INITIALIZER: " + variableInitializer.isEmpty() );
        
        String definitionType = unannType.get(0).getStringValue();
        
        
        if ( input != null ) {
            // double check type here of definition to input String
            symbol = new Symbol(variableName, definitionType, input.getStringValue(), this.currentClassName, "");
        } else if ( expression != null ) {
            // global symbol
            Symbol globalExpressionReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol expressionReference = null;
            
            expressionReference = globalExpressionReference;
            

           
            if ( modifiers.isEmpty() ) {
                // no final modifier
                symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, "");
            } else {
                // with modifier
                symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, "", true);
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
            String[] strings = new String[variableInitializer.size()];
            
            for(int i = 0; i < strings.length; i++ ) {
                strings[i] = variableInitializer.get(i).getStringValue();
            }
            
            symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, "");
        }
        
        symbolTable.addSymbol(symbol);
        pnlDebugger.println("Declared Symbol: ");
        pnlDebugger.println(symbol.toString());
        return null;
    }
    
    // fieldModifier
    @Override public ArrayList<Value> visitFieldModifier_final(DyslexiaParser.FieldModifier_finalContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String modifier = ctx.getText();
        values.add(new Value("modifier", modifier));
        return values; 
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
    }
    
    // methodDeclaration
    // contains the nodes methodHeader and methodBody 
    @Override public ArrayList<Value> visitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx) { 
        // Check first if name is equal to niam then execute
        // TODO: Functions get method body and function name and save to another list;
        ArrayList<Value> methodHeader = visit(ctx.methodHeader());
        Value functionName = ValueArrayList.getFunctionName(methodHeader);
        ArrayList<Value> functionParameters = ValueArrayList.getFunctionParameters(methodHeader);
        Value functionReturnType = ValueArrayList.getFunctionReturnType(methodHeader);
        
        System.out.println("Function Name: " + functionName.toString() );
        
        if ( "niam".equals(functionName.getStringValue()) ) {
            // push function into functionString stack
            //this.functionCalls.peek() = functionName.getStringValue();
            this.functionCalls.push(functionName.getStringValue());
            return visit(ctx.methodBody());
        } else {
            // store function
            LinkedList<Parameter> parameters = new LinkedList<>();
            for( Value parameter : functionParameters ){
                parameters.add( new Parameter(parameter.getStringValue(), parameter.getType()) );
            }
            Function function = new Function(functionName.getStringValue(), ctx.methodBody(), parameters, functionReturnType);
            System.out.println(" Adding function: " + function.toString() );
            functionTable.addFunction(function);
        }
        return null;
        //return visitChildren(ctx); 
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
    
    // methodInvocation
    // methodInvocation_methodName
    @Override public ArrayList<Value> visitMethodInvocation_methodName(DyslexiaParser.MethodInvocation_methodNameContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
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
                if ( "expressionName".equals(value.getType()) ) {
                    // local symbol
                    Symbol localSymbol = symbolTable.findSymbol(value.getStringValue(), this.currentClassName, this.functionCalls.peek());

                    // global symbol
                    Symbol globalSymbol = symbolTable.findSymbol(value.getStringValue(), this.currentClassName, "");

                    Symbol variable = null;
                    if ( localSymbol != null )
                        variable = localSymbol;
                    else
                        variable = globalSymbol;
                    value = new Value(variable.getType(), variable.getSingleValue());
                }
                pnlConsole.print(value.getStringValue());
            }
        } else if ( "nltuptuo".equals(methodName.getStringValue()) ) {
            // output line
            for ( Value value : argumentList ) {
                if ( "expressionName".equals(value.getType()) ) {
                    // local symbol
                    Symbol localSymbol = symbolTable.findSymbol(value.getStringValue(), this.currentClassName, this.functionCalls.peek());

                    // global symbol
                    Symbol globalSymbol = symbolTable.findSymbol(value.getStringValue(), this.currentClassName, "");

                    Symbol variable = null;
                    if ( localSymbol != null )
                        variable = localSymbol;
                    else
                        variable = globalSymbol;
                    value = new Value(variable.getType(), variable.getSingleValue());
                }
                pnlConsole.println(value.getStringValue());
            }
        } else {
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            // For Debugging variables
            Stack<String> functionCallsWatch = this.functionCalls;
            SymbolTable symbolTableWatch = this.symbolTable;
            
            
            int functionCallCount = FunctionTable.countFunctionInstance(functionCalls, functionCall.getName());
            String functionCallInstance = functionCall.getName().concat("-" + functionCallCount);
            // check argument list
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
                    symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                }
            
            }
            
            this.functionCalls.push(functionCallInstance);
            // execute the body
            // check the value returned
            ArrayList<Value> returnValues = visit(functionCall.getMethodBodyContextCtx());
            // only 1 return value
            
            if ( !returnValues.isEmpty() ) {
                Value returnValue = returnValues.get(0);
                values.add(returnValue);
            }
            // pop the function call
            this.functionCalls.pop();
            // clear the symbol table
            symbolTable.removeSymbols(this.currentClassName, functionCallInstance);
            //System.out.println("Function is not output");
        }
        return values; 
    }
    
    // returnStatement
    @Override public ArrayList<Value> visitReturnStatement(DyslexiaParser.ReturnStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions = visit(ctx.expression());
        System.out.println(" VISITING RETURN STATEMENT");
        for( Value expression : expressions ){
            if ( "expressionName".equals(expression.getType()) ) {
                // local symbol
                Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

                // global symbol
                Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

                Symbol variable = null;
                if ( localSymbol != null )
                    variable = localSymbol;
                else
                    variable = globalSymbol;
                
                expression = new Value( variable.getType(), variable.getSingleValue() );
            }
            System.out.println("Expression: " + expression.toString());
            values.add( expression );
        }
        System.out.println(" VISITED RETURN STATEMENT");
        return values; 
    }
    
    // argumentList
    @Override public ArrayList<Value> visitArgumentList(DyslexiaParser.ArgumentListContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        for( ExpressionContext eCtx : ctx.expression() ) {
            values.addAll(visit(eCtx));
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
    // Assignments
    // assignment
    @Override public ArrayList<Value> visitAssignment(DyslexiaParser.AssignmentContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<Value>();
        ArrayList<Value> leftHandSide = visit(ctx.leftHandSide());
        Value expression = visit(ctx.expression()).get(0);
        Symbol symbol = null;
                
        // local symbol
        Symbol localSymbol = symbolTable.findSymbol(leftHandSide.get(0).getStringValue(), this.currentClassName, this.functionCalls.peek());

        // global symbol
        Symbol globalSymbol = symbolTable.findSymbol(leftHandSide.get(0).getStringValue(), this.currentClassName, "");
        
        if ( localSymbol != null )
            symbol = localSymbol;
        else
            symbol = globalSymbol;
        
        Symbol variableReference = null;
        Symbol newSymbol = null;
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localVariableReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalVariableReference = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            if ( localVariableReference != null )
                variableReference = localVariableReference;
            else
                variableReference = globalVariableReference;
                
            variableReference = symbolTable.findSymbol(expression.getStringValue(), this.functionCalls.peek());
        }
        
        symbolTable.removeSymbol(symbol);
        
        pnlDebugger.println("Assignment Statement: ");
        pnlDebugger.println("Old Symbol: " + symbol.toString());
        if ( leftHandSide.size() > 1 ) { 
            // leftHandSide is an array and has index
            Value indexValue = leftHandSide.get(1);
            System.out.println( " LEFTHANDSIDE.GET(1): " + leftHandSide.get(1).toString());
            if ( "index".equals(indexValue.getType()) ){
                // If it is local
                Symbol indexReference = symbolTable.findSymbol(indexValue.getStringValue(), this.currentClassName, this.functionCalls.peek());
                if ( indexReference == null ) // If it is global
                    indexReference = symbolTable.findSymbol(indexValue.getStringValue(), this.currentClassName, "");
                System.out.println(" INDEX REFERENCE: " + indexReference.toString());
                indexValue = new Value(indexReference.getType(), indexReference.getSingleValue());
            }
            System.out.println(" INDEX: " + indexValue.toString());
            int index = Integer.valueOf(indexValue.getStringValue());
            
            
            String[] strings = new String[symbol.getMultiValue().length];
            if ( variableReference == null ) {
                for (int i = 0; i < strings.length;  i++ ) {
                    if ( i == index )
                        strings[i] = expression.getStringValue();
                    else
                        strings[i] = symbol.getMultiValue()[i];
                }
            } else {
                for (int i = 0; i < strings.length;  i++ ) {
                    if ( i == index )
                        strings[i] = variableReference.getSingleValue();
                    else
                        strings[i] = symbol.getMultiValue()[i];
                }
            }
            newSymbol = new Symbol(symbol.getName(), symbol.getType(), strings, symbol.getClassInstance(), symbol.getFunctionInstance());
        } else {
            // leftHandSide only contains 1 expresion
            if ( variableReference != null ) {
                newSymbol = new Symbol(symbol.getName(), symbol.getType(), variableReference.getSingleValue(), symbol.getClassInstance(), symbol.getFunctionInstance());            }
            else {
                newSymbol = new Symbol(symbol.getName(), symbol.getType(), expression.getStringValue(), symbol.getClassInstance(), symbol.getFunctionInstance());
            }
        }
        
        pnlDebugger.println("New Symbol: " + newSymbol.toString() );
        
        symbolTable.addSymbol(newSymbol);
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
    
    // methodInvocation_lfno_primary_methodName
    @Override public ArrayList<Value> visitMethodInvocation_lfno_primary_methodName(DyslexiaParser.MethodInvocation_lfno_primary_methodNameContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> methodNames = visit(ctx.methodName());
        ArrayList<Value> argumentList = new ArrayList<>();
        if (ctx.argumentList() != null) argumentList = visit(ctx.argumentList());
        
        Value methodName = methodNames.get(0);
        
        if ( "tupni".equals(methodName.getStringValue()) ) {
            String userInput = (String)JOptionPane.showInputDialog(this.frmDislexia,"Input:\n","Input",JOptionPane.PLAIN_MESSAGE,null, null, null);
            // use the argumentList for type
            //Value type = argumentList.get(0);
            
            // create in symbol table
            // get the value type of the user input
            //System.out.println("INPUT TYPE: " + type.toString());
            //values.add( new Value(, userInput));
            values.add(new Value(methodName.getStringValue(), userInput));
        } else {
            // it is not an input method
            // when input is here it can be + + only returning the value up the tree
            // none of the methods above then it is declared by the user
            Function functionCall = functionTable.findFunction(methodName.getStringValue());
            // if there are arguments also check here if equal to the parameters
            // also check if function is not returning void
            // counter for number of functions within the function call
            
            // For Debugging variables
            Stack<String> functionCallsWatch = this.functionCalls;
            SymbolTable symbolTableWatch = this.symbolTable;
            
            
            int functionCallCount = FunctionTable.countFunctionInstance(functionCalls, functionCall.getName());
            String functionCallInstance = functionCall.getName().concat("-" + functionCallCount);
            // check argument list
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
                    symbolTable.addSymbol(new Symbol(parameter.getName(), parameter.getType(), argument.getStringValue(), this.currentClassName, functionCallInstance));
                }
            
            }
            
            this.functionCalls.push(functionCallInstance);
            // execute the body
            // check the value returned
            ArrayList<Value> returnValues = visit(functionCall.getMethodBodyContextCtx());
            // only 1 return value
            if ( !returnValues.isEmpty() ){
                System.out.println(" I AM RETURNING " + returnValues.get(0).toString()); 
                Value returnValue = returnValues.get(0);
                values.add(returnValue);
            }
            // pop the function call
            this.functionCalls.pop();
            // clear the symbol table
            symbolTable.removeSymbols(this.currentClassName, functionCallInstance);
            //System.out.println("Function is not output");
        }
        return values; 
    }
    
    // Declarations
    // localVariableDeclaration
    // This is to check if it is equal to the definition and to the type of the right hand side
    // only accepts one variable at the left hand side
    @Override public ArrayList<Value> visitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> unannType = visit(ctx.unannType());
        ArrayList<Value> variableDeclaratorList = visit(ctx.variableDeclaratorList());
        ArrayList<Value> modifiers = new ArrayList<>();
        
        // checks if there are modifiers
        if ( !ctx.variableModifier().isEmpty() ) modifiers = visit(ctx.variableModifier(0)); // only accept 1 modifier final
        
        Symbol symbol = null;
        
        String variableName = "";
        String inputString = "";
        ArrayList<Value> variableInitializer = new ArrayList<>(); 
        Value expression = null;
        for( Value value : variableDeclaratorList ) {
            //System.out.println("varuableDeclaratorList: " + value.toString());
            if ( "variable".equals(value.getType()) ) variableName = value.getStringValue();
            else if ( "tupni".equals(value.getType()) ) inputString = value.getStringValue();
            else if ( "expressionName".equals(value.getType())) expression = value;
            else variableInitializer.add(value);
        }
        
        //System.out.println("INPUT STRING: " + inputString + " EQUALS() " + inputString.equals("") + " !EQUALS(): " + !inputString.equals(""));
        //System.out.println("VARIABLE INITIALIZER: " + variableInitializer.isEmpty() );
        
        String definitionType = unannType.get(0).getStringValue();
        
        
        if ( !inputString.equals("") ) {
            // double check type here of definition to input String
            symbol = new Symbol(variableName, definitionType, inputString, this.currentClassName, this.functionCalls.peek());
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
            
           
            if ( modifiers.isEmpty() ) {
                // no final modifier
                symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, this.functionCalls.peek());
            } else {
                // with modifier
                symbol = new Symbol(variableName, definitionType, expressionReference.getSingleValue(), this.currentClassName, this.functionCalls.peek(), true);
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
            String[] strings = new String[variableInitializer.size()];
            
            for(int i = 0; i < strings.length; i++ ) {
                strings[i] = variableInitializer.get(i).getStringValue();
            }
            
            symbol = new Symbol(variableName, definitionType, strings, this.currentClassName, this.functionCalls.peek());
        }
        
        symbolTable.addSymbol(symbol);
        pnlDebugger.println("Declared Symbol: ");
        pnlDebugger.println(symbol.toString());
        //return visitChildren(ctx);
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
            for( VariableInitializerContext viCtx : ctx.variableInitializer()){
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
    
    // arrayAccess_lfno_primary
    @Override public ArrayList<Value> visitArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx) { 
        System.out.println(" VISITING ARRAY ACCESS LF NO PRIMARY");
        ArrayList<Value> values = new ArrayList<>();
        Value variableName = visit(ctx.expressionName()).get(0);
        Value expression = visit(ctx.expression(0)).get(0);
        
        Symbol symbol = symbolTable.findSymbol(variableName.getStringValue(), this.functionCalls.peek());
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            System.out.println("expression: " + expression.toString());
            System.out.println("variable: " + variable.toString());
            System.out.println("sybmol: " + symbol.toString());
            System.out.println(" CODE: " + ctx.getText());
            printSymbolTable();
            int index = Integer.parseInt(variable.getSingleValue());
            values.add( new Value(symbol.getType(), String.valueOf(symbol.getMultiValue()[index])));
            //String singleValue = symbol.getMultiValue(index);
            //values.add( new Value(symbol.getType(), symbol.getMultiValue(index)));
            //values.add( new Value(symbol.getType(), singleValue));
        } else values.add( new Value(symbol.getType(), symbol.getMultiValue()[expression.getIntValue()]));
        System.out.println(" VISITED ARRAY ACCESS LF NO PRIMARY");
        return values; 
    }
   
    // expressionName
    // expressionName_Identifier
    @Override public ArrayList<Value> visitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        
        // Don't check symbol table yet just return
        String identifier = ctx.Identifier().getText();
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
    
    // IfThen Statememnts
    // ifThenStatement
    @Override public ArrayList<Value> visitIfThenStatement(DyslexiaParser.IfThenStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        System.out.println("VISITING IFTHENSTATEMENT");
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions = visit(ctx.expression());
        Value expression = expressions.get(0);
        
        
        // check if expression is a variable
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            expression = new Value(variable.getType(), variable.getSingleValue() );
            //System.out.println(" SYMBOL: " + symbol.toString());
        }
        
        
        System.out.println(" IFTHEN EXPRESSION: " + expression.toString() );
        
        if ( "naeloob".equals(expression.getType()) && ( true == expression.getBooleanValue() ) ) {
            ArrayList<Value> statement = visit(ctx.statement());
            if ( statement != null ) values.addAll(statement);
        }
        System.out.println("VISITED IFTHENSTATEMENT");
        return values; 
    }
    
    // ifThenElseStatement
    @Override public ArrayList<Value> visitIfThenElseStatement(DyslexiaParser.IfThenElseStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions = visit(ctx.expression());
        Value expression = expressions.get(0);
        
        
        // check if expression is a variable
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            expression = new Value(variable.getType(), variable.getSingleValue() );
            //System.out.println(" SYMBOL: " + symbol.toString());
        }
        
        
        //System.out.println("IFTHENELSE: " +  ctx.expression().getText() + "EXPRESSION: " + expression.toString() );
        
        if ( "naeloob".equals(expression.getType()) && ( true == expression.getBooleanValue() ) ){
            ArrayList<Value> statementNoShortIf = visit(ctx.statementNoShortIf());
            if ( statementNoShortIf != null ) values.addAll(statementNoShortIf);
        } else {
            ArrayList<Value> statement = visit(ctx.statement());
            if ( statement != null ) values.addAll(statement);    
        }
        return values; 
    }
    
    // Loops
    // whileStatement
    @Override public ArrayList<Value> visitWhileStatement(DyslexiaParser.WhileStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<>(); 
        ArrayList<Value> expressions = visit(ctx.expression());
        Value expression = expressions.get(0);
        
        // check if expression is a variable
        if ( "expressionName".equals(expression.getType()) ) {
            // local symbol
            Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            expression = new Value(variable.getType(), variable.getSingleValue() );
            //System.out.println(" SYMBOL: " + symbol.toString());
        }
        
        while ( "naeloob".equals(expression.getType()) && ( true == expression.getBooleanValue() ) ) {
            //System.out.println("I AM IN WHILE STATEMENT");
            visit(ctx.statement());
            
            // check again if expression has changed
            expressions = visit(ctx.expression());
            expression = expressions.get(0);
            // check if expression is a variable when variable has been updated
            if ( "expressionName".equals(expression.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(expression.getStringValue(), this.functionCalls.peek());
                expression = new Value(symbol.getType(), symbol.getSingleValue() );
                //System.out.println(" SYMBOL: " + symbol.toString());
            }
        }
        return null;
    }
    
    // doStatement
    @Override public ArrayList<Value> visitDoStatement(DyslexiaParser.DoStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<>(); 
        ArrayList<Value> expressions;
        Value expression;
        
        do {
            // do statements first
            visit(ctx.statement());
            
            // then get the expression
            expressions = visit(ctx.expression());
            expression = expressions.get(0);
            
            // check if expression is a variable
            if ( "expressionName".equals(expression.getType()) ) {
               // local symbol
                Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

                // global symbol
                Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

                Symbol variable = null;
                if ( localSymbol != null )
                    variable = localSymbol;
                else
                    variable = globalSymbol;
                
                expression = new Value(variable.getType(), variable.getSingleValue() );
            }
        } while( "naeloob".equals(expression.getType()) && ( true == expression.getBooleanValue() ) );
        
        return null;
    }
    
    // basicForStatement
    @Override public ArrayList<Value> visitBasicForStatement(DyslexiaParser.BasicForStatementContext ctx) { 
        int currentLineNumber = ctx.getStart().getLine();
        if ( currentLineNumber == this.breakPoint ){
            Object[] options = {"Yes!"};
            JOptionPane.showOptionDialog(this.frmDislexia,"Continue?", "Break Point Reached!", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
        ArrayList<Value> values = new ArrayList<>();
        ArrayList<Value> expressions;
        Value expression;
        
        // initialization
        visit(ctx.forInit());
        
        // visit expression
        expressions = visit(ctx.expression());
        expression = expressions.get(0);
        
        while( "naeloob".equals(expression.getType()) && ( true == expression.getBooleanValue() ) ){
            // visit the statements inside
            visit(ctx.statement());
            
            // update
            visit(ctx.forUpdate());
            
            // check again if expression has changed
            expressions = visit(ctx.expression());
            expression = expressions.get(0);
            
            // check if expression is a variable
            if ( "expressionName".equals(expression.getType()) ) {
                // local symbol
                Symbol localSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, this.functionCalls.peek());

                // global symbol
                Symbol globalSymbol = symbolTable.findSymbol(expression.getStringValue(), this.currentClassName, "");

                Symbol variable = null;
                if ( localSymbol != null )
                    variable = localSymbol;
                else
                    variable = globalSymbol;
                
                expression = new Value(variable.getType(), variable.getSingleValue() );
            }
        }
        
        return null; 
    }
    
    // Math Expressions
    // additiveExpression_add
    @Override public ArrayList<Value> visitAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx) { 
        //System.out.println("VISITING ADDITIVE EXPRESSION ADD");
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "taolf".equals(leftExpression.getType()) && "taolf".equals(rightExpression.getType()) ) {
            floatResult = leftExpression.getFloatValue() + rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(leftExpression.getType()) ){
            floatResult = leftExpression.getFloatValue() + rightExpression.getIntValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(rightExpression.getType()) ){
            floatResult = leftExpression.getIntValue() + rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else {
            intResult = leftExpression.getIntValue() + rightExpression.getIntValue();
            values.add( new Value("tni", String.valueOf(intResult) ));
        }
        
        //System.out.println("VISITED ADDITIVE EXPRESSION ADD");
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "taolf".equals(leftExpression.getType()) && "taolf".equals(rightExpression.getType()) ) {
            floatResult = leftExpression.getFloatValue() - rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(leftExpression.getType()) ){
            floatResult = leftExpression.getFloatValue() - rightExpression.getIntValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(rightExpression.getType()) ){
            floatResult = leftExpression.getIntValue() - rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else {
            intResult = leftExpression.getIntValue() - rightExpression.getIntValue();
            values.add( new Value("tni", String.valueOf(intResult) ));
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "taolf".equals(leftExpression.getType()) && "taolf".equals(rightExpression.getType()) ) {
            floatResult = leftExpression.getFloatValue() * rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(leftExpression.getType()) ){
            floatResult = leftExpression.getFloatValue() * rightExpression.getIntValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(rightExpression.getType()) ){
            floatResult = leftExpression.getIntValue() * rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else {
            intResult = leftExpression.getIntValue() * rightExpression.getIntValue();
            values.add( new Value("tni", String.valueOf(intResult) ));
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "taolf".equals(leftExpression.getType()) && "taolf".equals(rightExpression.getType()) ) {
            floatResult = leftExpression.getFloatValue() / rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(leftExpression.getType()) ){
            floatResult = leftExpression.getFloatValue() / rightExpression.getIntValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(rightExpression.getType()) ){
            floatResult = leftExpression.getIntValue() / rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else {
            intResult = leftExpression.getIntValue() / rightExpression.getIntValue();
            values.add( new Value("tni", String.valueOf(intResult) ));
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "taolf".equals(leftExpression.getType()) && "taolf".equals(rightExpression.getType()) ) {
            floatResult = leftExpression.getFloatValue() % rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(leftExpression.getType()) ){
            floatResult = leftExpression.getFloatValue() % rightExpression.getIntValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else if ( "taolf".equals(rightExpression.getType()) ){
            floatResult = leftExpression.getIntValue() % rightExpression.getFloatValue();
            values.add( new Value("taolf", String.valueOf(floatResult) ));
        } else {
            intResult = leftExpression.getIntValue() % rightExpression.getIntValue();
            values.add( new Value("tni", String.valueOf(intResult) ));
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() == rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() == rightExpression.getFloatValue();
            else if ( "naeloob".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() == rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() == rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            else if ( "gnirts".equals(leftExpression.getType()) ) result = leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() != rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() != rightExpression.getFloatValue();
            else if ( "naeloob".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() != rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            else if ( "gnirts".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() < rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() < rightExpression.getFloatValue();
            //else if ( "boolean".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() < rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() > rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() > rightExpression.getFloatValue();
            //else if ( "boolean".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() < rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() <= rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() <= rightExpression.getFloatValue();
            //else if ( "boolean".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() < rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            if ( "tni".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() >= rightExpression.getIntValue();
            else if ( "taolf".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() >= rightExpression.getFloatValue();
            //else if ( "boolean".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() < rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
        // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            //if ( "int".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() >= rightExpression.getIntValue();
            //else if ( "float".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() >= rightExpression.getFloatValue();
            if ( "naeloob".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() && rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        
       // Check first if each of them is a variable
        if ( "expressionName".equals(leftExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(leftExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            leftExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        if ( "expressionName".equals(rightExpression.getType()) ) {
            // local symbol
            Symbol localSymbol = null;
            if ( !this.functionCalls.empty() )
                localSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, this.functionCalls.peek());

            // global symbol
            Symbol globalSymbol = symbolTable.findSymbol(rightExpression.getStringValue(), this.currentClassName, "");

            Symbol variable = null;
            if ( localSymbol != null )
                variable = localSymbol;
            else
                variable = globalSymbol;
            
            rightExpression = new Value(variable.getType(), variable.getSingleValue());
        }
        
        // then check if both of them are of equal type
        if ( leftExpression.getType().equals(rightExpression.getType()) ) {
            //if ( "int".equals(leftExpression.getType()) ) result = leftExpression.getIntValue() >= rightExpression.getIntValue();
            //else if ( "float".equals(leftExpression.getType()) ) result = leftExpression.getFloatValue() >= rightExpression.getFloatValue();
            if ( "naeloob".equals(leftExpression.getType()) ) result = leftExpression.getBooleanValue() || rightExpression.getBooleanValue();
            //else if ( "char".equals(leftExpression.getType()) ) result = leftExpression.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
            //else if ( "string".equals(leftExpression.getType()) ) result = !leftExpression.getStringValue().equals(rightExpression.getStringValue());
            values.add( new Value("naeloob", String.valueOf(result)) );
        }
        
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
        else if ( "rahc".equals(type) ) values.add(new Value("type", "char"));
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
        //return visitChildren(ctx); 
    }
    
    // unannPrimitiveType_boolean
    @Override public ArrayList<Value> visitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        String type = ctx.getText();
        if ( "naeloob".equals(type) ) values.add( new Value("type", "naeloob") );
        return values;
        //return visitChildren(ctx); 
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
        values.add( new Value("type", "final") );
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
        //return visitChildren(ctx); 
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
