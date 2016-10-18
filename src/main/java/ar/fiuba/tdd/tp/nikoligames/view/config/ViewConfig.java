package ar.fiuba.tdd.tp.nikoligames.view.config;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewConfig {
    boolean isCellBoard;

    public ViewConfig(boolean isCellBoard) {
        this.isCellBoard = isCellBoard;
    }

    boolean isCellBoard() {
        return isCellBoard;
    }

    ;

    boolean isNodeBoard() {
        return !isCellBoard;
    }
}
