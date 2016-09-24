package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase se encarga del comportamiento de las celdas
 */
public class SelectListener implements MouseListener {

    private JButton getButton(MouseEvent e){
        return (JButton) e.getSource();
    }

    public void mouseClicked(MouseEvent e){
        //TODO cell selected to controller
    }

    public void mouseEntered(MouseEvent e){
        getButton(e).setBackground(ColorSet.HOVER);
    }

    public void mouseExited(MouseEvent e){
        getButton(e).setBackground(ColorSet.NORMAL_BACKGROUND);
    }

    public void mousePressed(MouseEvent e){
        getButton(e).setBackground(ColorSet.NUMBER);
        getButton(e).setForeground(ColorSet.NORMAL_BACKGROUND);
    }

    public void mouseReleased(MouseEvent e){
        getButton(e).setBackground(ColorSet.NORMAL_BACKGROUND);
        getButton(e).setForeground(ColorSet.NUMBER);
    }

}
