package ar.fiuba.tdd.tp.nikoligames.engine.model.play;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

/**
 * Created by german on 10/16/2016.
 */
public class CreateDirectedEdgePlay extends AbstractChangeEdgePlay {
    public CreateDirectedEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number, position1, position2);
    }

    @Override
    public void updateGame() {
        super.game.createDirectedEdge(super.position1,position2);
    }
}
