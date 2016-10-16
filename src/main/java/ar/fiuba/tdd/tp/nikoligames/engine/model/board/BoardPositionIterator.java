package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

import java.util.Iterator;

/**
 * Este es el iterador para reccorer obtener las posiciones del board.
 */
public class BoardPositionIterator implements Iterator {
    private Integer actualRow;
    private Integer actualColumn;
    private Board board;

    public BoardPositionIterator(Board board) {
        actualRow = 1;
        actualColumn = 1;
        this.board = board;
    }

    @Override
    public boolean hasNext() {
        return  (actualRow <= board.getRows());
    }

    @Override
    public Object next() {
        Position actualPosition = new ClassicPosition(actualRow,actualColumn);
        updateNext();
        return actualPosition;
    }

    private void updateNext() {
        actualColumn ++;
        if (actualColumn > board.getCols()) {
            actualRow ++;
            actualColumn = 1;
        }
    }
}
