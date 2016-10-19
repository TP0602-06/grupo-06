package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.NotDiagonalAdjacents;

/**
 * Created by german on 10/8/2016.
 * Responsabilites:
 * 1.Creates an adjacentList with all the horizontal and vertical adjacents of each node on the board.
 */
public class HorizontalVerticalAdjacentListGen extends BoardAdjacentList {

    public HorizontalVerticalAdjacentListGen(Board board) {
        super(board, new NotDiagonalAdjacents());
    }

}