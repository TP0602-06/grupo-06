package ar.fiuba.tdd.tp.nikoligames.model.board;

/**
 * Created by german on 10/27/2016.
 */
public class EdgeAlreadyExistsExpection extends Exception {
    public EdgeAlreadyExistsExpection() {
        super("you are trying to create an edge that was created previously");
    }
}
