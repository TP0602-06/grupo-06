package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

public class ClassicPosition implements Position {

    private int row;
    private int col;

    public ClassicPosition(int row, int col) {
        this.row = row - 1;
        this.col = col - 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassicPosition that = (ClassicPosition) o;

        if (row != that.row) return false;
        return col == that.col;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
