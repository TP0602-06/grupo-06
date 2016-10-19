package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.NotDiagonalAdjacents;


/**
 * Esta clase obtiene los edges horizontales y verticales posibles.
 */
public class EdgeHorizontalVerticalPositionGeneratorImpl extends EdgePositionGeneratorImpl {

    public EdgeHorizontalVerticalPositionGeneratorImpl(Board board) {
        super(board, new NotDiagonalAdjacents());
    }
}
