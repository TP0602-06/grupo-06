package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;

/**
 * Responsabilities:
 *  1.It models the change of a value in a node in the game
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