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
public class TacList {
    LinkedList<Tac> tacStack = new LinkedList<Tac>();
    
        public LinkedList<Tac> getTacStack() {
        return tacStack;
    }
    
    public boolean isEmpty(){
        if(tacStack.size()==0)
            return true;
        return false;
    }

    public boolean notEmpty(){
        if(tacStack.size()==0)
            return false;
        return true;
    }
    
    public Tac pluckTop(){
        Tac temp = tacStack.get(0);
        tacStack.remove(0);
        return temp; 
    }
    
    public void setTacStack(LinkedList<Tac> tacStack) {
        this.tacStack = tacStack;
    }
    
    public void addTac(Tac tac){
        tacStack.add(tac);
    }
    
    public Tac pluckTac(int id){
        for(int i= 0; i < tacStack.size(); i++){
            Tac temp = tacStack.get(i);
            if(temp.getId() == id){
                tacStack.remove(i);
                return temp;
            }
        }
        return null;
    }
    
    public Tac pluckTac(String val){
        for(int i= 0; i < tacStack.size(); i++){
            Tac temp = tacStack.get(i);
            if(temp.getVal().equals(val)){
                tacStack.remove(i);
                return temp;
            }
        }
        return null;
    }
    
    public int getId(String val){
        for(int i= 0; i < tacStack.size(); i++){
            Tac temp = tacStack.get(i);
            if(temp.getVal().equals(val)){
                return temp.getId();
            }
        }
        return -1;
    }
    
    public String getVal(int id){
        for(int i= 0; i < tacStack.size(); i++){
            Tac temp = tacStack.get(i);
            if(temp.getId() == id){
                return temp.getVal();
            }
        }
        return "";
    }
    
    public void printTacs(){
        System.out.println("START PRINT TACS");
        for(int i = 0; i < tacStack.size(); i++){
            System.out.println(tacStack.get(i).getId()+" "+tacStack.get(i).getVal());
        }
        System.out.println("END PRINT TACS");
    }    
}
