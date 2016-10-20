package ar.fiuba.tdd.tp.nikoligames.model.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.Iterator;

/**
* Resposabilities
 * 1. It is the iterator for positions in the board.
 * 2. It starts for the first row and goes by column, until the next row.
 *
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
