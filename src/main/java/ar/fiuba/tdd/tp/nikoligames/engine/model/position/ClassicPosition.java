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

}
