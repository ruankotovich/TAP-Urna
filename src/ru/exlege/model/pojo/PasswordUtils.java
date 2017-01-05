/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author dmitry
 */
public class PasswordUtils {

    public static String requestPassword(String titulo, String msg) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(msg);
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        pass.requestFocusInWindow();

        String[] options = new String[]{"OK", "Cancelar"};
        int option = JOptionPane.showOptionDialog(null, panel, titulo,
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        if (option == 0) {
            char[] password = pass.getPassword();
            return new String(password);
        } else {
            return null;
        }
    }
}
