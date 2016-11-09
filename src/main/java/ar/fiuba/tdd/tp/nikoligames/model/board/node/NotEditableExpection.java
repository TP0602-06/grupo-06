package ar.fiuba.tdd.tp.nikoligames.model.board.node;

/**
 * Created by german on 10/27/2016.
 */
public class NotEditableExpection extends Exception {
    public NotEditableExpection() {
        super("you are trying to change a non editable node");
    }
}
