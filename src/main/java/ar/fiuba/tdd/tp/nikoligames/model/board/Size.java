package ar.fiuba.tdd.tp.nikoligames.model.board;

/**
 * Created by german on 10/15/2016.
 */
public class Size {
    private int rows;
    private int cols;

    public Size(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }


    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
