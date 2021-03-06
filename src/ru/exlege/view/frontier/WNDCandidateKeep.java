/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.view.frontier;

import ru.exlege.view.frontier.internal.IFInsertCandidate;
import ru.exlege.view.frontier.internal.IFEditCandidate;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import ru.exlege.model.bean.Candidato;
import ru.exlege.view.frontier.internal.IFListCandidate;

/**
 *
 * @author dmitry
 */
public class WNDCandidateKeep extends javax.swing.JFrame {

    /**
     * Creates new form WNDElectorKeep
     */
    private final JButton jBcad;
    private final JButton jBlis;
    private final JButton jBpes;

    public WNDCandidateKeep() {
        initComponents();

        jBcad = new JButton();
        jBcad.setText("Cadastro [+]");
        jBcad.setFocusable(false);

        jBcad.addActionListener((ActionEvent e) -> {
            IFInsertCandidate insertElector = new IFInsertCandidate();
            insertElector.setVisible(true);
            insertElector.setLocation(this.getWidth() / 2 - insertElector.getWidth() / 2,
                    this.getHeight() / 2 - insertElector.getHeight() / 2);
            jDPMainPanel.add(insertElector);
            try {
                insertElector.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(WNDCandidateKeep.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        jBlis = new JButton();
        jBlis.setText("Listagem [+]");
        jBlis.setFocusable(false);

        jBlis.addActionListener((ActionEvent e) -> {
            IFListCandidate ifListCandidate = new IFListCandidate(this);
            ifListCandidate.setVisible(true);
            ifListCandidate.setLocation(this.getWidth() / 2 - ifListCandidate.getWidth() / 2,
                    this.getHeight() / 2 - ifListCandidate.getHeight() / 2);
            jDPMainPanel.add(ifListCandidate);
            try {
                ifListCandidate.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(WNDCandidateKeep.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        jBpes = new JButton();
        jBpes.setText("Pesquisa [+]");
        jBpes.setFocusable(false);

        jBpes.addActionListener((ActionEvent e) -> {
            IFEditCandidate editCandidate = new IFEditCandidate();
            editCandidate.setVisible(true);
            editCandidate.setLocation(this.getWidth() / 2 - editCandidate.getWidth() / 2,
                    this.getHeight() / 2 - editCandidate.getHeight() / 2);
            jDPMainPanel.add(editCandidate);
            try {
                editCandidate.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(WNDCandidateKeep.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        jMenuBar1.add(jBcad);
        jMenuBar1.add(jBlis);
        jMenuBar1.add(jBpes);
    }

    public void editNewCandidate(Candidato can) {
        IFEditCandidate ifEdit = new IFEditCandidate(can);
        ifEdit.setVisible(true);
        ifEdit.setLocation(this.getWidth() / 2 - ifEdit.getWidth() / 2,
                this.getHeight() / 2 - ifEdit.getHeight() / 2);
        jDPMainPanel.add(ifEdit);
        try {
            ifEdit.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(WNDCandidateKeep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDPMainPanel = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon(getClass().getResource("/ru/exlege/view/gfx/bgenvironment_2.png")).getImage(), 0, 0, this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EX LEGE : Candidatos");
        setResizable(false);

        jDPMainPanel.setToolTipText("");
        jDPMainPanel.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WNDCandidateKeep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WNDCandidateKeep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WNDCandidateKeep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WNDCandidateKeep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WNDCandidateKeep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDPMainPanel;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
