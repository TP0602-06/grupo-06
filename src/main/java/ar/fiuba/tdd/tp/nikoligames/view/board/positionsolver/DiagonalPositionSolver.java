package ar.fiuba.tdd.tp.nikoligames.view.board.positionsolver;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

/**
 * Created by tobias on 17/10/16.
 */
public class DiagonalPositionSolver extends StrategyPositionSolver {

    public DiagonalPositionSolver(CellSizeCalculator cellSizeCalculator, boolean viewCellsMatchNodeView) {
        super(cellSizeCalculator, viewCellsMatchNodeView);
    }

    @Override
    public Position getStartPosition(EdgePosition position) {
        Position start = EdgePositionHelper.mostTopLeftPosition(position);
        return transformPosition(start);
    }

    @Override
    public Position getEndPosition(EdgePosition position) {
        Position end = EdgePositionHelper.mostBottomRightPosition(position);
        return transformPosition(end);
    }
}
