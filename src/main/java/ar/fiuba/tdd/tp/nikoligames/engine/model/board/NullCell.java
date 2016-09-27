package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 24/09/2016.
 */
public class NullCell extends AbstractCell {

    public boolean isNullCell() {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isEditable() {
        return true;
    }

}
