/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.view.frontier.internal;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import ru.exlege.model.bean.Eleitor;
import ru.exlege.model.dao.EleitorDao;

/**
 *
 * @author dmitry
 */
public class IFInsertElector extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFInsertElector
     */
    public IFInsertElector() {
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

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Eleitoral");
        setToolTipText("");
        setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(12, 111, 209));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Nome : ");

        jTnome.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnomeActionPerformed(evt);
            }
        });
        jTnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTnomeKeyReleased(evt);
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
        jTtitulo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Data de Nascimento : ");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 5, true));
        jPanel2.setOpaque(false);

        jTdat.setBackground(new java.awt.Color(254, 254, 254));
        jTdat.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTdat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTdat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jBcad.setBackground(new java.awt.Color(1, 119, 13));
        jBcad.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBcad.setForeground(new java.awt.Color(254, 254, 254));
        jBcad.setText("Cadastrar");
        jBcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcadActionPerformed(evt);
            }
        });

        jBcancel.setBackground(new java.awt.Color(151, 2, 36));
        jBcancel.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBcancel.setForeground(new java.awt.Color(254, 254, 254));
        jBcancel.setText("Cancel");
        jBcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBcancel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBcad, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTnome)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcancel)
                    .addComponent(jBcad))
                .addContainerGap())
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

    private void jTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnomeActionPerformed

    private void jTnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTnomeKeyReleased
        String buffer = jTnome.getText();
        this.setTitle(buffer.isEmpty() ? "Cadastro Eleitoral" : buffer);
    }//GEN-LAST:event_jTnomeKeyReleased

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
        this.dispose();
    }//GEN-LAST:event_jBcancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcad;
    private javax.swing.JButton jBcancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JCalendar jTdat;
    private javax.swing.JTextField jTnome;
    private javax.swing.JFormattedTextField jTtitulo;
    // End of variables declaration//GEN-END:variables
}
