package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;

import java.util.ArrayList;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */

public class ConcreteBoard implements DrawableBoard, Board {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public ConcreteBoard(int rows, int cols) {
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


    private boolean outOfRange(int row, int column) {
        return !((0 <= column) && (column < cols) && (0 <= row) && (row < rows));
    }

    private void checkRange(int row, int column) {
        if (outOfRange(row, column)) {
            throw new UnsupportedOperationException();
        }
    }

    public void setCell(int row, int column, Cell cell) {
        checkRange(row, column);
        cells[row][column] = cell;
    }

    public boolean setCellValue(Position position, String value) {
        checkRange(position.getX(), position.getY());
        Cell cell = cells[position.getX()][position.getY()];
        if (cell.isEditable()) {
            cell.setValue(value);
            return true;
        }
        return false;
    }

    public Cell getCell(Position position) {
        checkRange(position.getX(), position.getY());
        return cells[position.getX()][position.getY()];
    }

    public ArrayList<Cell> getArrayOfCells(ArrayList<Position> positions) {
        ArrayList<Cell> arrayOfCells = new ArrayList<>();
        for (Position position : positions) {
            arrayOfCells.add(getCell(position));
        }
        return arrayOfCells;
    }

    public DrawableCell getDrawableCell(Position position) {
        return getCell(position);

    }


}



