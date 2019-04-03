/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import dyslexia.grammar.DyslexiaParser.LiteralContext;
import dyslexia.grammar.DyslexiaParser.MethodBodyContext;
import java.util.LinkedList;

/**
 *
 * @author Gaming
 */
public class Function {
    private String name;
    private MethodBodyContext ctx;
    private LinkedList<Parameter> parameters;
    private Value returnType;

    public Function(String name, MethodBodyContext ctx, LinkedList<Parameter> parameters, Value returnType) {
        this.name = name;
        this.ctx = ctx;
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MethodBodyContext getMethodBodyContextCtx() {
        return ctx;
    }

    public void setCtx(MethodBodyContext ctx) {
        this.ctx = ctx;
    }

    public LinkedList<Parameter> getParameters() {
        return parameters;
    }
    
    public Parameter getParameter(int i) {
        try {
            return this.parameters.get(i);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void setParameters(LinkedList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Value getReturnValue() {
        return returnType;
    }

    public void setReturnValue(Value returnValue) {
        this.returnType = returnValue;
    }

    @Override
    public String toString() {
        return "Function{" + "name=" + name + ", ctx=" + ctx + ", parameters=" + parameters + ", returnType=" + returnType + '}';
    }
    
    
}
