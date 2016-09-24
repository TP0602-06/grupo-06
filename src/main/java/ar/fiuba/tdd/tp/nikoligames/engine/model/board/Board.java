package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.net.PortUnreachableException;
import java.util.ArrayList;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */
public class Board implements BoardInterface {
    private int length;
    private int width;
    private CellInterface cells[][];

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Board(int width, int length) {
        this.length = length;
        this.width = width;
        cells = new CellInterface[width][length];
    }

    private boolean outOfRange(int column, int row) {
        return ((0 < column) && (column < width) && (0 < row) && (row < length));
    }

    private void checkRange(int column, int row) {
        if (outOfRange(column, row)) {
            throw new UnsupportedOperationException();
        }
    }

    public void setCell(int column, int row, CellInterface cell) {
        checkRange(column, row);
        cells[column][row] = cell;
    }

    public CellInterface getCell(Position position) {
        checkRange(position.getX(), position.getY());
        return cells[position.getX()][position.getY()];
    }

    public ArrayList<CellInterface> getArrayOfCells(ArrayList<Position> positions){
        ArrayList<CellInterface> arrayOfCells= new ArrayList<CellInterface>();
        for(Position position: positions) {
            arrayOfCells.add(getCell(position));
        }
        return arrayOfCells;
    }
}



