package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

/**
 * Created by german on 10/6/2016.
 */
public class DirectedBoard extends BoardImplementation {
    public DirectedBoard(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    void createEdge(AbstractNode node1, AbstractNode node2) {
        node1.addEdge(node2);
    }

}
