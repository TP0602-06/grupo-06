package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

/**
 * Created by german on 10/6/2016.
 */
public class DirectedBoard extends BoardImplementation {
    public DirectedBoard(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    void createEdge(Node node1, Node node2) {
        node1.addEdge(node2);
    }

}
