package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicPaintAllBackground;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.edgecontroller.SelectEdgeController;


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
    public void undoClick(Game game) {
        super.clicked();
        repaint();
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
    public boolean hasEdgePosition(EdgePosition edgePosition) {
        return EdgePositionHelper.sameEdgePosition(edgePosition,this.edgePositions);
    }

    @Override
    protected void updateView() {
        if (selected) {
            GraphicDraw backgroundPaint = new GraphicPaintAllBackground(ColorSet.EDGE);
            addGraphic(backgroundPaint);
        } else {
            resetGraphics();
        }
    }

    public boolean isSelected() {
        return selected;
    }
}
