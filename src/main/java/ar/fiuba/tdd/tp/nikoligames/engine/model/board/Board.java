package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */
public class Board {
    public void setCell(int column, int row, Cell cell) {
        throw new UnsupportedOperationException();
    }

    public Cell getCell(int column, int row) {
        throw new UnsupportedOperationException();
    }

    public Iterable<Cell> getColumn(int column) {
        throw new UnsupportedOperationException();
    }

    public Iterable<Cell> getRow(int row) {
        throw new UnsupportedOperationException();
    }

    public Iterable<Cell> getRange(int firstColumn, int lastColumn, int firstRow, int lastRow) {
        throw new UnsupportedOperationException();
    }
}
