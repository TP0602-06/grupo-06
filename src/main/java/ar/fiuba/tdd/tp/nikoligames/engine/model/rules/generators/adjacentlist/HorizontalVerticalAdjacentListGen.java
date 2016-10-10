package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public abstract class HorizontalVerticalAdjacentListGen extends BoardAdjacentList {

    public HorizontalVerticalAdjacentListGen(Board board) {
        super(board);
    }

}