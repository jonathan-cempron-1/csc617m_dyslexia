/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gaming
 */
public class FunctionTable {
    private ArrayList<Function> functions = new ArrayList<>();
    
    public void addFunction(Function function){
        functions.add(function);
    }
    
    public Function findFunction(String name) {
        for( Function function : functions ){
            if ( name.equals(function.getName()) )
                return function;
        }
        return null;
    }
    
    public static int countFunctionInstance(Stack<String> functionCalls, String functionName) {
        //System.out.println("CALLING COUNTF FUNCTION INSTANCE");
        //System.out.println("FINDING FUCNTION NAME: " + functionName);
        int count = 0;
        
        for ( String functionCall : functionCalls ){
            //System.out.println("FUNCTIONCALL: " + functionCall );
            
            if ( functionCall.startsWith(functionName) )
                count++;
        }
        //System.out.println("CALLED COUNTF FUNCTION INSTANCE");
        return count;
    }
}
