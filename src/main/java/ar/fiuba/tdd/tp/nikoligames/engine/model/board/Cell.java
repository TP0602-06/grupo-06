package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import java.util.Objects;

/**
 * Celda. Contiene informacion de celdas relevante para la logica del juego.
 */
public class Cell extends AbstractCell {

    public boolean isNullCell() {
        return false;
    }

    public boolean isEditable() {
        return true;
    }
}
