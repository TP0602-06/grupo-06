package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;

/**
 * Created by german on 10/16/2016.
 * Responsabilities:
 * 1. Play that removes a undirected edge on between two position in the board.
 *
 */
public class RemoveUndirectedEdgePlay extends AbstractChangeEdgePlay {
    @SuppressWarnings("CPD-START")

    public RemoveUndirectedEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number, position1, position2);
    }

    @SuppressWarnings("CPD-END")

    @Override
    public void updateGame() {
        super.game.removeUndirectedEdge(super.position1, position2);
    }
}
