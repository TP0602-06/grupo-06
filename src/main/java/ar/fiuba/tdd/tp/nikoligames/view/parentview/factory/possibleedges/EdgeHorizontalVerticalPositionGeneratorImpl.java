package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.NotDiagonalAdjacents;


/**
 * Created by tobias on 18/10/16.
 */
public class EdgeHorizontalVerticalPositionGeneratorImpl extends EdgePositionGeneratorImpl {
    private AdjacentListGenerator listGenerator;

    public EdgeHorizontalVerticalPositionGeneratorImpl(Board board) {
        super(board, new NotDiagonalAdjacents());
    }
}
