package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.ArrayList;

/**
 * Created by Andres on 26/09/2016.
 */
public interface DrawableBoard {
    public DrawableCell getADrawableCell( Position position);

    public int getCols();

    public int getRows();
}
