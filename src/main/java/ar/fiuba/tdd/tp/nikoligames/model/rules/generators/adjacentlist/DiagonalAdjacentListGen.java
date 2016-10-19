package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/9/2016.
 * Responsabilites:
 * 1.Creates an adjacentList with all the diagonals of each node on the board.
 */
public class DiagonalAdjacentListGen extends BoardAdjacentList {

    public DiagonalAdjacentListGen(Board board) {
        super(board);
    }

    @Override
    protected List<AbstractNode> getAjacentListForNode(Position position) {
        List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();
        int row = position.getRow();
        int column = position.getColumn();

        super.addNode(adjacentList, row + 1, column - 1);
        super.addNode(adjacentList, row - 1, column - 1);
        super.addNode(adjacentList, row + 1, column + 1);
        super.addNode(adjacentList, row - 1, column + 1);

        return adjacentList;
    }
}