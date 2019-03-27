/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.gui.PnlConsole;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author Gaming
 */
public class DyslexiaAnnotatedListenerFirst extends DyslexiaBaseListener {
    // GUI Components
    PnlConsole pnlConsole;
    
    // Class Variables
    String currentMethodName = "";
    Boolean mainMethodExecuting = false;
    ParseTreeProperty<String> methodNames = new ParseTreeProperty<String>();
    
    ParseTreeProperty<Integer> integerValues = new ParseTreeProperty<Integer>();
    ParseTreeProperty<Value> values = new ParseTreeProperty<Value>();
    ParseTreeProperty<String> variableNames = new ParseTreeProperty<String>();
    ParseTreeProperty<String> variableType = new ParseTreeProperty<String>();
    
    SymbolTable symbolTable = new SymbolTable();

    public DyslexiaAnnotatedListenerFirst(PnlConsole pnlConsole){
        this.pnlConsole = pnlConsole;
    }
    
    public void exitMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx){
        System.out.println("EXITING METHOD DECLARATOR");
        this.currentMethodName = ctx.Identifier().getText();
        System.out.println("this.currentMethodName: " + this.currentMethodName);
        if ( "niam".equals(this.currentMethodName) ) {
            mainMethodExecuting = true;
            pnlConsole.println("Hello World");
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
    
    // unannType
    public void exitUnannType_unannPrimitiveType(DyslexiaParser.UnannType_unannPrimitiveTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.unannPrimitiveType()));
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
            setVariableType(ctx, ctx.getText());
        }
    }
    
    // numericType
    public void exitNumericType_integralType(DyslexiaParser.NumericType_integralTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, getVariableType(ctx.integralType()));
        }
    }
    
    // integralType
    public void exitIntegralType(DyslexiaParser.IntegralTypeContext ctx) { 
        if ( mainMethodExecuting ) {
            setVariableType(ctx, ctx.getText());
        }
    }
    
    // localVariableDeclaration
    public void exitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.variableDeclaratorList());
            setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, getVariableName(ctx.variableDeclaratorList()));
            System.out.println("STATEMENT: " + ctx.getText());
            System.out.println("VARIABLE TYPE: " + getVariableType(ctx.unannType()));
            System.out.println("VARIABLE NAME: " + getVariableName(ctx.variableDeclaratorList()));
            System.out.println("VALUE: " + value.toString());
            
        }
    }
    
    // variableDeclaratorList
    public void exitVariableDeclaratorList(DyslexiaParser.VariableDeclaratorListContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.variableDeclarator(0));
            setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, getVariableName(ctx.variableDeclarator(0)));
        }
    }
    
    // variableDeclarator
    public void exitVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.variableInitializer());
            setValue(ctx, value.getType(), value.getStringValue());
            setVariableName(ctx, getVariableName(ctx.variableDeclaratorId()));
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
    
    // expression
    public void exitExpression_assignmentExpression(DyslexiaParser.Expression_assignmentExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.assignmentExpression());
            setValue(ctx, value.getType(), value.getStringValue());
        }
    }
    
    // assignmentExpression
    public void exitAssignmentExpression_conditionalExpression(DyslexiaParser.AssignmentExpression_conditionalExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
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
    
    // conditionalAndExpression
    public void exitConditionalAndExpression_inclusiveOrExpression(DyslexiaParser.ConditionalAndExpression_inclusiveOrExpressionContext ctx) { 
         if ( mainMethodExecuting ) {
            Value value = getValue(ctx.inclusiveOrExpression());
            setValue(ctx, value.getType(), value.getStringValue());
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
    
    // relationalExpression
    public void exitRelationalExpression_shiftExpression(DyslexiaParser.RelationalExpression_shiftExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.shiftExpression());
            setValue(ctx, value.getType(), value.getStringValue());
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
    
    // multiplicativeExpression
    public void exitMultiplicativeExpression_unaryExpression(DyslexiaParser.MultiplicativeExpression_unaryExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            Value value = getValue(ctx.unaryExpression());
            setValue(ctx, value.getType(), value.getStringValue());
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
    
    // postfixExpression
    public void exitPostfixExpression(DyslexiaParser.PostfixExpressionContext ctx) { 
        if ( mainMethodExecuting ) {
            //System.out.println("EXITING POSTFIXEXPRESSION");
                //System.out.println()
            //System.out.println("EXITED POSTFIXEXPRESSION");
            
            // 
            Value value = getValue(ctx.primary());
            setValue(ctx, value.getType(), value.getStringValue());
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
    
    // Literals
    public void exitIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx) {
        if ( mainMethodExecuting ) {
            String intText = ctx.IntegerLiteral().getText();
            setValue(ctx, "Integer", intText);
        }
    }
    
    public void exitFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String floatText = ctx.FloatingPointLiteral().getText();
            setValue(ctx, "Float", floatText);
        }
    }
    
    public void exitBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String booleanText = ctx.BooleanLiteral().getText();
            setValue(ctx, "Boolean", booleanText);
        }
    }
    
    public void exitCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String charText = ctx.CharacterLiteral().getText();
            setValue(ctx, "Character", charText);
        }
    }
    
    public void exitStringLiteral(DyslexiaParser.StringLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String stringText = ctx.StringLiteral().getText();
            setValue(ctx, "String", stringText);
        }
    }
    
    public void exitNullLiteral(DyslexiaParser.NullLiteralContext ctx) { 
        if ( mainMethodExecuting ) {
            String nullText = ctx.NullLiteral().getText();
            setValue(ctx, "Null", nullText);
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
}
