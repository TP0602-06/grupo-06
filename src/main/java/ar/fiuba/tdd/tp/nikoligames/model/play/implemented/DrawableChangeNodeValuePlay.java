package ar.fiuba.tdd.tp.nikoligames.model.play.implemented;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Responsabilidades: dar a conocer a la vista cómo dejar el tablero.
 */
public class DrawableChangeNodeValuePlay extends DrawablePlay {

    private final String value;
    private final Position position;

    public DrawableChangeNodeValuePlay(Position position, String value) {
        this.value = value;
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public Position getPosition() {
        return position;
    }
}
