package ar.fiuba.tdd.tp.nikoligames.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Responsibilities:
 * 1. Represents a directrd edge betweem two nodes in the board. From position 1 to position 2
 * 2. It can  create or erase the edge.
 *
 * */
public class DirectedEdge extends AbstractEdge {


    public DirectedEdge(AbstractNode node1, AbstractNode node2) {
        super(node1, node2);
    }

    public DirectedEdge(Board board, Position position1, Position position2) {
        super(board, position1, position2);
    }


    public void erase() {
        node1.removeEdge(node2);
    }

    protected void create() {
        node1.addEdge(node2);
    }

}
