/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.gui;

import dyslexia.ThrowingErrorListener;
import dyslexia.grammar.*;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.autocomplete.*;

/**
 *
 * @author jonats
 */
public class PnlEditor extends javax.swing.JPanel {
    RSyntaxTextArea jTextPane1 = new RSyntaxTextArea(20, 60);
    private JTabbedPane jTabbedPane1;
    private JScrollPane pnlTree;
    private PnlConsole pnlConsole;
    private FrmDislexia frmDislexia;
    private PnlTac pnlTac;
    private PnlParser pnlParser;
    private PnlSemantic pnlSemantic;
    private DefaultCompletionProvider completionProvider = new DefaultCompletionProvider();
    
    /**
     * Creates new form PnlEditor
     */
    public PnlEditor(JTabbedPane jTabbedPane1, PnlConsole pnlConsole, FrmDislexia frmDislexia, PnlTac pnlTac, PnlParser pnlParser) {
        initComponents();
        this.jTabbedPane1 = jTabbedPane1;
        this.pnlConsole = pnlConsole;
        this.frmDislexia = frmDislexia;
        this.pnlTac = pnlTac;
        this.pnlParser = pnlParser;
        this.pnlSemantic = this.frmDislexia.pnlSemantic; 
        
        jTextPane1.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        jTextPane1.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(jTextPane1);
        
        // A CompletionProvider is what knows of all possible completions, and
        // analyzes the contents of the text area at the caret position to
        // determine what completion choices should be presented. Most instances
        // of CompletionProvider (such as DefaultCompletionProvider) are designed
        // so that they can be shared among multiple text components.
        CompletionProvider provider = createCompletionProvider();

        // An AutoCompletion acts as a "middle-man" between a text component
        // and a CompletionProvider. It manages any options associated with
        // the auto-completion (the popup trigger key, whether to display a
        // documentation window along with completion choices, etc.). Unlike
        // CompletionProviders, instances of AutoCompletion cannot be shared
        // among multiple text components.
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(jTextPane1);
        
        //sp.setBounds(10, 10, 200, 200);
        sp.setBounds(10, 10, 960, 345);
        this.add(sp, BorderLayout.CENTER);
    }
    
    private String cleanLineFor(String line){
        
            line = line.replaceAll(";", " ; ");
            line = line.replaceAll("\\{", " ");
            line = line.replaceAll("}", " ");
            line = line.replaceAll("\\[", " ");
            line = line.replaceAll("]", " ");
            line = line.replaceAll("\\(", " ");
            line = line.replaceAll("\\)", " ");
            line = line.replaceAll("\"", " ");
            line = line.replaceAll("\'", " ");
            line = line.replaceAll("\\+", " + ");
            line = line.replaceAll("=", " = ");
            line = line.replaceAll("-", " - ");
            line = line.replaceAll("\\*", " * ");
            line = line.replaceAll("/", " / ");
            line = line.replaceAll("\\.", " ");
            line = line.replaceAll(",", " ");
            line = line.replaceAll("<", " < ");
            line = line.replaceAll(">", " > ");
            line = line.replaceAll("!", " ! ");
            line = line.replaceAll("%", " % ");
            line = line.replaceAll("&", " & ");
            line = line.replaceAll("\\|", " | ");
            line = line.replaceAll("\\?", " ");
            line = line.replaceAll("\\^", " ^ ");
            line = line.replaceAll("rof", " ");
            line = line.replaceAll("\\s+", " ");
            return line;
    }
    
        private String cleanLine(String line){
        
            line = line.replaceAll(";", " ");
            line = line.replaceAll("\\{", " ");
            line = line.replaceAll("}", " ");
            line = line.replaceAll("\\[", " ");
            line = line.replaceAll("]", " ");
            line = line.replaceAll("\\(", " ");
            line = line.replaceAll("\\)", " ");
            line = line.replaceAll("\"", " ");
            line = line.replaceAll("\'", " ");
            line = line.replaceAll("\\+", " ");
            line = line.replaceAll("=", " ");
            line = line.replaceAll("-", " ");
            line = line.replaceAll("\\*", " ");
            line = line.replaceAll("/", " ");
            line = line.replaceAll("\\.", " ");
            line = line.replaceAll(",", " ");
            line = line.replaceAll("<", " ");
            line = line.replaceAll(">", " ");
            line = line.replaceAll("!", " ");
            line = line.replaceAll("%", " ");
            line = line.replaceAll("&", " ");
            line = line.replaceAll("\\|", " ");
            line = line.replaceAll("\\?", " ");
            line = line.replaceAll("\\^", " ");
            line = line.replaceAll("\\s+", " ");
            return line;
    }

    private String cleanLineSaveScope(String line){
        
            line = line.replaceAll(";", " ");
            line = line.replaceAll("\\{", " \\{ ");
            line = line.replaceAll("}", " } ");
            line = line.replaceAll("\\[", " ");
            line = line.replaceAll("]", " ");
            line = line.replaceAll("\\(", " ");
            line = line.replaceAll("\\)", " ");
            line = line.replaceAll("\"", " ");
            line = line.replaceAll("\'", " ");
            line = line.replaceAll("\\+", " ");
            line = line.replaceAll("=", " ");
            line = line.replaceAll("-", " ");
            line = line.replaceAll("\\*", " ");
            line = line.replaceAll("/", " ");
            line = line.replaceAll("\\.", " ");
            line = line.replaceAll(",", " ");
            line = line.replaceAll("<", " ");
            line = line.replaceAll(">", " ");
            line = line.replaceAll("!", " ");
            line = line.replaceAll("%", " ");
            line = line.replaceAll("&", " ");
            line = line.replaceAll("\\|", " ");
            line = line.replaceAll("\\?", " ");
            line = line.replaceAll("\\^", " ");
            line = line.replaceAll("\\s+", " ");
            return line;
    }        
    
    public void addCompletion(String text){
        completionProvider.addCompletion(new BasicCompletion(completionProvider, text));
        AutoCompletion ac = new AutoCompletion(completionProvider);
        ac.install(jTextPane1);
    }

   /**
    * Create a simple provider that adds some Java-related completions.
    */
   private CompletionProvider createCompletionProvider() {

      // A DefaultCompletionProvider is the simplest concrete implementation
      // of CompletionProvider. This provider has no understanding of
      // language semantics. It simply checks the text entered up to the
      // caret position for a match against known completions. This is all
      // that is needed in the majority of cases.
      /*
      DefaultCompletionProvider provider = new DefaultCompletionProvider();

      // Add completions for all Java keywords. A BasicCompletion is just
      // a straightforward word completion.
      provider.addCompletion(new BasicCompletion(provider, "abstract"));
      provider.addCompletion(new BasicCompletion(provider, "assert"));
      provider.addCompletion(new BasicCompletion(provider, "break"));
      provider.addCompletion(new BasicCompletion(provider, "case"));
      // ... etc ...
      provider.addCompletion(new BasicCompletion(provider, "transient"));
      provider.addCompletion(new BasicCompletion(provider, "transientasdasd"));
      provider.addCompletion(new BasicCompletion(provider, "try"));
      provider.addCompletion(new BasicCompletion(provider, "void"));
      provider.addCompletion(new BasicCompletion(provider, "volatile"));
      provider.addCompletion(new BasicCompletion(provider, "while"));

      // Add a couple of "shorthand" completions. These completions don't
      // require the input text to be the same thing as the replacement text.
      provider.addCompletion(new ShorthandCompletion(provider, "sysout",
            "System.out.println(", "System.out.println("));
      provider.addCompletion(new ShorthandCompletion(provider, "syserr",
            "System.err.println(", "System.err.println("));

      return provider;
      */
      String[] initlist = {"tcartsba",
                        "tressa",
                        "naeloob",
                        "kaerb",
                        "etyb",
                        "esac",
                        "hctac",
                        "rahc",
                        "ssalc",
                        "tsnoc",
                        "eunitnoc",
                        "tluafed",
                        "od",
                        "elbuod",
                        "esle",
                        "mune",
                        "sdnetxe",
                        "lanif",
                        "yllanif",
                        "taolf",
                        "rof",
                        "fi",
                        "otog",
                        "stnemelpmi",
                        "tropmi",
                        "foecnatsni",
                        "tni",
                        "ecafretni",
                        "gnol",
                        "evitan",
                        "wen",
                        "egakcap",
                        "etavirp",
                        "detcetorp",
                        "cilbup",
                        "nruter",
                        "trohs",
                        "citats",
                        "pftcirts",
                        "repus",
                        "hctiws",
                        "dezinorhcnys",
                        "siht",
                        "worht",
                        "sworht",
                        "tneisnart",
                        "yrt",
                        "diov",
                        "elitalov",
                        "elihw"};
      for(int i = 0; i < initlist.length; i++){
          completionProvider.addCompletion(new BasicCompletion(completionProvider, initlist[i]));
      }
      return completionProvider;

   }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

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

        jButton3.setText("init basic code template");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("loop invariant optimize");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("loop unroll optimize");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
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
        DyslexiaParserErrorListener parserErrorListener = new DyslexiaParserErrorListener();
        //parser.removeErrorListeners();
        parser.addErrorListener(parserErrorListener);
        
        ParseTree tree = parser.compilationUnit();
        System.out.println("START TREE");
        System.out.println(tree.toStringTree(parser));
        System.out.println("END TREE");
        // printing Errors
        pnlParser.printErrors(parserErrorListener.errors);
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
    
    private boolean semanticErrorListener(ParseTree tree){
        System.out.println("CHECKING SEMANTIC ERRORS");
        ParseTreeWalker walker = new ParseTreeWalker();
        DyslexiaSemanticErrorListener semanticErrorListener = new DyslexiaSemanticErrorListener();
        //walker.walk(semanticErrorListener, tree);
        System.out.println("CHECKED SEMANTIC ERRORS");
        return false;
    }
    
    private boolean semanticErrorVisitor(ParseTree tree){
        System.out.println("CHECKING SEMANTIC ERRORS");
        DyslexiaSemanticErrorVisitor errorVisitor = new DyslexiaSemanticErrorVisitor(this.pnlSemantic);
        errorVisitor.visit(tree);
        System.out.println("CHECKED SEMANTIC ERRORS");
        if (errorVisitor.errors.isEmpty())
            return false;
        else 
            this.pnlSemantic.printErrors(errorVisitor.errors);
        return true;
    }
    
    private void evaluate(ParseTree tree){
        System.out.println("EVALUATING TREE");
        DyslexiaEvaluator evaluator = new DyslexiaEvaluator(this.pnlConsole, this.frmDislexia);
        evaluator.visit(tree);
        System.out.println("EVALUATING TREE");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        System.out.println("Interpreting code...");
        ParseTree tree = generateParseTree();
        if ( semanticErrorVisitor(tree) ){
            System.out.println("There are semantic errors.");
        } else {
            //annotatedListener(tree);
            evaluate(tree);
        }
        System.out.println("Code Interpreted.");
        //annotatedListenerTac(tree);
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
            
            content = cleanLine(content);
            String[] splitcontent = content.split("\\s+");
            /*
            for(int i = 0; i < splitcontent.length; i++){
                addCompletion(splitcontent[i]);
                System.out.println(splitcontent[i]);
            }
            */
            List<String> list = Arrays.asList(splitcontent);
            Set<String> set = new HashSet<String>(list);

            String[] reslt = new String[set.size()];
            set.toArray(reslt);
            for (String s : reslt)
              if(notInKey(s))
                addCompletion(s);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean notInKey(String s){
              String[] initlist = {"tcartsba",
                        "tressa",
                        "naeloob",
                        "kaerb",
                        "etyb",
                        "esac",
                        "hctac",
                        "rahc",
                        "ssalc",
                        "tsnoc",
                        "eunitnoc",
                        "tluafed",
                        "od",
                        "elbuod",
                        "esle",
                        "mune",
                        "sdnetxe",
                        "lanif",
                        "yllanif",
                        "taolf",
                        "rof",
                        "fi",
                        "otog",
                        "stnemelpmi",
                        "tropmi",
                        "foecnatsni",
                        "tni",
                        "ecafretni",
                        "gnol",
                        "evitan",
                        "wen",
                        "egakcap",
                        "etavirp",
                        "detcetorp",
                        "cilbup",
                        "nruter",
                        "trohs",
                        "citats",
                        "pftcirts",
                        "repus",
                        "hctiws",
                        "dezinorhcnys",
                        "siht",
                        "worht",
                        "sworht",
                        "tneisnart",
                        "yrt",
                        "diov",
                        "elitalov",
                        "elihw"};
        for(int i = 0; i < initlist.length; i++)
            if(initlist[i].equals(s))
                return false;
        return true;
    }
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextPane1.setText("cilbup ssalc myClass{\n" +
"	\n" +
"	// create functions here\n" +
"	\n" +
"	cilbup citats diov niam(){\n" +
"		// TODO add your handling code here:\n" +
"		\n" +
"	}\n" +
"\n" +
"}");
        addCompletion("titosotto");
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean hasOpenCurly(String[] arg){
        for(int i = 0; i < arg.length; i++)
            if(arg[i].equalsIgnoreCase("{"))
                return true;
        return false;
    }

    private boolean hasCloseCurly(String[] arg){
        for(int i = 0; i < arg.length; i++)
            if(arg[i].equalsIgnoreCase("}"))
                return true;
        return false;
    }
    
    private boolean hasLoopingVar(String line, String loopingVar){
        line = cleanLineSaveScope(line);
        String[] lineArr = line.split("\\s+");
        for(int i = 0; i < lineArr.length; i++)
            if(lineArr[i].equals(loopingVar))
                return true;
        return false;
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String rawCode = jTextPane1.getText();
        String[] rawCodeArr = rawCode.split("\n");
        
        // rawcode linked list copy
        LinkedList<String> rawCodeLl = new LinkedList<String>();
        for(int i = 0; i < rawCodeArr.length; i++)
            rawCodeLl.add(rawCodeArr[i]);
        
        int flStart = -1;
        int flEnd = -1;
        // find for loop start
        for(int i = 0; i < rawCodeArr.length; i++){
            String line = rawCodeArr[i];
            line = cleanLineSaveScope(line);
            String[] lineArr = line.split("\\s+");
            for(int j = 0; j < lineArr.length; j++){
                if(lineArr[j].equals("rof"))
                    flStart = i;
            }
        }
        // find for loop end
        if(flStart != -1){
            LinkedList<String> scopeStack = new LinkedList<String>();
            for(int i = flStart; i < rawCodeArr.length; i++){
                String line = rawCodeArr[i];
                line = cleanLineSaveScope(line);
                String[] lineArr = line.split("\\s+");
                if(hasOpenCurly(lineArr))
                    scopeStack.push("{");
                if(hasCloseCurly(lineArr))
                    scopeStack.pop();
                if(scopeStack.isEmpty()){
                    flEnd = i;
                    break;
                }
            }
        }
        System.out.println("for detected start "+flStart);
        System.out.println("for detected end "+flEnd);
        
        String loopingVar = "";
        // get looping var
        if(flStart != -1 && flEnd != -1){
            String[] temp = cleanLine(rawCodeArr[flStart]).split("\\s+");
            for(int i = 0; i < temp.length; i++)
                if(temp[i].equals("rof")){
                    loopingVar = temp[i+1];
                    break;
                }
        }
        System.out.println("looping variable "+loopingVar);

        LinkedList<Integer> loopInvLines = new LinkedList<Integer>();
        // get inner lines without looping var
        for(int i = flStart; i < flEnd; i++){
            if(!hasLoopingVar(rawCodeArr[i], loopingVar)){
                loopInvLines.add(i);
            }
        }
        
        // collect invariant lines
        LinkedList<String> invLines = new LinkedList<String>();
        for(int i = 0; i < loopInvLines.size(); i++) {
            invLines.add(rawCodeArr[loopInvLines.get(i)]);
        }
        
        // remove invariant lines
        for(int i = loopInvLines.size()-1; i >= 0; i--)
            rawCodeLl.set(loopInvLines.get(i), "\t\t\t\t//transferred out loop");
        
        // insert invariant lines top of loop
        for(int i = loopInvLines.size()-1; i >= 0; i--)
            rawCodeLl.add(flStart, invLines.get(i));
        
        System.out.println("invariant lines:");
        for(int i =0; i < invLines.size(); i++)
            System.out.println(invLines.get(i));
        
        String newContent = "";
        for(int i =0; i < rawCodeLl.size(); i++)
            newContent = newContent + rawCodeLl.get(i) + "\n";
        
        jTextPane1.setText(newContent);
                
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String rawCode = jTextPane1.getText();
        String[] rawCodeArr = rawCode.split("\n");
        
        // rawcode linked list copy
        LinkedList<String> rawCodeLl = new LinkedList<String>();
        for(int i = 0; i < rawCodeArr.length; i++)
            rawCodeLl.add(rawCodeArr[i]);
        
        int flStart = -1;
        int flEnd = -1;
        // find for loop start
        for(int i = 0; i < rawCodeArr.length; i++){
            String line = rawCodeArr[i];
            line = cleanLineSaveScope(line);
            String[] lineArr = line.split("\\s+");
            for(int j = 0; j < lineArr.length; j++){
                if(lineArr[j].equals("rof"))
                    flStart = i;
            }
        }
        // find for loop end
        if(flStart != -1){
            LinkedList<String> scopeStack = new LinkedList<String>();
            for(int i = flStart; i < rawCodeArr.length; i++){
                String line = rawCodeArr[i];
                line = cleanLineSaveScope(line);
                String[] lineArr = line.split("\\s+");
                if(hasOpenCurly(lineArr))
                    scopeStack.push("{");
                if(hasCloseCurly(lineArr))
                    scopeStack.pop();
                if(scopeStack.isEmpty()){
                    flEnd = i;
                    break;
                }
            }
        }
        System.out.println("for detected start "+flStart);
        System.out.println("for detected end "+flEnd);
        
        String loopInit = "";
        String loopCond = "";
        String loopUpdate = "";
        // get init cond and update
        if(flStart != -1 && flEnd != -1){
            String[] temp = cleanLineFor(rawCodeArr[flStart]).split(";");
            loopInit = temp[0];
            loopCond = temp[1];
            loopUpdate = temp[2];
        }
        System.out.println("looping init "+loopInit);;
        System.out.println("looping cond "+loopCond);
        System.out.println("looping update "+loopUpdate);
        
        String loopingVar = "";
        String loopingVal = "";
        // get loop var and val
        if(flStart != -1 && flEnd != -1){
            String[] loopInitArr = loopInit.replaceAll("\\s+","").replaceAll("\\s+","").split("=");
            loopingVar = loopInitArr[0];
            loopingVal = loopInitArr[1];
        }
        System.out.println("looping var "+loopingVar);
        System.out.println("looping val "+loopingVal);

        String loopComp = "";
        String loopUB = "";
        // get condition comparator and upper bound
        if(flStart != -1 && flEnd != -1){
            String[] loopCondArr = loopCond.replaceAll(loopingVar,"").replaceAll("\\s+"," ").split(" ");
            loopComp = loopCondArr[1];
            loopUB = loopCondArr[2];
        }
        System.out.println("loop comp "+loopComp);
        System.out.println("loop ub "+loopUB);
        
        int ub = -1;
        int lb = -1;
        // get upperBound and lower bound
        if(flStart != -1 && flEnd != -1){
            if(loopComp.equals("<")){
                lb = Integer.parseInt(loopingVal);
                ub = Integer.parseInt(loopUB);
            }
        }
        System.out.println("detected iteration lower bound "+lb);
        System.out.println("detected iteration upper bound "+ub);
        
        // remove the original loop
        for(int i = flStart; i < flEnd; i++){
            rawCodeLl.set(i, "\t\t\t\t// original loop removed");
        }
        
        // repeat loop
        for(int i = lb; i < ub; i++){
            rawCodeLl.add(flStart, "\t\t\t\t"+loopUpdate);
            for(int j = flEnd-1; j >= flStart+1; j--){
                rawCodeLl.add(flStart, rawCodeArr[j]);
            }
        }
        rawCodeLl.add(flStart, "\t\t\t\t"+loopInit);
        int looplen = ub-lb;
        rawCodeLl.add(flStart, "\t\t\t\t// loop unrolled by "+looplen+" via ub:"+ub+" lb:"+lb);
        
        // set contents
        String newContent = "";
        for(int i =0; i < rawCodeLl.size(); i++)
            newContent = newContent + rawCodeLl.get(i) + "\n";
        
        jTextPane1.setText(newContent);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
