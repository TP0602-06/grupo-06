package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicPaintAllBackground;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectNotDiagonalEdgeController;

import java.awt.*;

/**
 * Esta clase representa la visualizacion de una arista.
 */
public class DrawableEdge extends ViewEdge {

    private EdgePosition edgePositions;
    private boolean selected = false;
    private GraphicDraw backgroundPaint;

    public DrawableEdge(EdgePosition joiner, SelectEdgeController controller) {
        super(controller);
        edgePositions = joiner;
        backgroundPaint = new GraphicPaintAllBackground(ColorSet.EDGE);
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
        if (selected) {
            addGraphic(backgroundPaint);
        } else {
            resetGraphics();
        }
    }

    public boolean isSelected() {
        return selected;
    }
}
