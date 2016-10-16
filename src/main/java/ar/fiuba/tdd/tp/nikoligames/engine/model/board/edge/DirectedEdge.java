package ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Responsabilidades: Crear una arista NO DIRIGIDA entre 2 nodos y poder borrarla.
 */
public class DirectedEdge implements AbstractEdge {
    private AbstractNode node1;
    private AbstractNode node2;

    public DirectedEdge(Board board, Position position1, Position position2) {
        node1 = board.getNode(position1);
        node2 = board.getNode(position2);
        this.create();
    }

    public DirectedEdge(AbstractNode node1, AbstractNode node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.create();
    }

    private void create() {
        node1.addEdge(node2);
    }

    public void erase() {
        node1.removeEdge(node2);
    }

}
