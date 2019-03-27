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
public class ActivationRecord {
    
    LinkedList<Activation> activationRecord = new LinkedList<Activation>();
    
    public void addActivation(Activation act){
        activationRecord.add(act);
    }
    
    public void addActivation(Symbol result, String[] arg, String controlLink, String returnAddress){
        activationRecord.add(new Activation(result, arg, controlLink, returnAddress));
    }
    
    public void findActivation(){
        // todo
    }
    
    public void removeActivation(){
        // todo
    }
    
    public Symbol getResult(String controlLink){
        // todo
        return null;
    }
    
}
