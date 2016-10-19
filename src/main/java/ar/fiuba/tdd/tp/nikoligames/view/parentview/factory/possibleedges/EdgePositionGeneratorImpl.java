package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.adjacentposition.AdjacentPositionGenerator;
import ar.fiuba.tdd.tp.nikoligames.view.board.EdgePositionHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public abstract class EdgePositionGeneratorImpl implements EdgePositionGenerator {
    private Board board;
    private AdjacentPositionGenerator positionGenerator;

    public EdgePositionGeneratorImpl(Board board, AdjacentPositionGenerator positionGenerator) {
        this.board = board;
        this.positionGenerator = positionGenerator;
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

    protected List<Position> getAdjacentPositionForNode(Position position) {
        List<Position> adjacent = new ArrayList<>();
        Iterator positions = positionGenerator.getAdjacents(position).iterator();
        while (positions.hasNext()) {
            Position posistionToAdd = (Position) positions.next();
            addPosition(adjacent, posistionToAdd);
        }
        return adjacent;
    }

    protected void addPosition(List<Position> positions, Position positionToAdd) {
        if (positionGenerator.isPositionInBoard(positionToAdd,board)) {
            positions.add(positionToAdd);
        }
    }
}
