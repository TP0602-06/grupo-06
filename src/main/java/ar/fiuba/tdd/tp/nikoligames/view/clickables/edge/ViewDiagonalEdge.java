package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LineGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tobias on 17/10/16.
 */
public class ViewDiagonalEdge extends ViewEdge {
    private List<EdgePosition> diagonals;
    private static final Integer startIndex = -1;
    private Integer actualIndex = startIndex;

    public ViewDiagonalEdge(EdgePosition joiner, SelectEdgeController controller) {
        super(controller);
        diagonals = new ArrayList<>();
        diagonals.add(joiner);

    }

    public void addOtherEdge(EdgePosition edge) {
        diagonals.add(edge);
    }


    public EdgePosition getDisplayedPosition() {
        if (actualIndex < 0) {
            return null;
        } else {
            return diagonals.get(actualIndex);
        }
    }

    @Override
    protected void toggleClick() {
        actualIndex++;
    }

    @Override
    public EdgePosition getEdgePositions() {
        return diagonals.get(0);
    }

    @Override
    protected void updateView() {
        resetGraphics();
        if (actualIndex >= diagonals.size()) {
            restartSequence();
        } else {
            paintEdge(diagonals.get(actualIndex));
        }
        setBackground(ColorSet.TRANSPARENT);
    }

    private void restartSequence() {
        actualIndex = startIndex;
    }

    private void paintEdge(EdgePosition actualDiagonal) {
        LinePosition start = startCorner(actualDiagonal);
        LinePosition end = endCorner(actualDiagonal);
        LineGraphicDraw graphicDraw = new LineGraphicDraw(ColorSet.EDGE, start, end);
        addGraphic(graphicDraw);
    }

    private LinePosition startCorner(EdgePosition actualDiagonal) {
        return getLinePosition(actualDiagonal, LinePosition.TOP_RIGHT, LinePosition.TOP_LEFT);
    }

    private LinePosition endCorner(EdgePosition actualDiagonal) {
        return getLinePosition(actualDiagonal, LinePosition.BOTTOM_LEFT, LinePosition.BOTTOM_RIGHT);
    }

    private LinePosition getLinePosition(EdgePosition actualDiagonal, LinePosition rightLeftDiagonl, LinePosition leftRightDiagonl) {
        Position topLeft = EdgePositionHelper.mostTopLeftPosition(actualDiagonal);
        Position bottomRight = EdgePositionHelper.mostBottomRightPosition(actualDiagonal);
        if (topLeft.getColumn() > bottomRight.getColumn()) {
            return rightLeftDiagonl;
        }
        return leftRightDiagonl;
    }
}
