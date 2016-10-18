package ar.fiuba.tdd.tp.nikoligames.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Responsabilidades: Crear una arista NO DIRIGIDA entre 2 nodos y poder borrarla.
 */
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
