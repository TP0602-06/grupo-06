package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

/**
 * Esta clase representa el movimiento de una jugada.
 */
public class ChangeNodeValuePlay extends AbstractPlay {

    private final Position position;
    private final String value;

    public ChangeNodeValuePlay(Game game, int number, String value, Position position) {
        super(game, number);
        this.position = position;
        this.value = value;
    }

    public void updateGame() {
        super.game.changeNodeValue(position, value);
    }

}