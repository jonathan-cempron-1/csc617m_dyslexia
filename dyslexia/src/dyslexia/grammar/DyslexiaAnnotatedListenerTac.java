/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.grammar.DyslexiaParser.VariableInitializerContext;
import dyslexia.grammar.DyslexiaParser.VariableModifierContext;
import dyslexia.gui.PnlConsole;
import dyslexia.gui.PnlTac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author Gaming
 */
public class DyslexiaAnnotatedListenerTac extends DyslexiaBaseListener {
    // GUI Components
    PnlTac pnlConsole;
    int ln = 0;
    int tid = 0;
    LinkedList<String> tacStack = new LinkedList<String>();
    TacList tacList = new TacList();
    // Class Variables
    String currentMethodName = "";
    String currentClassName = "";
    Boolean mainMethodExecuting = false;
    ParseTreeProperty<String> methodNames = new ParseTreeProperty<String>();
    
    ParseTreeProperty<Integer> integerValues = new ParseTreeProperty<Integer>();
    ParseTreeProperty<Value> values = new ParseTreeProperty<Value>();
    ParseTreeProperty<String> variableNames = new ParseTreeProperty<String>();
    ParseTreeProperty<String> variableType = new ParseTreeProperty<String>();
    ParseTreeProperty<ArrayValue> arrayValues = new ParseTreeProperty<ArrayValue>();
    ParseTreeProperty<Symbol> symbols = new ParseTreeProperty<Symbol>();
    
    SymbolTable symbolTable = new SymbolTable();

    public DyslexiaAnnotatedListenerTac(PnlTac pnlTac){
        this.pnlConsole = pnlTac;
    }
    
    public void enterNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx) { 
        this.currentClassName = ctx.Identifier().getText();
    }
    
    public void exitMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx){
        System.out.println("EXITING METHOD DECLARATOR");
        this.currentMethodName = ctx.Identifier().getText();
        System.out.println("this.currentMethodName: " + this.currentMethodName);
        if ( "niam".equals(this.currentMethodName) ) {
            mainMethodExecuting = true;
            pnlConsole.println("START:");
        }
        //setMethodName(ctx, ctx.Identifier().getText());
        System.out.println("EXITED METHOD DECLARATOR");
    }
    
    public void exitMethodHeader(DyslexiaParser.MethodHeaderContext ctx) {
    }
    
    public void exitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx) {
    }
    
    public void enterMethodBody(DyslexiaParser.MethodBodyContext ctx) {
        System.out.println("ENTERING METHODBODY of METHODNAME: " + this.currentMethodName);
        System.out.println("mainMethodExecuting: " + this.mainMethodExecuting); 
    }
    
    public void exitMethodBody(DyslexiaParser.MethodBodyContext ctx) {
        System.out.println("EXITING METHODBODY of METHODNAME: " + this.currentMethodName);
        if ( mainMethodExecuting ){
            mainMethodExecuting = false;
        }
        System.out.println("mainMethodExecuting: " + this.mainMethodExecuting);
    }
    
    public void printSymbolTable(){
        pnlConsole.println("SYMBOL TABLE START");
        for ( Symbol symbol : symbolTable.symbolTable ) {
            pnlConsole.println(symbol.toString());
        }
        pnlConsole.println("SYMBOL TABLE END");
    }
    
    // compilationUnit
    public void exitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx) { 
        // check symbols after executing program
        System.out.println("EXITING COMPILATION UNIT");
        pnlConsole.println("Executed Program");
        pnlConsole.println("SYMBOL TABLE START");
        for ( Symbol symbol : symbolTable.symbolTable ) {
            pnlConsole.println(symbol.toString());
        }
        pnlConsole.println("SYMBOL TABLE END");
        System.out.println("EXITED COMPILATION UNIT");
    }
    
    // if ( expression ) { statements }
    // ifThenStatement
    public void enterIfThenStatement(DyslexiaParser.IfThenStatementContext ctx) { 
        if ( mainMethodExecuting ) {
            System.out.println("ENTERING IFTHENSTATEMENT");
            System.out.println("I AM TRYING TO EXIT RULE");
            // finding a way for a listener to listen first before executing statements
            //ctx.expression().;
            
            System.out.println("Expression value: " + getValue(ctx.expression()));
            //System.out.println("EXPRESSION: " + );
            System.out.println("ENETERED IFTHENSTATEMENT");
        }
    }
    
    public void exitIfThenStatement(DyslexiaParser.IfThenStatementContext ctx) { 
        if ( mainMethodExecuting ) {
            System.out.println("EXITING IFTHENSTATEMENT");
            System.out.println("Expression: " + getValue(ctx.expression()));
            System.out.println("EXITED IFTHENSTATEMENT");
        }
    }
    
    // while ( expression ) { statements }
    // whileStatement
    public void enterWhileStatement(DyslexiaParser.WhileStatementContext ctx) { }
    
    public void exitWhileStatement(DyslexiaParser.WhileStatementContext ctx) { }
    
    // Assignment Statement
    // assignment
    public void exitAssignment(DyslexiaParser.AssignmentContext ctx) { 
        if ( mainMethodExecuting ) {
            System.out.println("EXITING ASSIGNMENT");
            Value valueIndex = getValue(ctx.leftHandSide());
            int index = 0;
            Symbol symbol = getSymbol(ctx.leftHandSide());
            Value value = getValue(ctx.expression());
            Symbol newSymbol = null;
            System.out.println("symbol: " + symbol.toString());
            //if ( valueIndex != null) System.out.println("index: " + valueIndex.toString());
            System.out.println("replacing with value: " + value.toString());
            Symbol variableReference = null;
            if ( "variable".equals(value.getType()) ) variableReference = symbolTable.findSymbol(value.getStringValue(), currentMethodName);
            symbolTable.removeSymbol(symbol);
            
            if ( valueIndex != null ) {
                index = valueIndex.getIntValue();
                String[] strings = new String[symbol.getMultiValue().length];
                for( int i = 0; i < symbol.getMultiValue().length; i++ ){
                    if ( i == index )
                        strings[i] = value.getStringValue();
                    else
                        strings[i] = symbol.getMultiValue()[i];
                }
                newSymbol = new Symbol(symbol.getName(), symbol.getType(), strings, symbol.getClassInstance(), symbol.getFunctionInstance());
            } else if ( variableReference != null ) { 
                newSymbol = new Symbol(symbol.getName(), symbol.getType(), variableReference.getSingleValue(), symbol.getClassInstance(), symbol.getFunctionInstance());
            } else {
                newSymbol = new Symbol(symbol.getName(), symbol.getType(), value.getStringValue(), symbol.getClassInstance(), symbol.getFunctionInstance());
            }
            
            //symbol.getMultiValue()[index] = value.getStringValue();
            
            symbolTable.addSymbol(newSymbol);
            pnlConsole.println(";UPDATED ");
            pnlConsole.println(newSymbol.toString());
            //printSymbolTable();
            System.out.println("EXITED ASSIGNMENT");
        }
    }
    
    // leftHandSide
    public void exitLeftHandSide_arrayAccess(DyslexiaParser.LeftHandSide_arrayAccessContext ctx) { 
        if ( mainMethodExecuting ) {
            Symbol symbol = getSymbol(ctx.arrayAccess());
            Value index = getValue(ctx.arrayAccess());
            setSymbol(ctx, symbol);
            setValue(ctx, index.getType(), index.getStringValue());
        }
    }
    public void exitLeftHandSide_expressionName(DyslexiaParser.LeftHandSide_expressionNameContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING LeftHandSide_expressionName");
            Value identifier = getValue(ctx.expressionName());
            //System.out.println(identifier.toString());
            Symbol symbol = symbolTable.findSymbol(identifier.getStringValue(), currentMethodName);
            setSymbol(ctx, symbol);
            //System.out.println("EXITED LeftHandSide_expressionName");
        }
    }
    
    // arrayAccess
    public void exitArrayAccess(DyslexiaParser.ArrayAccessContext ctx) { 
        if ( mainMethodExecuting ) {
            Value arrayIdentifier = getValue(ctx.expressionName());
            Value expression = getValue(ctx.expression(0));
            System.out.println("VariableName: " + arrayIdentifier.getStringValue() + " EXPRESSION: " + expression.toString());
            // get Array value from symbol table and pass
            // do not eveluate
            // should be returning symbol object with what index is being accessed
            Symbol symbol = symbolTable.findSymbol(arrayIdentifier.getStringValue(), this.currentMethodName);
            setSymbol(ctx, symbol);
            setValue(ctx, "int", expression.getStringValue());
        }
    }
    
    // arrayAccess_lfno_primary
    // Here is for evaluating the expression for array
    public void exitArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx) { 
        if ( mainMethodExecuting ) {
            Value arrayIdentifier = getValue(ctx.expressionName());
            Value expression = getValue(ctx.expression(0));
            System.out.println("VariableName: " + arrayIdentifier.getStringValue() + " EXPRESSION: " + expression.toString());
            // get Array value from symbol table and pass
            // check first expression type it can be identifier
            Symbol symbol = symbolTable.findSymbol(arrayIdentifier.getStringValue(), this.currentMethodName);
            if ( "variable".equals(expression.getType()) ) {
                Symbol variable = symbolTable.findSymbol(expression.getStringValue(), currentMethodName);
                int index = Integer.parseInt(variable.getSingleValue());
                setValue(ctx, symbol.getType(), symbol.getMultiValue()[index]);
            } 
            else setValue(ctx, symbol.getType(), symbol.getMultiValue()[expression.getIntValue()]);
        }
    }
    
    // arrayInitializer
    public void exitArrayInitializer(DyslexiaParser.ArrayInitializerContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("exitArrayInitializer");
            ArrayValue arrayValue = getArrayValue(ctx.variableInitializerList());
            //for( Value value : arrayValue.values){
            //    System.out.println("VALUE: " + value.toString());
            //}
            setArrayValue(ctx, arrayValue);
            //System.out.println("exitArrayInitializer");
        }
    }
    
    // variableInitializerList
    public void exitVariableInitializerList(DyslexiaParser.VariableInitializerListContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("VARIABLE INITIALIZER ");
            createArrayValue(ctx);
            ArrayValue arrayValue = getArrayValue(ctx);
            for(VariableInitializerContext viCtx : ctx.variableInitializer() ) {
                //System.out.println("VALUE: " + getValue(viCtx));
                Value value = getValue(viCtx);
                arrayValue.values.add(new Value(value.getType(), value.getStringValue()));
            }
            //System.out.println("VARIABLE INITIALIZER ");
        }
    }
    
    // arrays
    // unannArrayType
    public void exitUnannArrayType(DyslexiaParser.UnannArrayTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            String arrayType = ctx.unannPrimitiveType().getText();
            System.out.println("ARRAY TYPE: " + arrayType);
            Value value = null;
            if ( "tni".equals(arrayType) ) value = new Value("array", "int");
            else if ( "taolf".equals(arrayType) ) value = new Value("array", "float");
            else if ( "elbuod".equals(arrayType) ) value = new Value("array", "double");
            else if ( "rahc".equals(arrayType) ) value = new Value("array", "char");
            else if ( "naeloob".equals(arrayType) ) value = new Value("array", "boolean");
            else if ( "gnirts".equals(arrayType) ) value = new Value("array", "string");
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // variableModifier
    public void exitVariableModifier_final(DyslexiaParser.VariableModifier_finalContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, "final");
        }
    }
    
    // unannReferenceType
    public void exitUnannReferenceType_ClassOrInterfaceType(DyslexiaParser.UnannReferenceType_ClassOrInterfaceTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.unannClassOrInterfaceType()));
        }
    }
    public void exitUnannReferenceType_ArrayType(DyslexiaParser.UnannReferenceType_ArrayTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.unannArrayType());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // unannClassOrInterfaceType
    public void exitUnannClassOrInterfaceType(DyslexiaParser.UnannClassOrInterfaceTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.unannClassType_lfno_unannClassOrInterfaceType()));
        }
    }
    
    // unannClassType_lfno_unannClassOrInterfaceType - CURRENTLY USED FOR STRING TYPES
    public void exitUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            String type = ctx.getText();
            if ( "gnirts".equals(type) ) setVariableType(ctx, "string");
            else setVariableType(ctx, type);
        }
    }
    
    // unannType
    public void exitUnannType_unannPrimitiveType(DyslexiaParser.UnannType_unannPrimitiveTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.unannPrimitiveType()));
        }
    }
    public void exitUnannType_unannReferenceType(DyslexiaParser.UnannType_unannReferenceTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.unannReferenceType());
            setValue(ctx, value.getType(), value.getStringValue());
            // TODO: UPDATE! use new Value object
            setVariableType(ctx, getVariableType(ctx.unannReferenceType()));
            
        }
    }
    
    // unannPrimitiveType
    public void exitUnannPrimitiveType_numericType(DyslexiaParser.UnannPrimitiveType_numericTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.numericType()));
        }
    }
    
    public void exitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx) { 
        if ( mainMethodExecuting ) {
            String type = ctx.getText();
            if ( "naeloob".equals(type) ) setVariableType(ctx, "boolean");
            else setVariableType(ctx, type);
        }
    }
    
    // numericType
    public void exitNumericType_integralType(DyslexiaParser.NumericType_integralTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.integralType()));
        }
    }
    
    public void exitNumericType_floatingPointType(DyslexiaParser.NumericType_floatingPointTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.floatingPointType()));
        }
    }
    
    // integralType
    public void exitIntegralType(DyslexiaParser.IntegralTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            String type = ctx.getText();
            if ( "tni".equals(type) ) setVariableType(ctx, "int");
            else if ( "rahc".equals(type) ) setVariableType(ctx, "char");
            else setVariableType(ctx, type);
        }
    }
    
    // floatingPointType
    public void exitFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            String type = ctx.getText();
            if ( "taolf".equals(type) ) setVariableType(ctx, "float");
            else if ( "elbuod".equals(type) ) setVariableType(ctx, "double");
            else setVariableType(ctx, type);
        }
    }
    
    // localVariableDeclaration
    public void exitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx) { 
        if ( mainMethodExecuting ) {
            String name = getVariableName(ctx.variableDeclaratorList());
            String definitionType = getVariableType(ctx.unannType());
            ArrayList<String> modifiers = new ArrayList<String>();
            for( VariableModifierContext vmCtx : ctx.variableModifier() ) {
                modifiers.add(getVariableType(vmCtx));
            }
            Value value = getValue(ctx.variableDeclaratorList());
            ArrayValue arrayValue = getArrayValue(ctx.variableDeclaratorList());
            //setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, name);
            //System.out.println("STATEMENT: " + ctx.getText());
            //System.out.println("VARIABLE TYPE: " + definitionType);
            //System.out.println("VARIABLE NAME: " + name);
            //System.out.println("DEFINITION TYPE IS EMPTY: " + definitionType.isEmpty());
            //System.out.println("VALUE: " + value.toString());
            //System.out.println("variableDeclaratorList: " + ctx.variableDeclaratorList().getText());
            
            // add a checker when symbol is already in the table
            Symbol symbol = null;
            //if ( !modifiers.isEmpty() ) pnlConsole.print("modifier: " + modifiers.get(0) + " ");
            
            
            
            if ( arrayValue != null ){
                String[] strings = new String[arrayValue.values.size()];
                Value arrayType = getValue(ctx.unannType());
                // check here if all of the types are equal
                //for( Value item : arrayValue.values){
                //    
                //}
                
                for(int i = 0; i < arrayValue.values.size(); i ++) {
                    strings[i] = arrayValue.values.get(i).getStringValue();
                }
                symbol = new Symbol(name, arrayType.getStringValue(), strings, this.currentClassName, this.currentMethodName);
            } else {
                if ( value.getType().isEmpty() ){ // variableDeclaration without assignment
                    //System.out.println("VariableName: " + name + " variableDefinitionType: " + definitionType + " assignmentType=" + value.getType());
                    if ( "int".equals(definitionType) ) value = new Value(definitionType, "0");
                    else if ( "float".equals(definitionType) ) value = new Value(definitionType, "0.0");
                    else if ( "double".equals(definitionType) ) value = new Value(definitionType, "0.0");
                    else if ( "char".equals(definitionType) ) value = new Value(definitionType, "0");
                    else if ( "boolean".equals(definitionType) ) value = new Value(definitionType, "eslaf");
                    else if ( "string".equals(definitionType) ) value = new Value(definitionType, "");
                }
                if (!modifiers.isEmpty() ) symbol = new Symbol(name, definitionType, value.getStringValue(), this.currentClassName, this.currentMethodName, true);
                else symbol = new Symbol(name, definitionType, value.getStringValue(), this.currentClassName, this.currentMethodName);
                
                if(tacList.notEmpty()){
                    Tac tempTac = tacList.pluckTop();
                    pnlConsole.println("L"+ln+": "+symbol.getName()+" = "+tempTac.getAlt());
                } else   
                    pnlConsole.println("L"+ln+": "+symbol.getName()+" = "+symbol.getSingleValue());
                ln++;
            }
            
            symbolTable.addSymbol(symbol);
            //pnlConsole.println("Symbol: " + symbol.toString());
        }
    }
    
    // variableDeclaratorList
    public void exitVariableDeclaratorList(DyslexiaParser.VariableDeclaratorListContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.variableDeclarator(0));
            ArrayValue arrayValue = getArrayValue(ctx.variableDeclarator(0));
            if ( arrayValue != null ) setArrayValue(ctx, arrayValue);
            else setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, getVariableName(ctx.variableDeclarator(0)));
        }
    }
    
    // variableDeclarator
    public void exitVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.variableInitializer());
            ArrayValue arrayValue = getArrayValue(ctx.variableInitializer());
            String variableName = getVariableName(ctx.variableDeclaratorId());
            //if ( value != null ) System.out.println("VariableName: " +  variableName + " VALUE: " + value.toString());
            if ( arrayValue != null ) setArrayValue(ctx, arrayValue);
            else if ( value == null ) setValue(ctx, "", "");
            else if ( "variable".equals(value.getType()) ){
                // get from variable from symbol table
                Symbol symbol = symbolTable.findSymbol(value.getStringValue(), this.currentMethodName);
                //pnlConsole.println("VariableName: " + variableName + " Symbol: " + symbol.toString());
                //pnlConsole.println("L"+ln+": " + variableName + " = " + symbol.getMultiValue().toString());
                // checker if variable is array or not
                setValue(ctx, symbol.getType() ,symbol.getValue().get(0)); // curently returning 1 value
            }
            else setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, variableName);
        }
    }
    
    // variableDeclaratorId
    public void exitVariableDeclaratorId(DyslexiaParser.VariableDeclaratorIdContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableName(ctx, ctx.Identifier().getText());
        }
    }
    
    // variableInitializer
    public void exitVariableInitializer_expression(DyslexiaParser.VariableInitializer_expressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.expression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitVariableInitializer_arrayInitializer(DyslexiaParser.VariableInitializer_arrayInitializerContext ctx) { 
        if ( mainMethodExecuting ) {
            ArrayValue arrayValue = getArrayValue(ctx.arrayInitializer());
            setArrayValue(ctx, arrayValue);
        }
    }
    
    // expression
    public void exitExpression_assignmentExpression(DyslexiaParser.Expression_assignmentExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("exitExpresion assignemtnExpresion CTX: " + ctx.getText());
            Value value = getValue(ctx.assignmentExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // assignmentExpression
    public void exitAssignmentExpression_conditionalExpression(DyslexiaParser.AssignmentExpression_conditionalExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("exitAssignmentExpression_conditionalExpression CTX: " + ctx.getText());
            Value value = getValue(ctx.conditionalExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // conditionalExpression
    public void exitConditionalExpression_conditionalOrExpression(DyslexiaParser.ConditionalExpression_conditionalOrExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.conditionalOrExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }        
    }
    
    // conditionalOrExpression
    public void exitConditionalOrExpression_conditionalAndExpression(DyslexiaParser.ConditionalOrExpression_conditionalAndExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.conditionalAndExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    public void exitConditionalOrExpression_conditionalOrExpression(DyslexiaParser.ConditionalOrExpression_conditionalOrExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.conditionalOrExpression());
            Value rightValue = getValue(ctx.conditionalAndExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "boolean".equals(leftValue.getType()) && "boolean".equals(rightValue.getType()) ) {
                result = leftValue.getBooleanValue() || rightValue.getBooleanValue();
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    // conditionalAndExpression
    public void exitConditionalAndExpression_inclusiveOrExpression(DyslexiaParser.ConditionalAndExpression_inclusiveOrExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.inclusiveOrExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitConditionalAndExpression_conditionalAndExpression(DyslexiaParser.ConditionalAndExpression_conditionalAndExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.conditionalAndExpression());
            Value rightValue = getValue(ctx.inclusiveOrExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "boolean".equals(leftValue.getType()) && "boolean".equals(rightValue.getType()) ) {
                result = leftValue.getBooleanValue() && rightValue.getBooleanValue();
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    // inclusiveOrExpression
    public void exitInclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_exclusiveOrExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.exclusiveOrExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }   
    }
    
    // exclusiveOrExpression
    public void exitExclusiveOrExpression_andExpression(DyslexiaParser.ExclusiveOrExpression_andExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.andExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }     
    }
    
    // andExpression
    public void exitAndExpression_equalityExpression(DyslexiaParser.AndExpression_equalityExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.equalityExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }   
    }
    
    // equalityExpression
    public void exitEqualityExpression_relationalExpression(DyslexiaParser.EqualityExpression_relationalExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.relationalExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitEqualityExpression_equal(DyslexiaParser.EqualityExpression_equalContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.equalityExpression());
            Value rightValue = getValue(ctx.relationalExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue()== rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() == rightValue.getFloatValue();
                else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() == rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() == rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                else if ( "string".equals(leftValue.getType()) ) result = leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    public void exitEqualityExpression_notEqual(DyslexiaParser.EqualityExpression_notEqualContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.equalityExpression());
            Value rightValue = getValue(ctx.relationalExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue()!= rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() != rightValue.getFloatValue();
                else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() != rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                else if ( "string".equals(leftValue.getType()) ) result = !leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    // relationalExpression
    public void exitRelationalExpression_shiftExpression(DyslexiaParser.RelationalExpression_shiftExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.shiftExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitRelationalExpression_lessThan(DyslexiaParser.RelationalExpression_lessThanContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.relationalExpression());
            Value rightValue = getValue(ctx.shiftExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue() < rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() < rightValue.getFloatValue();
                //else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() != rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                //else if ( "string".equals(leftValue.getType()) ) result = !leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    public void exitRelationalExpression_greaterThan(DyslexiaParser.RelationalExpression_greaterThanContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.relationalExpression());
            Value rightValue = getValue(ctx.shiftExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue() > rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() > rightValue.getFloatValue();
                //else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() != rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                //else if ( "string".equals(leftValue.getType()) ) result = !leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    public void exitRelationalExpression_lessThanEqual(DyslexiaParser.RelationalExpression_lessThanEqualContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.relationalExpression());
            Value rightValue = getValue(ctx.shiftExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue() <= rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() <= rightValue.getFloatValue();
                //else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() != rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                //else if ( "string".equals(leftValue.getType()) ) result = !leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    public void exitRelationalExpression_greaterThanEqual(DyslexiaParser.RelationalExpression_greaterThanEqualContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING additiveExpression_add");
            boolean result = false;
            Value leftValue = getValue(ctx.relationalExpression());
            Value rightValue = getValue(ctx.shiftExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( rightValue.getType().equals(leftValue.getType()) ) {
                if ( "int".equals(leftValue.getType()) ) result = leftValue.getIntValue() >= rightValue.getIntValue();
                else if ( "float".equals(leftValue.getType()) ) result = leftValue.getFloatValue() >= rightValue.getFloatValue();
                //else if ( "boolean".equals(leftValue.getType()) ) result = leftValue.getBooleanValue() != rightValue.getBooleanValue();
                //else if ( "char".equals(leftValue.getType()) ) result = leftValue.getCharValue() != rightValue.getCharValue(); // TODO CHECK CHAR VALUE
                //else if ( "string".equals(leftValue.getType()) ) result = !leftValue.getStringValue().equals(rightValue.getStringValue());
                setValue(ctx, "boolean", String.valueOf(result) );
            }
            
            //System.out.println("EXITED additiveExpression_add");
        }
    }
    
    // shiftExpression
    public void exitShiftExpression_additiveExpression(DyslexiaParser.ShiftExpression_additiveExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.additiveExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // additiveExpression
    public void exitAdditiveExpression_multiplicativeExpression(DyslexiaParser.AdditiveExpression_multiplicativeExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.multiplicativeExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    public void exitAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx) { 
        if ( mainMethodExecuting ) {
            //pnlConsole.println(ctx.additiveExpression().getText());
            //pnlConsole.println(ctx.multiplicativeExpression().getText());
            //pnlConsole.println("");
            String left = ctx.additiveExpression().getText();
            String right = ctx.multiplicativeExpression().getText();
            String altLeft = left;
            if(tacList.getId(left)!=-1){
                Tac grab = tacList.pluckTac(left);
                altLeft = "T"+grab.getId();
                String lineLabel = "L"+ln+": ";
                String tempId = "T"+grab.getId()+" = ";
                pnlConsole.println(lineLabel+tempId+grab.getAlt());
                ln++;
            }
            String comb = left + "+" + right;
            String alt = altLeft + "+" + right;
            Tac tacTemp = new Tac(comb, tid, alt);
            tacList.addTac(tacTemp);
            tid++;
            tacList.printTacs();
            /**
            String left = ctx.additiveExpression().getText();
            String right = ctx.multiplicativeExpression().getText();
            String comb = ctx.getText();
            if(tacList.getId(left)!=-1){
                pnlConsole.println("L"+ln+": "+"T"+tacList.getId(left)+" = "+left);
                ln++;
                left = "T"+tacList.pluckTac(left).getId();
                //pnlConsole.println("L"+ln+": "+left+"+"+right);
                ln++;
                comb = left+"+"+right;
            }
            Tac tempTac = new Tac(comb, tid);
            tid++;
            tacList.addTac(tempTac);
            
            tacList.printTacs();
            //pnlConsole.println(left+"+"+right);
            //System.out.println("EXITING additiveExpression_add");
            
            * 
            **/
            
            int intResult = 0;
            float floatResult = 0;
            Value leftValue = getValue(ctx.additiveExpression());
            Value rightValue = getValue(ctx.multiplicativeExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            //pnlConsole.print("L"+ln+": T"+tv+ " = " +leftValue.getStringValue()+" + "+rightValue.getStringValue()+"\n");
            //ln++;tv++;
            //pnlConsole.print(leftValue.toString() + " ");
            //pnlConsole.println(rightValue.toString());
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "float".equals(leftValue.getType()) && "float".equals(rightValue.getType()) ) {
                floatResult = leftValue.getFloatValue() + rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult) );
            } else if ( "float".equals(leftValue.getType()) ){
                floatResult = leftValue.getFloatValue() + rightValue.getIntValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else if ( "float".equals(rightValue.getType()) ){
                floatResult = leftValue.getIntValue() + rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else {
                intResult = leftValue.getIntValue() + rightValue.getIntValue();
                setValue(ctx, "int", String.valueOf(intResult));
            }
            
            //System.out.println("EXITED additiveExpression_add");
            
        }
    }
    
    public void exitAdditiveExpression_minus(DyslexiaParser.AdditiveExpression_minusContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING AdditiveExpression_minus");
            int intResult = 0;
            float floatResult = 0;
            Value leftValue = getValue(ctx.additiveExpression());
            Value rightValue = getValue(ctx.multiplicativeExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            //JONATS START
            String left = ctx.additiveExpression().getText();
            String right = ctx.multiplicativeExpression().getText();
            String altLeft = left;
            if(tacList.getId(left)!=-1){
                Tac grab = tacList.pluckTac(left);
                altLeft = "T"+grab.getId();
                String lineLabel = "L"+ln+": ";
                String tempId = "T"+grab.getId()+" = ";
                pnlConsole.println(lineLabel+tempId+grab.getAlt());
                ln++;
            }
            String comb = left + "-" + right;
            String alt = altLeft + "-" + right;
            Tac tacTemp = new Tac(comb, tid, alt);
            tacList.addTac(tacTemp);
            tid++;
            tacList.printTacs();
            //JONATS END
            
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "float".equals(leftValue.getType()) && "float".equals(rightValue.getType()) ) {
                floatResult = leftValue.getFloatValue() - rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult) );
            } else if ( "float".equals(leftValue.getType()) ){
                floatResult = leftValue.getFloatValue() - rightValue.getIntValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else if ( "float".equals(rightValue.getType()) ){
                floatResult = leftValue.getIntValue() - rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else {
                intResult = leftValue.getIntValue() - rightValue.getIntValue();
                setValue(ctx, "int", String.valueOf(intResult));
            }
            
            //System.out.println("EXITED AdditiveExpression_minus");
        }
    }
    
    // multiplicativeExpression
    public void exitMultiplicativeExpression_unaryExpression(DyslexiaParser.MultiplicativeExpression_unaryExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.unaryExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    public void exitMultiplicativeExpression_mult(DyslexiaParser.MultiplicativeExpression_multContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING AdditiveExpression_minus");
            int intResult = 0;
            float floatResult = 0;
            Value leftValue = getValue(ctx.multiplicativeExpression());
            Value rightValue = getValue(ctx.unaryExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            //JONATS START
            String left = ctx.multiplicativeExpression().getText();
            String right = ctx.unaryExpression().getText();
            String altLeft = left;
            if(tacList.getId(left)!=-1){
                Tac grab = tacList.pluckTac(left);
                altLeft = "T"+grab.getId();
                String lineLabel = "L"+ln+": ";
                String tempId = "T"+grab.getId()+" = ";
                pnlConsole.println(lineLabel+tempId+grab.getAlt());
                ln++;
            }
            String comb = left + "*" + right;
            String alt = altLeft + "*" + right;
            Tac tacTemp = new Tac(comb, tid, alt);
            tacList.addTac(tacTemp);
            tid++;
            tacList.printTacs();
            
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "float".equals(leftValue.getType()) && "float".equals(rightValue.getType()) ) {
                floatResult = leftValue.getFloatValue() * rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult) );
            } else if ( "float".equals(leftValue.getType()) ){
                floatResult = leftValue.getFloatValue() * rightValue.getIntValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else if ( "float".equals(rightValue.getType()) ){
                floatResult = leftValue.getIntValue() * rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else {
                intResult = leftValue.getIntValue() * rightValue.getIntValue();
                setValue(ctx, "int", String.valueOf(intResult));
            }
            
            //System.out.println("EXITED AdditiveExpression_minus");
        }
    }
    
    public void exitMultiplicativeExpression_div(DyslexiaParser.MultiplicativeExpression_divContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING AdditiveExpression_minus");
            int intResult = 0;
            float floatResult = 0;
            Value leftValue = getValue(ctx.multiplicativeExpression());
            Value rightValue = getValue(ctx.unaryExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );

            String left = ctx.multiplicativeExpression().getText();
            String right = ctx.unaryExpression().getText();
            String altLeft = left;
            if(tacList.getId(left)!=-1){
                Tac grab = tacList.pluckTac(left);
                altLeft = "T"+grab.getId();
                String lineLabel = "L"+ln+": ";
                String tempId = "T"+grab.getId()+" = ";
                pnlConsole.println(lineLabel+tempId+grab.getAlt());
                ln++;
            }
            String comb = left + "/" + right;
            String alt = altLeft + "/" + right;
            Tac tacTemp = new Tac(comb, tid, alt);
            tacList.addTac(tacTemp);
            tid++;
            tacList.printTacs();
            
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "float".equals(leftValue.getType()) && "float".equals(rightValue.getType()) ) {
                floatResult = leftValue.getFloatValue() / rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult) );
            } else if ( "float".equals(leftValue.getType()) ){
                floatResult = leftValue.getFloatValue() / rightValue.getIntValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else if ( "float".equals(rightValue.getType()) ){
                floatResult = leftValue.getIntValue() / rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else {
                intResult = leftValue.getIntValue() / rightValue.getIntValue();
                //System.out.println("LEFT VALUE: " + leftValue.getIntValue() + " / RIGHT VALUE" +);
                setValue(ctx, "int", String.valueOf(intResult));
            }
            
            //System.out.println("EXITED AdditiveExpression_minus");
        }
    }
    
    public void exitMultiplicativeExpression_modulo(DyslexiaParser.MultiplicativeExpression_moduloContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING AdditiveExpression_minus");
            int intResult = 0;
            float floatResult = 0;
            Value leftValue = getValue(ctx.multiplicativeExpression());
            Value rightValue = getValue(ctx.unaryExpression());
            // TODO: Check first if both are of equal type
            //System.out.println("LEFT VALUE: " + leftValue.toString() );
            //System.out.println("RIGHT VALUE: " + rightValue.toString() );
            
            // Check first if each of them are variables
            if ( "variable".equals(leftValue.getType()) ){
                Symbol symbol = symbolTable.findSymbol(leftValue.getStringValue(), currentMethodName);
                leftValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "variable".equals(rightValue.getType()) ) {
                Symbol symbol = symbolTable.findSymbol(rightValue.getStringValue(), currentMethodName);
                rightValue = new Value(symbol.getType(), symbol.getSingleValue());
            }
            
            if ( "float".equals(leftValue.getType()) && "float".equals(rightValue.getType()) ) {
                floatResult = leftValue.getFloatValue() % rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult) );
            } else if ( "float".equals(leftValue.getType()) ){
                floatResult = leftValue.getFloatValue() % rightValue.getIntValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else if ( "float".equals(rightValue.getType()) ){
                floatResult = leftValue.getIntValue() % rightValue.getFloatValue();
                setValue(ctx, "float", String.valueOf(floatResult));
            } else {
                intResult = leftValue.getIntValue() % rightValue.getIntValue();
                setValue(ctx, "int", String.valueOf(intResult));
            }
            
            //System.out.println("EXITED AdditiveExpression_minus");
        }
    }
    
    // unaryExpression
    public void exitUnaryExpression_unaryExpressionNotPlusMinus(DyslexiaParser.UnaryExpression_unaryExpressionNotPlusMinusContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.unaryExpressionNotPlusMinus());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // unaryExpressionNotPlusMinus
    public void exitUnaryExpressionNotPlusMinus_postfixExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_postfixExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING POSTFIXEXPRESSION");
                //System.out.println()
            //System.out.println("EXITED POSTFIXEXPRESSION");
            Value value = getValue(ctx.postfixExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    public void exitUnaryExpression_minusUnaryExpression(DyslexiaParser.UnaryExpression_minusUnaryExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING POSTFIXEXPRESSION");
                //System.out.println()
            //System.out.println("EXITED POSTFIXEXPRESSION");
            Value value = getValue(ctx.unaryExpression());
            setValue(ctx, value.getType(), "-".concat(value.getStringValue()));
        }
    }
    
    // postfixExpression
    public void exitPostfixExpression(DyslexiaParser.PostfixExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING POSTFIXEXPRESSION");
                //System.out.println()
            //System.out.println("EXITED POSTFIXEXPRESSION");
            
            // 
            Value value = null;
            if (ctx.primary() != null) value = getValue(ctx.primary());
            else value = getValue(ctx.expressionName());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // expressionName
    public void exitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING POSTFIXEXPRESSION");
                //System.out.println()
            //System.out.println("EXITED POSTFIXEXPRESSION");
            
            // Don't check symbol table yet just return
            String identifier = ctx.Identifier().getText();
            //pnlConsole.println("EXIT EXPRESSION NAME: " + identifier);
            setValue(ctx, "variable", identifier);
        }
    }
    
    // primary
    public void exitPrimary(DyslexiaParser.PrimaryContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING PRIMARY");
            // System.out.println("ARRAY CREATION EXPRESSION: " + ctx.arrayCreationExpression().getText()); // can be null when primaryNoNewArray_lfno_primary is chosen
            //System.out.println("primaryNoNewArray_lfno_primary: " + getValue(ctx.primaryNoNewArray_lfno_primary()).toString() ); // can be null when arrayCreationExpression is chosen
            // is null not yet implemented when expression is chosen in exitPrimaryNoNewArray_lfno_primary_expression
            //System.out.println("primaryNoNewArray_lf_primary: " + ctx.primaryNoNewArray_lf_primary().size() ); // can be of size 0
            //System.out.println("EXITED PRIMARY");
            Value value = getValue(ctx.primaryNoNewArray_lfno_primary());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // exitPrimaryNoNewArray_lfno_primary
    public void exitPrimaryNoNewArray_lfno_primary_literal(DyslexiaParser.PrimaryNoNewArray_lfno_primary_literalContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("exit - PrimaryNoNewArray_lfno_primary_literal");
            //System.out.println("Literal Value: " + getValue(ctx.literal()).toString());
            //System.out.println("exited - PrimaryNoNewArray_lfno_primary_literal");
            Value value = getValue(ctx.literal());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitPrimaryNoNewArray_lfno_primary_array(DyslexiaParser.PrimaryNoNewArray_lfno_primary_arrayContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.arrayAccess_lfno_primary());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    public void exitPrimaryNoNewArray_lfno_primary_expression(DyslexiaParser.PrimaryNoNewArray_lfno_primary_expressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.expression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // Literals
    public void exitIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx) {
        if ( mainMethodExecuting ) {
            String intText = ctx.IntegerLiteral().getText();
            setValue(ctx, "int", intText);
        }
    }
    
    public void exitFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String floatText = ctx.FloatingPointLiteral().getText();
            setValue(ctx, "float", floatText);
        }
    }
    
    public void exitBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String booleanText = ctx.BooleanLiteral().getText();
            if ( "eurt".equals(booleanText) ) setValue(ctx, "boolean", "true");
            else setValue(ctx, "boolean", "false");
        }
    }
    
    public void exitCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String charText = ctx.CharacterLiteral().getText();
            setValue(ctx, "char", charText);
        }
    }
    
    public void exitStringLiteral(DyslexiaParser.StringLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String stringText = ctx.StringLiteral().getText();
            setValue(ctx, "string", stringText);
        }
    }
    
    public void exitNullLiteral(DyslexiaParser.NullLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String nullText = ctx.NullLiteral().getText();
            setValue(ctx, "null", nullText);
        }
    }
    
    // Setters for annotations
    
    public void setMethodName(ParseTree node, String value) { methodNames.put(node, value); }
    
    public String getMethodName(ParseTree node) { return methodNames.get(node); }
    
    public void setIntegerValue(ParseTree node, int value) { integerValues.put(node, value); }
    
    public int getIntegerValue(ParseTree node ) { return integerValues.get(node); }
    
    public void setValue(ParseTree node, String type, String value) { values.put(node, new Value(type, value)); }
    
    public Value getValue(ParseTree node) { return values.get(node); }
    
    public void setVariableName(ParseTree node, String value) { variableNames.put(node, value); }
    
    public String getVariableName(ParseTree node) { return variableNames.get(node); }
    
    public void setVariableType(ParseTree node, String value) { variableType.put(node, value); }
    
    public String getVariableType(ParseTree node) { return variableType.get(node); }
    
    public void createArrayValue(ParseTree node) { arrayValues.put(node, new ArrayValue()); }
    
    public void setArrayValue(ParseTree node, ArrayValue arrayValue) { arrayValues.put(node, arrayValue); }
    
    public ArrayValue getArrayValue(ParseTree node) { return arrayValues.get(node); }
    
    public void setSymbol(ParseTree node, Symbol symbol) { symbols.put(node, symbol); }
    
    public Symbol getSymbol(ParseTree node) { return symbols.get(node); }
}
