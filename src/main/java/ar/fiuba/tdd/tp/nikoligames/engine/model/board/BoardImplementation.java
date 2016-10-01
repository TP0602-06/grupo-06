package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.ClassicCoordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.Coordinates;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private boolean outOfRange(Coordinates coordinates) {
        return !((0 <= coordinates.getColumn() ) && (coordinates.getColumn() < cols) && (0 <= coordinates.getRow()) && (coordinates.getRow() < rows));
    }

    private void checkRange(Coordinates coordinates) {
        if (outOfRange(coordinates)) {
            throw new UnsupportedOperationException();
        }
    }

    public void setCell(Coordinates coordinates, Cell cell) {
        checkRange(coordinates);
        cells[coordinates.getRow()][coordinates.getColumn()] = cell;
    }

    public boolean changeCellValue(Coordinates coordinates, String value) {
        checkRange(coordinates);
        Cell cell = cells[coordinates.getRow()][coordinates.getColumn()];
        if (cell.isEditable()) {
            cell.setValue(value);
            return true;
        }
        return false;
    }

    public Cell getCell(Coordinates coordinates) {
        checkRange(coordinates);
        return cells[coordinates.getRow()][coordinates.getColumn()];
    }

    public DrawableCell getDrawableCell(Coordinates position) {
        return getCell(position);

    }


}



