package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 27/09/2016.
 */
public class NonEditableCell extends AbstractCell {

    public NonEditableCell(String value) {
        super(value);
    }

    public boolean isNullCell() {
        return false;
    }


    public boolean isEditable() {
        return false;
    }

}
