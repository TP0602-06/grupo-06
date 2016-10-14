package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase es la escuchadora de la seleccion de lasa aristas;
 */
public class EdgeSelectedListener extends MouseAdapter {

    private SelectEdgeController controler;

    public EdgeSelectedListener(SelectEdgeController controler) {
        this.controler = controler;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        DrawableEdge edge = (DrawableEdge) mouseEvent.getSource();
        controler.notifySelectedEdge(edge);
    }
}
