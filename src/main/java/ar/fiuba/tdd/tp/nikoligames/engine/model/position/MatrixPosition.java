package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

/**
 * Created by german on 10/7/2016.
 */
public class MatrixPosition implements Position {
    private int row;
    private int col;

    public MatrixPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }
}
