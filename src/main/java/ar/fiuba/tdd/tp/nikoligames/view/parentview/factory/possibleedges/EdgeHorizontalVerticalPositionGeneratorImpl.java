package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.HorizontalVerticalAdjacentListGen;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class EdgeHorizontalVerticalPositionGeneratorImpl extends EdgePositionGeneratorImpl {
    private AdjacentListGenerator listGenerator;

    public EdgeHorizontalVerticalPositionGeneratorImpl(Board board) {
        super(board);
    }

    @Override
    protected List<Position> getAdjacentPositionForNode(Position position) {
        List<Position> positions = new ArrayList<>();
        Integer row = position.getRow();
        Integer column = position.getColumn();

        addPosition(positions,row - 1, column);
        addPosition(positions,row + 1, column);
        addPosition(positions,row, column - 1);
        addPosition(positions,row, column + 1);
        return  positions;
    }
}
