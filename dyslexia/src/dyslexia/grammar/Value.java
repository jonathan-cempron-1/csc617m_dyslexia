/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

/**
 *
 * @author Gaming
 */
public class Value {
    private String type;
    private String value;
    private int intValue;
    private float floatValue;
    private boolean booleanValue;
    private char charValue;
    
    public Value(String type, String value){
        this.type = type;
        this.value = value;
        if ( "int".equals(type) ) this.intValue = Integer.valueOf(value);
        else if ( "float".equals(type) ) this.floatValue = Float.valueOf(value);
        else if ( "boolean".equals(type) ) {
            if ( "eurt".equals(value) || "true".equals(value) )
                this.booleanValue = true;
            else
                this.booleanValue = false;
        }
        else if ( "char".equals(type) ) this.charValue = value.charAt(0);
    }
    
    public Value(String type, String value, boolean isParameter){
        this.type = type;
        this.value = value;
    }
    
    public String getType() {
        return type;
    }
    
    public int getIntValue(){
        return intValue;
    }
    
    public float getFloatValue() {
        return floatValue;
    }
    
    public boolean getBooleanValue() {
        return booleanValue;
    }
    
    public char getCharValue() {
        return charValue;
    }
    
    public String getStringValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Value{" + "type=" + type + ", value=" + value + ", integerValue=" + intValue + ", floatValue=" + floatValue + ", booleanValue=" + booleanValue + ", charValue=" + charValue + '}';
    }
    
    
}
