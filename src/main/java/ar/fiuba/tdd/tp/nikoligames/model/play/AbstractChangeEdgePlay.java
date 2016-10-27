package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;

/**
 * Responsibilities:
 * 1. Play of the game, it  models all the plays of the game.
 * 2. It models the plays with changes in the edge.
 */
public abstract class AbstractChangeEdgePlay extends AbstractPlay {

    protected final Position position1;
    protected final Position position2;

    public AbstractChangeEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number);
        this.position1 = position1;
        this.position2 = position2;
    }

    public Position getPosition2() {
        return position2;
    }

    public Position getPosition1() {
        return position1;
    }
}
