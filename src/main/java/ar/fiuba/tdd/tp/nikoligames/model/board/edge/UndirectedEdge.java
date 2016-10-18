package ar.fiuba.tdd.tp.nikoligames.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Responsibilities:
 * 1. Represents a undirected edge between two nodes in the board.
 * 2. It can  create or erase the edge.
 */
public class UndirectedEdge extends AbstractEdge {


    public UndirectedEdge(Board board, Position position1, Position position2) {
        super(board, position1, position2);
    }

    public UndirectedEdge(AbstractNode node1, AbstractNode node2) {
        super(node1, node2);
    }

    protected void create() {
        node1.addEdge(node2);
        node2.addEdge(node1);
    }

    public void erase() {
        node1.removeEdge(node2);
        node2.removeEdge(node1);
    }

}
