package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * Esta clase es la escuchadora de la seleccion de lasa aristas.
 */
public class EdgeSelectedListener extends MouseAdapter {

    private SelectEdgeController controler;

    public EdgeSelectedListener(SelectEdgeController controler) {
        this.controler = controler;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        ViewEdge edge = (ViewEdge) mouseEvent.getSource();
        controler.notifySelectedEdge(edge);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        ViewEdge edge = (ViewEdge) mouseEvent.getSource();
        edge.setBorder(BorderFactory.createLineBorder(ColorSet.HOVER));
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        ViewEdge edge = (ViewEdge) mouseEvent.getSource();
        edge.setBorder(null);
    }
}
