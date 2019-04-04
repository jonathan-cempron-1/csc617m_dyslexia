/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.gui;

import javax.swing.ImageIcon;

/**
 *
 * @author jonats
 */
public class FrmDislexia extends javax.swing.JFrame {
    
    public PnlSemantic pnlSemantic;
    
    /**
     * Creates new form FrmDislexia
     */
    public FrmDislexia() {
        initComponents();
        ImageIcon icon = new ImageIcon();
        //PnlTree pnlTree = new PnlTree();
        PnlConsole pnlConsole = new PnlConsole();
        PnlTac pnlTac = new PnlTac();
        PnlParser pnlParser = new PnlParser();
        this.pnlSemantic = new PnlSemantic();
        jTabbedPane1.addTab("editor", icon, new PnlEditor(jTabbedPane1, pnlConsole, this, pnlTac, pnlParser), "editor");
        //jTabbedPane1.addTab("parse tree", icon, new PnlTree(), "tree");
        jTabbedPane2.addTab("console", icon, pnlConsole, "console");
        jTabbedPane2.addTab("debug", icon, new PnlScanner(), "debug");
        jTabbedPane2.addTab("parser", icon, pnlParser, "parser");
        jTabbedPane2.addTab("semantic", icon, pnlSemantic, "semantic");
        jTabbedPane2.addTab("tac", icon, pnlTac, "tac");
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
