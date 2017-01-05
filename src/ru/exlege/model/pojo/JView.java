/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import ru.exlege.view.frontier.WNDMainWindow;

/**
 *
 * @author dmitry
 */
public abstract class JView extends JPanel implements MouseMotionListener {

    private final WNDMainWindow viewParent;

    public JView(WNDMainWindow parent, boolean moveable) {
        this.viewParent = parent;
        if (moveable) {
            this.addMouseMotionListener(this);
        }
    }

    public void performAction(String action, Object[] args) {
        viewParent.trigger(action, args);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(e.getLocationOnScreen().x - this.getWidth() / 2, e.getLocationOnScreen().y - this.getHeight() / 2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
