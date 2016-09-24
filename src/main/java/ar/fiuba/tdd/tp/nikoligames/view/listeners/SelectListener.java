package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import java.awt.event.*;

import javax.swing.*;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectListener implements MouseListener {
    private JButton getButton(MouseEvent event) {
        return (JButton) event.getSource();
    }

    public void mouseClicked(MouseEvent event) {
        //TODO cell selected to controller
    }

    public void mouseEntered(MouseEvent event) {
        getButton(event).setBackground(ColorSet.HOVER);
    }

    public void mouseExited(MouseEvent event) {
        getButton(event).setBackground(ColorSet.NORMAL_BACKGROUND);
    }

    public void mousePressed(MouseEvent event) {
        getButton(event).setBackground(ColorSet.NUMBER);
        getButton(event).setForeground(ColorSet.NORMAL_BACKGROUND);
    }

    public void mouseReleased(MouseEvent event) {
        getButton(event).setBackground(ColorSet.NORMAL_BACKGROUND);
        getButton(event).setForeground(ColorSet.NUMBER);
    }

}
