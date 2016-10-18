package ar.fiuba.tdd.tp.nikoligames.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Responsibilities:
 * 1. Represents an edge betweem two nodes in the board. Iit can be directed or undirected
 * 2. It can be created with the node or by giving two position and the board.
 */
public abstract class AbstractEdge implements EdgeInterface {
    protected AbstractNode node1;
    protected AbstractNode node2;

    public AbstractEdge(AbstractNode node1, AbstractNode node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.create();
    }

    public AbstractEdge(Board board, Position position1, Position position2) {
        node1 = board.getNode(position1);
        node2 = board.getNode(position2);
        this.create();

    }

    protected abstract void create();
}
