/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author jonats
 */
public class SymbolTable {
    
    LinkedList<Symbol> symbolTable = new LinkedList<Symbol>();
    
    public void addSymbol(Symbol symbol){
        symbolTable.add(symbol);
    }
    
    public void addSymbol(String name, String type, String singleValue, String classInstance, String functionInstance){
        Symbol temp = new Symbol(name, type, singleValue, classInstance, functionInstance);
        symbolTable.add(temp);
    }
    
    public void addSymbol(String name, String type, String singleValue, String classInstance, String functionInstance, boolean isFinal){
        Symbol temp = new Symbol(name, type, singleValue, classInstance, functionInstance, isFinal);
        symbolTable.add(temp);
    }
    
    public void addSymbol(String name, String type, String[] multiValues, String classInstance, String functionInstance){
        Symbol temp = new Symbol(name, type, multiValues, classInstance, functionInstance);
        symbolTable.add(temp);
    }
    
    public Symbol findSymbol(String name, String type, String classInstance, String functionInstance){
        for(int i = 0; i < symbolTable.size(); i++) {
            Symbol temp = symbolTable.get(i);
            if(name.equalsIgnoreCase(temp.getName()) && type.equalsIgnoreCase(temp.getType()) 
               && classInstance.equalsIgnoreCase(temp.getClassInstance()) 
               && functionInstance.equalsIgnoreCase(temp.getFunctionInstance())) 
                return temp;
        }
        return null;
    }
    
    public Symbol findSymbol(String name, String functionInstance){
        for(int i = 0; i < symbolTable.size(); i ++) {
            Symbol temp = symbolTable.get(i);
            if (name.equalsIgnoreCase(temp.getName()) && functionInstance.equalsIgnoreCase(temp.getFunctionInstance()) )
                return temp;
        }
        return null;
    }
    
    public Symbol findSymbol(String name, String classInstance, String functionInstance) {
        //System.out.println("FINDING SYMBOL");
        //System.out.println("name: " + name + " classInstance: " + classInstance + " functionInstance: " + functionInstance);
        for(int i = 0; i < symbolTable.size(); i ++) {
            Symbol temp = symbolTable.get(i);
            //System.out.println("temp: " + temp.toString());
            if (name.equalsIgnoreCase(temp.getName()) && classInstance.equalsIgnoreCase(temp.getClassInstance()) && functionInstance.equalsIgnoreCase(temp.getFunctionInstance()) )
                return temp;
        }
        return null;
    }
    
    public ArrayList<Symbol> findSymbols(String classInstance, String functionInstance) {
        ArrayList<Symbol> symbols = new ArrayList<>();
        for(Symbol symbol : symbolTable) {
            if ( functionInstance.equals(symbol.getFunctionInstance()) && classInstance.equals(symbol.getClassInstance()) ) symbols.add(symbol);
        }
        return symbols;
    }

    public int findSymbolIndex(String name, String type, String classInstance, String functionInstance){
        for(int i = 0; i < symbolTable.size(); i++) {
            Symbol temp = symbolTable.get(i);
            if(name.equalsIgnoreCase(temp.getName()) && type.equalsIgnoreCase(temp.getType()) 
               && classInstance.equalsIgnoreCase(temp.getClassInstance()) 
               && functionInstance.equalsIgnoreCase(temp.getFunctionInstance())) 
                return i;
        }
        return -1;
    }
    
    public boolean removeSymbol(String name, String type, String classInstance, String functionInstance){
        // true of removed false if not found
        for(int i = 0; i < symbolTable.size(); i++) {
            Symbol temp = symbolTable.get(i);
            if(name.equalsIgnoreCase(temp.getName()) && type.equalsIgnoreCase(temp.getType()) 
               && classInstance.equalsIgnoreCase(temp.getClassInstance()) 
               && functionInstance.equalsIgnoreCase(temp.getFunctionInstance())) {
                symbolTable.remove(i);
                return true;                
            }
        }
        return false;
    }
    
    public void removeSymbol(Symbol symbol) {
        symbolTable.remove(symbol);
    }
    
    public void removeSymbols(String classInstance, String functionInstance){
        // remove symbols of classIntance and functionInstance
        ArrayList<Symbol> removeSymbols = findSymbols(classInstance, functionInstance);
        for( Symbol symbol : removeSymbols ) {
            removeSymbol(symbol);
        }
    }

    public boolean editSymbolValue(String name, String singleValue, String type, String classInstance, String functionInstance){
        // true of removed false if not found
        for(int i = 0; i < symbolTable.size(); i++) {
            Symbol temp = symbolTable.get(i);
            if(name.equalsIgnoreCase(temp.getName()) && type.equalsIgnoreCase(temp.getType()) 
               && classInstance.equalsIgnoreCase(temp.getClassInstance()) 
               && functionInstance.equalsIgnoreCase(temp.getFunctionInstance())) {
                symbolTable.get(i).setSingleValue(singleValue);
                return true;                
            }
        }
        return false;
    }

    public boolean editSymbolValue(String name, String[] multiValues, String type, String classInstance, String functionInstance){
        // true of removed false if not found
        for(int i = 0; i < symbolTable.size(); i++) {
            Symbol temp = symbolTable.get(i);
            if(name.equalsIgnoreCase(temp.getName()) && type.equalsIgnoreCase(temp.getType()) 
               && classInstance.equalsIgnoreCase(temp.getClassInstance()) 
               && functionInstance.equalsIgnoreCase(temp.getFunctionInstance())) {
                symbolTable.get(i).setMultiValue(multiValues);
                return true;                
            }
        }
        return false;
    }
}
