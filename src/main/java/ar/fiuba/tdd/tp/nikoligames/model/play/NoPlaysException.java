package ar.fiuba.tdd.tp.nikoligames.model.play;

/**
 * Created by german on 10/27/2016.
 */
public class NoPlaysException extends Exception {
    public NoPlaysException() {
        super("no more plays to undo");
    }
}
