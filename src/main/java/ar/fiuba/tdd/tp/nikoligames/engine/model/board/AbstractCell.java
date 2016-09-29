package ar.fiuba.tdd.tp.nikoligames.engine.model.board;


import java.util.Objects;

/**
 * AbstractCell contiene los aspectos generales de cualquier celda de cualquier juego.
 */
public abstract class AbstractCell implements DrawableCell {

    protected String value = "";

    public AbstractCell() {
    }

    public AbstractCell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEqual(EditableCell otherCell) {
        return (Objects.equals(this.getValue(), otherCell.getValue()));
    }

    public boolean isEmpty() {
        return this.getValue().equals("")
                || this.getValue().equals("?")
                || this.getValue().equals("*\\*");
    }

}
