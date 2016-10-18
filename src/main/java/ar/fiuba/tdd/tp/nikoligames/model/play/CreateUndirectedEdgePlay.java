package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;

/**
 * Created by german on 10/16/2016.
 */
public class CreateUndirectedEdgePlay extends AbstractChangeEdgePlay {

    @SuppressWarnings("CPD-START")

    public CreateUndirectedEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number, position1, position2);
    }

    @SuppressWarnings("CPD-END")

    @Override
    public void updateGame() {
        super.game.createUndirectedEdge(super.position1, position2);
    }
}
