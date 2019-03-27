/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.gui;

import dyslexia.ThrowingErrorListener;
import dyslexia.grammar.DyslexiaAnnotatedListener;
import dyslexia.grammar.DyslexiaAnnotatedListenerTac;
import dyslexia.grammar.DyslexiaEvaluator;
import dyslexia.grammar.DyslexiaLexer;
import dyslexia.grammar.DyslexiaParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author jonats
 */
public class PnlEditor extends javax.swing.JPanel {
    private JTabbedPane jTabbedPane1;
    private JScrollPane pnlTree;
    private PnlConsole pnlConsole;
    private FrmDislexia frmDislexia;
    private PnlTac pnlTac;
    
    /**
     * Creates new form PnlEditor
     */
    public PnlEditor(JTabbedPane jTabbedPane1, PnlConsole pnlConsole, FrmDislexia frmDislexia, PnlTac pnlTac) {
        initComponents();
        this.jTabbedPane1 = jTabbedPane1;
        this.pnlConsole = pnlConsole;
        this.frmDislexia = frmDislexia;
        this.pnlTac = pnlTac;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("compile and run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("open file");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 196, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private ParseTree generateParseTree(){
        System.out.println("GENERATING PARSE TREE");
        String program = jTextPane1.getText();
        //System.out.println("PROGRAM: " + program);
        DyslexiaLexer dyslexiaLexer = new DyslexiaLexer(new ANTLRInputStream(program));
        
        // For Own Implementation of Error Handling
        //dyslexiaLexer.removeErrorListeners();
        //dyslexiaLexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        
        // TODO add output for scanner displaying tokens.
        
//        List<? extends Token> tokens = dyslexiaLexer.getAllTokens();  
        //System.out.println("TOKEN SIZE: " + tokens.size());
        //System.out.println("ALL TOKENS: " + tokens);
          
//        System.out.println("TOKENS START");
//        for(int i = 0; i < tokens.size(); i++){
//            Token token = tokens.get(i);
//            String tokenTypeDisplayName = DyslexiaLexer.VOCABULARY.getDisplayName(token.getType());
//            String tokenTypeLiteral = DyslexiaLexer.VOCABULARY.getLiteralName(token.getType());
//            String tokenSymbolicName = DyslexiaLexer.VOCABULARY.getSymbolicName(token.getType());
//            System.out.println("i: " + i + " TOKEN: '" + token.getText() + "'" + 
//                    //" TOKEN TYPE LITERAL: " + tokenTypeLiteral + 
//                    //" TOKEN TYPE NAME: " +  tokenTypeDisplayName + 
//                    " TOKEN TYPE: " + tokenSymbolicName);      
//        }
//        System.out.println("TOKENS END");
        
        CommonTokenStream tokens = new CommonTokenStream(dyslexiaLexer);
        DyslexiaParser parser = new DyslexiaParser(tokens);
        
        // For Own Implementation of Error Handling
        //parser.removeErrorListeners();
        //parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        
        // parser.addErrorListener(new CustomAntlrListener());
        ParseTree tree = parser.compilationUnit();
        System.out.println("START TREE");
        System.out.println(tree.toStringTree(parser));
        System.out.println("END TREE");
        //System.out.println("TOKENS: " + tokens.getTokens());
        
        // Next will be EvalVisitor
        // EvalVisitor visitor = new EvalVisitor();
        //for(int i = 0; i < tokens.getTokens().size(); i ++){
        //    System.out.println(i + " TOKEN: " + tokens.getTokens().get(i));
        //}
        
        // Bad Practice
        // Adding and removing of tabs from the tabbedpane should be in FrmDislexia
        // Check if PnlTree is not null
        if ( this.pnlTree != null ) {
            jTabbedPane1.remove(pnlTree);
        }
        
        JPanel panel = new JPanel();
        JScrollPane scrPane = new JScrollPane(panel);
        this.pnlTree = scrPane;
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1.5);//scale a little
        panel.add(viewr);
        ImageIcon icon = new ImageIcon();   
        jTabbedPane1.addTab("parse tree", icon, scrPane, "tree");
        System.out.println("GENERATED PARSE TREE");
        
        return tree;
    }
    
    private void annotatedListener(ParseTree tree){
        System.out.println("ANNOTATED LISTENER CALLED");
        ParseTreeWalker walker = new ParseTreeWalker();
        DyslexiaAnnotatedListener annotatedListener = new DyslexiaAnnotatedListener(this.pnlConsole);
        walker.walk(annotatedListener, tree);
        System.out.println("ANNOTATED LISTENER CALLED");
    }

    private void annotatedListenerTac(ParseTree tree){
        System.out.println("ANNOTATED LISTENER CALLED");
        ParseTreeWalker walker = new ParseTreeWalker();
        DyslexiaAnnotatedListenerTac annotatedListener = new DyslexiaAnnotatedListenerTac(this.pnlTac);
        walker.walk(annotatedListener, tree);
        System.out.println("ANNOTATED LISTENER CALLED");
    }
    
    private void evaluate(ParseTree tree){
        System.out.println("EVALUATING TREE");
        DyslexiaEvaluator evaluator = new DyslexiaEvaluator(this.pnlConsole, this.frmDislexia);
        evaluator.visit(tree);
        System.out.println("EVALUATING TREE");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Compiling code...");
        ParseTree tree = generateParseTree();
        //annotatedListener(tree);
        evaluate(tree);
        System.out.println("Code Compiled.");
        annotatedListenerTac(tree);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //
            String content = "";
            try
            {
              BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
              String line;
              while ((line = reader.readLine()) != null)
              {
                content = content + line + "\n";
              }
              reader.close();
            }
            catch (Exception e)
            {
              System.err.format("Exception occurred trying to read '%s'.", selectedFile);
              e.printStackTrace();
            }            
            //
            jTextPane1.setText(content);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
