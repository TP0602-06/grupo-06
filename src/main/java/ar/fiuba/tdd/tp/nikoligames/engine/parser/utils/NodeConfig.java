package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;

/**
 * Created by german on 9/30/2016.
 */
public class NodeConfig {
    private String value;

    private int row;
    private int col;

    private boolean isEditable = false;
    private boolean isReadonly = true;

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

    public boolean isReadonly() {
        return isReadonly;
    }

    public void setReadonly(boolean readonly) {
        isReadonly = readonly;
    }
}
