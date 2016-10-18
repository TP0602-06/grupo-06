package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by tobias on 18/10/16.
 */
public abstract class EdgePositionGeneratorImpl implements EdgePositionGenerator {
    private Board board;

    public EdgePositionGeneratorImpl(Board board) {
        this.board = board;
    }

    public List<EdgePosition> getPossibleEdgePositions() {
        return generateListFromBoard();
    }

    private List<EdgePosition> generateListFromBoard() {
        List<EdgePosition> listEdgePositions = new ArrayList<>();
        Iterator<Position> boardPositionIterator = board.getPositionIterator();
        while (boardPositionIterator.hasNext()) {
            Position position = boardPositionIterator.next();
            List<Position> positionsAdjacent = getAdjacentPositionForNode(position);
            addEdgePositions(listEdgePositions, position, positionsAdjacent);
        }
        return listEdgePositions;
    }

    private void addEdgePositions(List<EdgePosition> listEdgePositions, Position position, List<Position> positionsAdjacent) {
        Iterator positionsIterator = positionsAdjacent.iterator();
        while (positionsIterator.hasNext()) {
            Position adjacenPos = (Position) positionsIterator.next();
            EdgePosition edgeToAdd = new EdgePosition(position, adjacenPos);
            if (notHas(listEdgePositions, edgeToAdd)) {
                listEdgePositions.add(edgeToAdd);
            }
        }

    }

    private boolean notHas(List<EdgePosition> listEdgePositions, EdgePosition edgeToAdd) {
        Iterator edgesIterator = listEdgePositions.iterator();
        while (edgesIterator.hasNext()) {
            EdgePosition existantEdge = (EdgePosition) edgesIterator.next();
            if (EdgePositionHelper.sameEdgePosition(existantEdge, edgeToAdd)) {
                return false;
            }
        }
        return true;
    }

    protected abstract List<Position> getAdjacentPositionForNode(Position position);

    protected void addPosition(List<Position> positions, int row, int col) {
        if ((row > 0) && (col > 0) && (col <= board.getCols()) && (row <= board.getRows())) {
            ClassicPosition positionToAdd = new ClassicPosition(row, col);
            positions.add(positionToAdd);
        }
    }
}
