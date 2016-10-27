package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.NoPlaysException;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LineGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.edgecontroller.SelectEdgeController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tobias on 17/10/16.
 */
public class ViewDiagonalEdge extends ViewEdge {
    private List<EdgePosition> diagonals;
    private Integer actualIndex = startIndex;
    private static final Integer startIndex = -1;
    private static final Integer needsTwoMovesForThisIndex = 0;

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
    public void undoClick(Game game) {
        goBackIndex();
        removePlayIfNecessary(game);
        updateView();
    }

    private void removePlayIfNecessary(Game game) {
        if (actualIndex.equals(needsTwoMovesForThisIndex)) {
            try {
                game.undoLastPlayMade();
            } catch (NoPlaysException e) {
                e.printStackTrace();
            }
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
    public boolean hasEdgePosition(EdgePosition edgePosition) {
        for (int edgeIndex = 0; edgeIndex < diagonals.size(); edgeIndex++) {
            EdgePosition actual = diagonals.get(edgeIndex);
            if (EdgePositionHelper.sameEdgePosition(edgePosition, actual)) {
                return true;
            }
        }
        return false;

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
        repaint();
    }

    private void restartSequence() {
        actualIndex = startIndex;
    }

    private void goBackIndex() {
        validateBackIndex();
        actualIndex--;
        validateBackIndex();
    }

    private void validateBackIndex() {
        if (actualIndex <= startIndex) {
            actualIndex = diagonals.size();
        }
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
