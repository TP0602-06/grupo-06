package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.games.MappedValues;

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

    public boolean isEmpty() {
        return this.getValue().equals(MappedValues.EMPTY_CELL.getValue())
                || this.getValue().equals(MappedValues.INPUT_EDITABLE.getValue())
                || this.getValue().equals(MappedValues.GREY_CELL.getValue());
    }

}
