package ar.fiuba.tdd.tp.nikoligames.view.edge;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.EdgeSelectedListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;

import javax.swing.*;

/**
 * Esta clase representa la visualizacion de una arista.
 */
public class DrawableEdge extends JButton {

    private EdgePosition edgePositions;
    private boolean selected = false;

    public DrawableEdge(EdgePosition joiner, SelectEdgeController controller) {
        edgePositions = joiner;
        addMouseListener(new EdgeSelectedListener(controller));
        setBackground(ColorSet.TRANSPARENT);

    }

    public void select() {
        setBackground(ColorSet.EDGE);
        selected = true;
    }

    public void deselect() {
        setBackground(ColorSet.TRANSPARENT);
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public EdgePosition getEdgePositions() {
        return edgePositions;
    }
}
