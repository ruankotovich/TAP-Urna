/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.view.frontier;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import ru.exlege.model.bean.Eleitor;
import ru.exlege.model.dao.EleitorDao;

/**
 *
 * @author dmitry
 */
public class IFEditElector extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFInsertElector
     */
    private Eleitor current;

    public IFEditElector() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTtitulo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTdat = new com.toedter.calendar.JCalendar();
        jBcad = new javax.swing.JButton();
        jBcancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTpesquisa = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edição de Eleitor");
        setToolTipText("");
        setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(12, 111, 209));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Nome : ");

        jTnome.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTnome.setEnabled(false);
        jTnome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTnomeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nº Título : ");

        try {
            jTtitulo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTtitulo.setEnabled(false);
        jTtitulo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jTtitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTtituloMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Data de Nascimento : ");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 5, true));
        jPanel2.setOpaque(false);

        jTdat.setBackground(new java.awt.Color(254, 254, 254));
        jTdat.setOpaque(false);
        jTdat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTdatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTdat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTdat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)
        );

        jBcad.setBackground(new java.awt.Color(205, 204, 35));
        jBcad.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBcad.setForeground(new java.awt.Color(254, 254, 254));
        jBcad.setText("Alterar");
        jBcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcadActionPerformed(evt);
            }
        });

        jBcancel.setBackground(new java.awt.Color(151, 2, 36));
        jBcancel.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBcancel.setForeground(new java.awt.Color(254, 254, 254));
        jBcancel.setText("Excluir");
        jBcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(5, 76, 148));

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Pesquisar : ");

        try {
            jTpesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTpesquisa.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(18, 0, 112));
        jButton1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTpesquisa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTnome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTtitulo))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBcancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBcad, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnome, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancel)
                    .addComponent(jBcad))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcadActionPerformed
        Eleitor eleitor = new Eleitor(
                Long.parseLong(jTtitulo.getText().replace(" ", "")),
                jTnome.getText(),
                new SimpleDateFormat("dd/MM/yyyy").format(jTdat.getDate()));
        if (EleitorDao.cadastrar(eleitor)) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Realizado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não realizado!\nConsulte o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBcadActionPerformed

    private void jBcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelActionPerformed
        if (current != null) {
            if (EleitorDao.deletar(current.getTitulo())) {
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!", "Realizado", JOptionPane.INFORMATION_MESSAGE);
                jTnome.setText("");
                jTtitulo.setText("");
                jTpesquisa.grabFocus();
                jTnome.setEnabled(false);
                jTtitulo.setEnabled(false);
                jTpesquisa.setText("");
                jTpesquisa.grabFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Eleitor não excluído!\nConsulte o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Eleitor à ser excluído", "Erro", JOptionPane.ERROR_MESSAGE);
            jTpesquisa.grabFocus();
        }
    }//GEN-LAST:event_jBcancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Eleitor ele;
        current = ele = EleitorDao.consultar(Long.parseLong(jTpesquisa.getText().replace(" ", "")));
        if (ele != null) {
            jTnome.setText(ele.getNome());
            jTtitulo.setText(jTpesquisa.getText());
            try {
                jTdat.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(ele.getNascimento()));
            } catch (ParseException ex) {
                jPanel2.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
                Logger.getLogger(IFEditElector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Eleitor não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            jTnome.setText("");
            jTtitulo.setText("");
            jTnome.setEnabled(false);
            jTtitulo.setEnabled(false);
            jTpesquisa.grabFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTnomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTnomeMouseClicked
        /*
        ¬A ^ ¬B
        
         A B
         0 0 1 
         0 1 0
         1 0 0
         1 1 0
        
        ¬(A v B)
         A B
         0 0 1
         0 1 0
         1 0 0
         1 1 0
         */

        if (current != null) {
            jTnome.setEnabled(true);
        }
    }//GEN-LAST:event_jTnomeMouseClicked

    private void jTtituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTtituloMouseClicked
        if (current != null) {
            jTtitulo.setEnabled(true);
        }
    }//GEN-LAST:event_jTtituloMouseClicked

    private void jTdatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTdatMouseClicked
        if (current != null) {
            jTdat.setEnabled(true);
        }
    }//GEN-LAST:event_jTdatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcad;
    private javax.swing.JButton jBcancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JCalendar jTdat;
    private javax.swing.JTextField jTnome;
    private javax.swing.JFormattedTextField jTpesquisa;
    private javax.swing.JFormattedTextField jTtitulo;
    // End of variables declaration//GEN-END:variables
}