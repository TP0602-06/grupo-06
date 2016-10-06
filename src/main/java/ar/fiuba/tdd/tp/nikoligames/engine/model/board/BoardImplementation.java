package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 */

public class BoardImplementation implements DrawableBoard, Board {
    private int rows;
    private int cols;
    private ConcreteNode[][] cells;

    public BoardImplementation(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new ConcreteNode[this.rows][this.cols];
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

    public void setCell(Position coordinates, ConcreteNode cell) {
        checkRange(coordinates);
        cells[coordinates.getRow()][coordinates.getColumn()] = cell;
    }

    public boolean changeCellValue(Position coordinates, String value) {
        checkRange(coordinates);
        ConcreteNode cell = cells[coordinates.getRow()][coordinates.getColumn()];
        if (cell.isEditable()) {
            cell.setValue(value);
            return true;
        }
        return false;
    }

    public ConcreteNode getCell(Position coordinates) {
        checkRange(coordinates);
        return cells[coordinates.getRow()][coordinates.getColumn()];
    }

    public DrawableNode getDrawableCell(Position position) {
        return getCell(position);

    }


}



