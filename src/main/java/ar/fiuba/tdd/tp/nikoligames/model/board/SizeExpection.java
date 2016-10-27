package ar.fiuba.tdd.tp.nikoligames.model.board;

/**
 * Created by german on 10/27/2016.
 */
public class SizeExpection extends Exception {
    public SizeExpection() {
        super("not a valid size");
    }
}
