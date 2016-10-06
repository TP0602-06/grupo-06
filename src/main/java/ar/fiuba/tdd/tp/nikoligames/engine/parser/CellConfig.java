package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.ConcreteNode;

/**
 * Created by german on 9/30/2016.
 */
public class CellConfig {
    private ConcreteNode cell;
    private int row;
    private int col;

    public CellConfig(ConcreteNode cell, int row, int col) {
        this.cell = cell;
        this.row = row;
        this.col = col;
    }

    public ConcreteNode getCell() {
        return cell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
