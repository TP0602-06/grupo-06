package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class HorizontalVerticalAdjacentListGen extends BoardAdjacentList {

    public HorizontalVerticalAdjacentListGen(Board board) {
        super(board);
    }

    public List<AbstractNode> getAjacentListForNode(Position position) {
        List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();
        int row = position.getRow();
        int column = position.getColumn();

        super.addNode(adjacentList, row - 1, column);
        super.addNode(adjacentList, row + 1, column);
        super.addNode(adjacentList, row, column - 1);
        super.addNode(adjacentList, row, column + 1);

        return adjacentList;
    }
}