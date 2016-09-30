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

public class ConcreteBoard implements DrawableBoard, Board {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public ConcreteBoard(int rows, int cols, List<CellConfig> initialCells) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[this.rows][this.cols];
        Iterator<CellConfig> iterator = initialCells.iterator();
        if(iterator.hasNext()){
            CellConfig cellConfig = iterator.next();
            Coordinates coordinates = new ClassicCoordinates(cellConfig.getRow(),cellConfig.getCol());
            this.setCell(coordinates,cellConfig.getCell());
        }
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

    public boolean setCellValue(Coordinates coordinates, String value) {
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

    public ArrayList<Cell> getArrayOfCells(ArrayList<Coordinates> positions) {
        ArrayList<Cell> arrayOfCells = new ArrayList<>();
        for (Coordinates coordinates : positions) {
            arrayOfCells.add(getCell(coordinates));
        }
        return arrayOfCells;
    }

    public DrawableCell getDrawableCell(Coordinates position) {
        return getCell(position);

    }


}



