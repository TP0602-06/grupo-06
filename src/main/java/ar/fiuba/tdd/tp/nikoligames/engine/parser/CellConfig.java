package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

/**
 * Created by german on 9/30/2016.
 */
public class CellConfig {
    private Cell cell;
    private int row, col;

    public CellConfig(Cell cell, int row, int col) {
        this.cell = cell;
        this.row = row;
        this.col = col;
    }

    public Cell getCell() {
        return cell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
