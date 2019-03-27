/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia;

/**
 * Imports
 */
import dyslexia.grammar.*;
import dyslexia.gui.*;
import javax.swing.JFrame;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
/**
 *
 * @author jonats
 */
public class Dyslexia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // find a way to load grammar
        
        // Another code for initializing grammar
        //final Grammar g = Grammar.load(Dyslexia.);
        
        // Code for testing the lexer and parser
        //String program = "tni niam () {}";
        //System.out.println("PROGRAM: " + program);
        //DyslexiaLexer dyslexiaLexer = new DyslexiaLexer(new ANTLRInputStream(program));
        
        
        //CommonTokenStream tokens = new CommonTokenStream(dyslexiaLexer);
        //DyslexiaParser parser = new DyslexiaParser(tokens);
        //ParseTree tree = parser.code_block();
        
        //System.out.println("Acknowledged TOKENS: " + tokens.getTokens());
        //for(int i = 0; i < tokens.getTokens().size(); i ++){
        //    System.out.println(i + " TOKEN: " + tokens.getTokens().get(i));
        //}
        
        //System.out.println("Lexer All Tokens: " + dyslexiaLexer.getAllTokens());
        
        // Open GUI
        new FrmDislexia();
        //NewJFrame mainFrame = new NewJFrame();
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainFrame.setVisible(true);
    }
    
}
