package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectNotDiagonalEdgeController;

import java.awt.*;

/**
 * Esta clase representa la visualizacion de una arista.
 */
public class DrawableEdge extends ViewEdge {

    private EdgePosition edgePositions;
    private boolean selected = false;

    public DrawableEdge(EdgePosition joiner, SelectEdgeController controller) {
        super(controller);
        edgePositions = joiner;
    }

    @Override
    protected void toggleClick() {
        selected = !selected;
    }

    @Override
    public EdgePosition getEdgePositions() {
        return edgePositions;
    }

    @Override
    protected void updateView() {
        Color backgroundColor = ColorSet.TRANSPARENT;
        if (selected) {
            backgroundColor = ColorSet.EDGE;
        }
        setBackground(backgroundColor);
    }

    public boolean isSelected() {
        return selected;
    }
}
