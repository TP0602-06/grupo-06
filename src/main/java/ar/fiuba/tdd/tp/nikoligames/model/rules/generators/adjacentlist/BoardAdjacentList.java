package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.AdjacentPositionGenerator;

import java.util.*;

/**
 * Created by german on 10/9/2016.
 * Responsabilities:
 *1. Create a Adjacent List.
 *
 *
 */
public abstract class BoardAdjacentList implements AdjacentListGenerator {
    protected final Board board;
    private AdjacentPositionGenerator positionGenerator;

    public BoardAdjacentList(Board board, AdjacentPositionGenerator positionGenerator) {
        this.board = board;
        this.positionGenerator = positionGenerator;
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

    protected void addNode(List<AbstractNode> adjacentList, Position position) {
        if (positionGenerator.isPositionInBoard(position,board)) {
            AbstractNode adjacentNode = board.getNode(position);
            adjacentList.add(adjacentNode);
        }

    }

    protected List<AbstractNode> getAjacentListForNode(Position position) {
        List<AbstractNode> adjacentList = new ArrayList<>();
        List<Position> adjacentPositions = positionGenerator.getAdjacents(position);

        for (Integer i = 0; i < adjacentPositions.size(); i++) {
            addNode(adjacentList,adjacentPositions.get(i));
        }
        return adjacentList;
    }
}