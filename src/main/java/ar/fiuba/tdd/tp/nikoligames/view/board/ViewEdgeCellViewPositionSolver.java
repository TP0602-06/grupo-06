package ar.fiuba.tdd.tp.nikoligames.view.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver.CellSizeCalculator;
import ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver.CommonPositionSolver;
import ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver.DiagonalPositionSolver;
import ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver.StrategyPositionSolver;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Created by tobias on 15/10/16.
 */
public class ViewEdgeCellViewPositionSolver {
    private StrategyPositionSolver diagonalSolver;
    private StrategyPositionSolver commonSolver;


    public ViewEdgeCellViewPositionSolver(CellSizeCalculator cellSizeCalculator, boolean viewCellsMatcheNodeView) {
        diagonalSolver = new DiagonalPositionSolver(cellSizeCalculator,viewCellsMatcheNodeView);
        commonSolver = new CommonPositionSolver(cellSizeCalculator,viewCellsMatcheNodeView);
    }

    public Rectangle getRectangleFor(EdgePosition edgePosition) {
        StrategyPositionSolver solver = commonSolver;
        if (EdgePositionHelper.isDiagonal(edgePosition)) {
            solver = diagonalSolver;
        }

        Position start = solver.getStartPosition(edgePosition);
        Position end = solver.getEndPosition(edgePosition);

        return makeEdgeRectangle(start, end);
    }

    public Position transformToViewPosition(Position position) {
        return diagonalSolver.transformPosition(position);
    }

    private Rectangle makeEdgeRectangle(Position start, Position end) {
        int positionX = start.getRow();
        int positionY = start.getColumn();
        int width = end.getRow() - start.getRow();
        int height = end.getColumn() - start.getColumn();

        return new Rectangle(positionX, positionY, width, height);
    }
}
