package ar.fiuba.tdd.tp.nikoligames.parser.utils;

/**
 * Created by german on 9/30/2016.
 */
public class NodeConfig {
    public static final String DEFAULT_VALUE = "";
    private String value;

    private int row;
    private int col;

    private boolean isEditable = false;

    public NodeConfig(int row, int col) {
        this(DEFAULT_VALUE,row,col);
    }

    public NodeConfig(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

}
