/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

import javax.swing.JComponent;
import javax.swing.JPanel;
import ru.exlege.view.frontier.WNDVotacao;

/**
 *
 * @author dmitry
 */
public abstract class PNLVotacaoChildren extends JPanel {

    private final WNDVotacao caller;
    private JComponent mainComponent;

    public PNLVotacaoChildren(WNDVotacao calling) {
        this.caller = calling;
    }

    public void setMainComponent(JComponent mainComponent) {
        this.mainComponent = mainComponent;
    }

    public void grabFocusToMain() {
        if (mainComponent != null) {
            mainComponent.requestFocus();
            mainComponent.grabFocus();
        }
    }

    public WNDVotacao getCaller() {
        return caller;
    }

}
