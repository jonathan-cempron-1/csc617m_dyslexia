/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

/**
 *
 * @author jonats
 */
public class Activation {
    
    Symbol result;
    String[] Argument = new String[]{};
    String controlLink = "";
    String retururnAddress = "";

    public Activation(Symbol result, String[] arg, String controlLink, String returnAddress) {
        this.result = result;
        this.Argument = arg;
        this.controlLink = controlLink;
        this.retururnAddress = returnAddress;
    }

    public Symbol getResult() {
        return result;
    }

    public void setResult(Symbol result) {
        this.result = result;
    }

    public String[] getArgument() {
        return Argument;
    }

    public void setArgument(String[] Argument) {
        this.Argument = Argument;
    }

    public String getControlLink() {
        return controlLink;
    }

    public void setControlLink(String controlLink) {
        this.controlLink = controlLink;
    }

    public String getRetururnAddress() {
        return retururnAddress;
    }

    public void setRetururnAddress(String retururnAddress) {
        this.retururnAddress = retururnAddress;
    }
}
