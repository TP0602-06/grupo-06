package ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Created by tobias on 17/10/16.
 */
public class CommonPositionSolver extends StrategyPositionSolver {
    private double edgeProportion = 0.2;

    public CommonPositionSolver(GridView grid, boolean viewCellsMatchNodeView) {
        super(grid, viewCellsMatchNodeView);
    }

    private int getScaledEdgeHeight() {
        return (int) Math.floor(getGridCellHeight() * edgeProportion);
    }

    private int getScaledEdgeWidth() {
        return (int) Math.floor(getGridCellWidth() * edgeProportion);
    }

    private int getHalfEdgeHeight() {
        return getHalfOf(getScaledEdgeHeight());
    }

    private int getHalfEdgeWidth() {
        return getHalfOf(getScaledEdgeWidth());
    }

    @Override
    public Position getStartPosition(EdgePosition edge) {
        Position start = EdgePositionHelper.mostTopLeftPosition(edge);
        return getViewPositionOf(edge, start, -1);
    }

    private boolean isHorizontal(EdgePosition edgePosition) {
        Position position1 = edgePosition.getPosition1();
        Position position2 = edgePosition.getPosition2();
        return position1.getRow() == position2.getRow();
    }

    @Override
    public Position getEndPosition(EdgePosition edge) {
        Position end = EdgePositionHelper.mostBottomRightPosition(edge);
        return getViewPositionOf(edge, end, 1);
    }

    private Position getViewPositionOf(EdgePosition edge, Position position, Integer moveFactor) {
        Position viewPosition = transformPosition(position);
        Integer actualX = viewPosition.getRow();
        Integer actualY = viewPosition.getColumn();

        if (isHorizontal(edge)) {
            actualY += moveFactor * getHalfEdgeHeight();
        } else {
            actualX += moveFactor * getHalfEdgeWidth();
        }
        return new ClassicPosition(actualX, actualY);
    }


}
