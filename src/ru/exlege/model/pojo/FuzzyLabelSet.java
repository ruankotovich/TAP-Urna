/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author dmitry
 */
public class FuzzyLabelSet implements MouseListener {
    
    private JLabel last = null;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel current = (JLabel) (e.getSource());
        current.setBackground(Color.yellow);
        if (last != null) {
            last.setBackground(Color.white);
        }
        last = current;
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        JLabel current = (JLabel) (e.getSource());
        current.setBackground(Color.white);
    }
    
}
