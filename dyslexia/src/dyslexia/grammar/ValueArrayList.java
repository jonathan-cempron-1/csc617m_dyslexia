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
public class ValueArrayList {
    //private ArrayList<Value> values = new ArrayList<>();
    
    public static Value getFunctionName(ArrayList<Value> values){
        for( Value value : values ) {
            if ( "function".equals(value.getType()) )
                return value;
        }
        return null;
    }
    
    public static ArrayList<Value> getFunctionParameters(ArrayList<Value> values) {
        ArrayList<Value> newValues = new ArrayList<>();
        for( Value value : values ) {
            if ( !"function".equals(value.getType()) && !"type".equals(value.getType()) )
                newValues.add(value);
        }
        return newValues;
    }
    public static Value getFunctionReturnType(ArrayList<Value> values) {
        for( Value value : values ) {
            if ( "type".equals(value.getType()) )
                return value;
        }
        return null;
    }
}
