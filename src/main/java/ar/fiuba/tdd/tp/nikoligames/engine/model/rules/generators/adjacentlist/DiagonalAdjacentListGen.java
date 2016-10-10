package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/9/2016.
 */
public class DiagonalAdjacentListGen extends BoardAdjacentList {

    public DiagonalAdjacentListGen(Board board) {
        super(board);
    }

    @Override
    List<AbstractNode> getAjacentListForNode(Position position) {
        List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();
        int row = position.getRow();
        int column = position.getColumn();

        addTopLeftToNode(adjacentList, row, column);
        addBottomLeftToNode(adjacentList, row, column);
        addTopRightToNode(adjacentList, row, column);
        addBottomRightToNode(adjacentList, row, column);
        return adjacentList;
    }

    private void addBottomRightToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row + 1) > 0) && ((column + 1)) > 0) {
            super.addNode(adjacentList, row + 1, column + 1);
        }
    }

    private void addTopRightToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row - 1) > 0) && ((column + 1)) > 0) {
            super.addNode(adjacentList, row - 1, column + 1);
        }
    }

    private void addBottomLeftToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row + 1) > 0) && ((column - 1)) > 0) {
            super.addNode(adjacentList, row + 1, column - 1);
        }
    }

    private void addTopLeftToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row - 1) > 0) && ((column - 1)) > 0) {
            super.addNode(adjacentList, row - 1, column - 1);
        }
    }
}
