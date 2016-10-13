package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.AbstractEdge;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.UndirectedEdge;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

/**
 * Created by german on 10/12/2016.
 */
public class UndirectedBoard extends BoardImplementation {
    public UndirectedBoard(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    AbstractEdge getEdge(Position position1, Position position2) {
        return new UndirectedEdge(this, position1, position2);
    }
}
