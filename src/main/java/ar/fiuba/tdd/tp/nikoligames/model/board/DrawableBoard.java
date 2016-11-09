package ar.fiuba.tdd.tp.nikoligames.model.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Responsabilites:
 * 1. Its the public interface that can be seen by the View.
 * 2. It shows the size of the board.
 * 3. Also gives an iterator for positions, it gos from the first row , iterating by columns then the second row and so on .
 */
public interface DrawableBoard {
    DrawableNode getDrawableNode(Position position);

    Set<EdgePosition> getDrawableEdges();

    Map<Position, DrawableNode> getDrawableNodes();

    int getCols();

    int getRows();

    Iterator getPositionIterator();
}
