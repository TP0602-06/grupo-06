package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.ArrayList;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */

public class Board implements DrawableBoard {
    private int rows;
    private int cols;
    private AbstractCell[][] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new AbstractCell[this.rows][this.cols];
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

    public void setCell(int row, int column, AbstractCell cell) {
        checkRange(row, column);
        cells[row][column] = cell;
    }

    public boolean setCellValue(Position position, String value) {
        checkRange(position.getX(), position.getY());
        AbstractCell cell = cells[position.getX()][position.getY()];
        if (cell.isEditable()) {
            cell.setValue(value);
            return true;
        }
        return false;
    }

    public AbstractCell getCell(Position position) {
        checkRange(position.getX(), position.getY());
        return cells[position.getX()][position.getY()];
    }

    public ArrayList<AbstractCell> getArrayOfCells(ArrayList<Position> positions) {
        ArrayList<AbstractCell> arrayOfCells = new ArrayList<>();
        for (Position position : positions) {
            arrayOfCells.add(getCell(position));
        }
        return arrayOfCells;
    }

    public DrawableCell getADrawableCell(Position position) {
        return getCell(position);

    }


}



