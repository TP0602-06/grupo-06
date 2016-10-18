package ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Created by tobias on 17/10/16.
 */
public abstract class StrategyPositionSolver {
    private GridView grid;
    private boolean viewCellsMatcheNodeView;

    public StrategyPositionSolver(GridView grid, boolean viewCellsMatcheNodeView) {
        this.grid = grid;
        this.viewCellsMatcheNodeView = viewCellsMatcheNodeView;
    }

    public abstract Position getStartPosition(EdgePosition position);

    public abstract Position getEndPosition(EdgePosition position);

    public Position transformPosition(Position modelPosition) {
        Integer coordinateX = getCoordinateOf(getGridCellWidth(), modelPosition.getColumn());
        Integer coordinateY = getCoordinateOf(getGridCellHeight(), modelPosition.getRow());

        if (viewCellsMatcheNodeView) {
            coordinateX = moveToAlignWidthInCenter(coordinateX);
            coordinateY = moveToAlignHeightInCenter(coordinateY);
        }

        return new ClassicPosition(coordinateX, coordinateY);
    }

    protected int getGridCellWidth() {
        Rectangle gridSize = grid.getBounds();
        return (int) Math.floor((double) gridSize.width / grid.getCols());
    }

    protected int getGridCellHeight() {
        Rectangle gridSize = grid.getBounds();
        return (int) Math.floor((double) gridSize.height / grid.getRows());
    }

    private int getCoordinateOf(Integer celSize, Integer position) {
        return celSize * position;
    }

    protected Integer getHalfOf(Integer celSize) {
        return (int) Math.floor((double) celSize / 2);
    }

    private Integer moveToAlignHeightInCenter(Integer coordinateY) {
        return coordinateY + getHalfOf(getGridCellHeight());
    }

    private Integer moveToAlignWidthInCenter(Integer coordinateX) {
        return coordinateX + getHalfOf(getGridCellWidth());
    }


}
