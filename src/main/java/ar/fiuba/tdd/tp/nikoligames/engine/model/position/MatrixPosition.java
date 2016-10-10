package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

/**
 * Created by german on 10/7/2016.
 */
public class MatrixPosition implements Position {
    private int row;
    private int col;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatrixPosition that = (MatrixPosition) o;

        if (row != that.row) return false;
        return col == that.col;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

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
