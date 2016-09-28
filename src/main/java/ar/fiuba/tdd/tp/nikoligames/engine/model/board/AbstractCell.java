package ar.fiuba.tdd.tp.nikoligames.engine.model.board;


import java.util.Objects;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public abstract class AbstractCell implements DrawableCell {
    //TODO: fuerza solo enteros
    protected String value = "";

    public AbstractCell(){}

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
        return (Objects.equals(this.getValue(),""));
    }

}
