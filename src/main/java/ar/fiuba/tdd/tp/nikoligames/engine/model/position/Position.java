package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

/**
 * Da al modelo una forma de representar una posicion sin tener que repetir siempre (x,y).
 * Actualmente no tiene comportamiento, pero aca iria cualquier calculo entre posiciones.
 * Nos es comodo para abstraernos de una (x,y) concreta.
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

        MatrixPosition that = (MatrixPosition) otherObj;

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
