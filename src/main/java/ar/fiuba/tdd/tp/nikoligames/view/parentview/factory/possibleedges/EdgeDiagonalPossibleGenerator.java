package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class EdgeDiagonalPossibleGenerator extends EdgePositionGeneratorImpl {

    public EdgeDiagonalPossibleGenerator(Board board) {
        super(board);
    }

    @Override
    protected List<Position> getAdjacentPositionForNode(Position position) {
        List<Position> positions = new ArrayList<>();
        Integer row = position.getRow();
        Integer column = position.getColumn();

        addPosition(positions,row + 1, column - 1);
        addPosition(positions, row - 1, column - 1);
        addPosition(positions,row + 1, column + 1);
        addPosition(positions,row - 1, column + 1);

        return  positions;
    }
}
