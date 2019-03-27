/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import java.util.LinkedList;

/**
 *
 * @author jonats
 */
public class Symbol {
    String name = "";
    String type = "";
    LinkedList<String> value = new LinkedList<String>();
    String classInstance = "";
    String functionInstance = "";
    boolean isFinal = false;
    
    public Symbol(String name, String type, String singleValue, String classInstance, String functionInstance){
        this.name = name;
        this.type = type;
        this.value.add(singleValue);
        this.classInstance = classInstance;
        this.functionInstance = functionInstance;
    }
    
    public Symbol(String name, String type, String singleValue, String classInstance){
        this.name = name;
        this.type = type;
        this.value.add(singleValue);
        this.classInstance = classInstance;
    }

    public Symbol(String name, String type, String singleValue, String classInstance, String functionInstance, boolean isFinal){
        this.name = name;
        this.type = type;
        this.value.add(singleValue);
        this.classInstance = classInstance;
        this.functionInstance = functionInstance;
        this.isFinal = isFinal;
    }
    
    public Symbol(String name, String type, String singleValue, String classInstance, boolean isFinal){
        this.name = name;
        this.type = type;
        this.value.add(singleValue);
        this.classInstance = classInstance;
        this.isFinal = isFinal;
    }
    
    public Symbol(String name, String type, String[] multiValues, String classInstance, String functionInstance){
        this.name = name;
        this.type = type;
        this.classInstance = classInstance;
        this.functionInstance = functionInstance;
        for(int i = 0; i < multiValues.length; i++)
            this.value.add(multiValues[i]);
    }

    public Symbol(String name, String type, String[] multiValues, String classInstance){
        this.name = name;
        this.type = type;
        this.classInstance = classInstance;
        for(int i = 0; i < multiValues.length; i++)
            this.value.add(multiValues[i]);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSingleValue() {
        return this.value.get(0);
    }

    public void setSingleValue(String value) {
        this.value.set(0, value);
    }
    
    public String[] getMultiValue() {
        String[] ret = new String[this.value.size()];
        ret = this.value.toArray(ret);
        return ret;
    }
    
    public void setMultiValue(String[] multiValues){
        this.value = new LinkedList<String>();
        for(int i = 0; i < multiValues.length; i++)
            this.value.add(multiValues[i]);
    }

    public String getClassInstance() {
        return classInstance;
    }

    public void setClassInstance(String classInstance) {
        this.classInstance = classInstance;
    }

    public String getFunctionInstance() {
        return functionInstance;
    }

    public void setFunctionInstance(String functionInstance) {
        this.functionInstance = functionInstance;
    }
    
    public LinkedList<String> getValue() {
        return value;
    }

    public void setValue(LinkedList<String> value) {
        this.value = value;
    }

    public boolean isIsFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    @Override
    public String toString() {
        return "Symbol{" + "name=" + name + ", type=" + type + ", value=" + value + ", classInstance=" + classInstance + ", functionInstance=" + functionInstance + ", isFinal=" + isFinal + '}';
    }
    
}
