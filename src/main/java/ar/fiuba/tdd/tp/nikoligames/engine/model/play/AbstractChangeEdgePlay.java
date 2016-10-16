package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

/**
 * Created by german on 10/16/2016.
 */
public abstract class AbstractChangeEdgePlay extends AbstractPlay {

    protected final Position position1;
    protected final Position position2;

    public AbstractChangeEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number);
        this.position1 = position1;
        this.position2 = position2;
    }
}
