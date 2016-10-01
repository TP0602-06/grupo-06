package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */

public class BoardImplementation implements DrawableBoard, Board {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public BoardImplementation(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[this.rows][this.cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private boolean outOfRange(Position coordinates) {
        int row = coordinates.getRow();
        int col = coordinates.getColumn();
        return !((0 <= col) && (col < cols) && (0 <= row) && (row < rows));
    }

    private void checkRange(Position coordinates) {
        if (outOfRange(coordinates)) {
            throw new UnsupportedOperationException();
        }
    }

    public void setCell(Position coordinates, Cell cell) {
        checkRange(coordinates);
        cells[coordinates.getRow()][coordinates.getColumn()] = cell;
    }

    public boolean changeCellValue(Position coordinates, String value) {
        checkRange(coordinates);
        Cell cell = cells[coordinates.getRow()][coordinates.getColumn()];
        if (cell.isEditable()) {
            cell.setValue(value);
            return true;
        }
        return false;
    }

    public Cell getCell(Position coordinates) {
        checkRange(coordinates);
        return cells[coordinates.getRow()][coordinates.getColumn()];
    }

    public DrawableCell getDrawableCell(Position position) {
        return getCell(position);

    }


}



