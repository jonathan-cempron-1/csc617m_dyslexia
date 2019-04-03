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
public class Error {
    private int lineNumber;
    private String message;

    public Error(int lineNumber, String message) {
        this.lineNumber = lineNumber;
        this.message = message;
    }
    
    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" + "lineNumber=" + lineNumber + ", message=" + message + '}';
    }
    
    
}
