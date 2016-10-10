package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.*;

/**
 * Created by german on 10/9/2016.
 */
public abstract class BoardAdjacentList implements AdjacentListGenerator {
    protected final Board board;

    public BoardAdjacentList(Board board) {
        this.board = board;
    }

    @Override
    public Map<AbstractNode, List<AbstractNode>> getAdjacentList() {
        Map<AbstractNode, List<AbstractNode>> adjacentList = new HashMap<AbstractNode, List<AbstractNode>>();
        Iterator<Position> boardPositionIterator = board.getPositionIterator();
        while (boardPositionIterator.hasNext()) {
            Position position = boardPositionIterator.next();
            List<AbstractNode> nodeAdjacentList = getAdjacentListForNode(position);
            AbstractNode node = board.getNode(position);
            adjacentList.put(node, nodeAdjacentList);
        }
        return adjacentList;
    }

    public void addNode(List<AbstractNode> adjacentList, int row, int col) {
        ClassicPosition positionAdjacentBottomRight = new ClassicPosition(row, col);
        AbstractNode adjacentNode = board.getNode(positionAdjacentBottomRight);
        adjacentList.add(adjacentNode);
    }

    protected List<AbstractNode> getAdjacentListForNode(Position position) {
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
            addNode(adjacentList, row + 1, column + 1);
        }
    }

    private void addTopRightToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row - 1) > 0) && ((column + 1)) > 0) {
            addNode(adjacentList, row - 1, column + 1);
        }
    }

    private void addBottomLeftToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row + 1) > 0) && ((column - 1)) > 0) {
            addNode(adjacentList, row + 1, column - 1);
        }
    }

    private void addTopLeftToNode(List<AbstractNode> adjacentList, int row, int column) {
        if (((row - 1) > 0) && ((column - 1)) > 0) {
            addNode(adjacentList, row - 1, column - 1);
        }
    }
}
