package ar.fiuba.tdd.tp.nikoligames.model.board.position;

/**
 * Responsabilites:
 * 1. It models a position with row, column from a board.It can be confortable to model other kind of positions.
 *
 */
public abstract class Position {

    protected int row;
    protected int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || getClass() != otherObj.getClass()) {
            return false;
        }

        Position that = (Position) otherObj;

        return (row == that.row) && (col == that.col);

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    public int getColumn() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
