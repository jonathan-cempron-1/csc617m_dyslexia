/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import java.util.ArrayList;

/**
 *
 * @author Gaming
 */
public class DyslexiaTacVisitor extends DyslexiaBaseVisitor<ArrayList<Value>> {
    @Override public ArrayList<Value> visitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx) { 
        ArrayList<Value> values = new ArrayList<>();
        visitChildren(ctx);
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
