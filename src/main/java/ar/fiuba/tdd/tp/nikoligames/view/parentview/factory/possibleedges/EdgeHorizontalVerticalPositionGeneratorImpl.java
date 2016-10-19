package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.NotDiagonalAdjacents;


/**
 * Created by tobias on 18/10/16.
 */
public class EdgeHorizontalVerticalPositionGeneratorImpl extends EdgePositionGeneratorImpl {

    public EdgeHorizontalVerticalPositionGeneratorImpl(Board board) {
        super(board, new NotDiagonalAdjacents());
    }
}
