package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.ArrayList;

/**
 * Da una interfaz para el exterior del modelo evitando que sea modificado por ese medio.
 */
public interface DrawableBoard {
    public DrawableCell getADrawableCell( Position position);

    public int getCols();

    public int getRows();
}
