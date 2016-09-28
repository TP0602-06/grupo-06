package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 27/09/2016.
 */
public class NonEditableCell extends AbstractCell {



    public boolean isEditable() {
        return false;
    }

}
