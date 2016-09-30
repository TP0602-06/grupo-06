package ar.fiuba.tdd.tp.nikoligames.engine.model;

/**
 * La primera celda es (1,1)
 */
public class ClassicCoordinates implements Coordinates {

    private int row;
    private int col;

    public ClassicCoordinates(int row, int col) {
        this.row = row - 1;
        this.col = col - 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

}
