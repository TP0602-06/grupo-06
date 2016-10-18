package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.DiagonalAdjacents;

/**
 * Created by tobias on 18/10/16.
 */
public class EdgeDiagonalPossibleGenerator extends EdgePositionGeneratorImpl {

    public EdgeDiagonalPossibleGenerator(Board board) {
        super(board, new DiagonalAdjacents());
    }
}
