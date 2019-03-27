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
public class Tac {
    String val = "";
    int id = -1;
    String alt = "";

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Tac(String val, int id) {
        this.val = val;
        this.id = id;
    }
    
    public Tac(String val, int id, String alt) {
        this.val = val;
        this.id = id;
        this.alt = alt;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
