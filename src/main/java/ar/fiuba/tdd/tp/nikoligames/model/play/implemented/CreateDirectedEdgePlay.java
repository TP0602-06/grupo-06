package ar.fiuba.tdd.tp.nikoligames.model.play.implemented;

import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractChangeEdgePlay;

/**
 * Created by german on 10/16/2016.
 * Responsabilities:
 * 1. Play that creates a directed edge on between two position in the board.
 */
public class CreateDirectedEdgePlay extends AbstractChangeEdgePlay {
    @SuppressWarnings("CPD-START")

    public CreateDirectedEdgePlay(Game game, int number, Position position1, Position position2) {
        super(game, number, position1, position2);
    }

    @Override
    public void undo() {
        try {
            this.game.getBoard().removeDirectedEdge(position1, position2);
        } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
            edgeNotExistsExpection.printStackTrace();
        }
    }

    @Override
    public DrawablePlay getDrawableUndoPlay() {
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        return new DrawableEdgeOperationPlay(edgePosition, DrawableEdgeOperationPlay.EdgeOperation.REMOVE_DIRECTED);
    }

    @SuppressWarnings("CPD-END")

    @Override
    public void updateGame() throws EdgeAlreadyExistsExpection {
        super.game.getBoard().createDirectedEdge(super.position1, position2);
    }
}
