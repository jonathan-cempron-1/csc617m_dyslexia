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
    
    public Value(String type){
        this.type = type;
        if ( "int".equals(type) || "tni".equals(type) ) { 
            this.intValue = 0;
            this.value = String.valueOf(intValue);
        } else if ( "float".equals(type) || "taolf".equals(type) ) { 
            this.floatValue = Float.valueOf("0.0"); 
            this.value = String.valueOf(floatValue);
        }
        else if ( "boolean".equals(type) || "naeloob".equals(type) ) {
            this.booleanValue = false;
            this.value = String.valueOf(booleanValue);
        }
        else if ( "char".equals(type) || "rahc".equals(type) ) { 
            this.charValue = 'a';
            this.value = String.valueOf(charValue);
        } else {
            this.value = "default";
        }
    }
    
    public Value(String type, String value){
        this.type = type;
        this.value = value;
        if ( "int".equals(type) || "tni".equals(type) ) this.intValue = Integer.valueOf(value);
        else if ( "float".equals(type) || "taolf".equals(type) ) this.floatValue = Float.valueOf(value);
        else if ( "boolean".equals(type) || "naeloob".equals(type) ) {
            if ( "eurt".equals(value) || "true".equals(value) )
                this.booleanValue = true;
            else
                this.booleanValue = false;
        }
        else if ( "char".equals(type) || "rahc".equals(type) ) this.charValue = value.charAt(0);
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
