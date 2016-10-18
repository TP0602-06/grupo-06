package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/9/2016.
 */
public abstract class BoardAdjacentList implements AdjacentListGenerator {
    protected final Board board;

    public BoardAdjacentList(Board board) {
        this.board = board;
    }

    public Map<AbstractNode, List<AbstractNode>> getAdjacentList() {
        Map<AbstractNode, List<AbstractNode>> adjacentList = new HashMap<AbstractNode, List<AbstractNode>>();
        Iterator<Position> boardPositionIterator = board.getPositionIterator();
        while (boardPositionIterator.hasNext()) {
            Position position = boardPositionIterator.next();
            List<AbstractNode> nodeAdjacentList = getAjacentListForNode(position);
            AbstractNode node = board.getNode(position);
            adjacentList.put(node, nodeAdjacentList);
        }
        return adjacentList;
    }

    protected void addNode(List<AbstractNode> adjacentList, int row, int col) {
        if ((row > 0) && (col > 0) && (col <= board.getCols()) && (row <= board.getRows())) {
            ClassicPosition positionAdjacentBottomRight = new ClassicPosition(row, col);
            AbstractNode adjacentNode = board.getNode(positionAdjacentBottomRight);
            adjacentList.add(adjacentNode);
        }

    }

    protected abstract List<AbstractNode> getAjacentListForNode(Position position);
}