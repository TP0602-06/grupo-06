package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

/**
 * Created by german on 10/6/2016.
 */
public class UndirectedBoard extends BoardImplementation {
    public UndirectedBoard(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    void createEdge(Node node1, Node node2) {
        node1.addEdge(node2);
        node2.addEdge(node1);
    }

}
