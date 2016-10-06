package ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell;

/**
 * Created by fedebrasburg on 10/6/16.
 */
public abstract class AbstractCell {
    protected String value = "";

    public AbstractCell() {
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract boolean isEmpty();

    public abstract  boolean isEditable();
}
