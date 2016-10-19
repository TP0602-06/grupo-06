package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.DiagonalAdjacents;

/**
 * Created by german on 10/9/2016.
 */
public class DiagonalAdjacentListGen extends BoardAdjacentList {

    public DiagonalAdjacentListGen(Board board) {
        super(board, new DiagonalAdjacents());
    }

}