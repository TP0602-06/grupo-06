package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.ArrayList;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */

public class Board implements DrawableBoard {
    private int length;
    private int width;
    private AbstractCell[][] cells;

    public Board(int width, int length) {
        this.length = length;
        this.width = width;
        this.cells = new AbstractCell[width][length];
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }


    private boolean outOfRange(int column, int row) {
        return !((0 <= column) && (column < width) && (0 <= row) && (row < length));
    }

    private void checkRange(int column, int row) {
        if (outOfRange(column, row)) {
            throw new UnsupportedOperationException();
        }
    }

    public void setCell(int column, int row, AbstractCell cell) {
        checkRange(column, row);
        cells[column][row] = cell;
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


    public ArrayList<? extends DrawableCell> getArrayOfDrawableCells(ArrayList<Position> positions) {
        return this.getArrayOfCells(positions);
    }
    public ArrayList<? extends DrawableCell> getAllDrawableCells() {
        ArrayList<Position> positions=new ArrayList<Position>();
        for (int i =0 ;i<this.width;i++){
            for(int j=0;j<this.length;j++){
                positions.add(new Position(i,j));
            }
        }
        return this.getArrayOfDrawableCells(positions);
    }
}



