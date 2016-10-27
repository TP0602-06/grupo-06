package ar.fiuba.tdd.tp.nikoligames.model.play.implemented;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;

/**
 * Responsabilities:
 * 1.It models the change of a value in a node in the game
 */
public class ChangeNodeValuePlay extends AbstractPlay {

    private final Position position;
    private final String value;
    private final String oldValue;

    public ChangeNodeValuePlay(Game game, int number, String value, Position position) {
        super(game, number);
        this.position = position;
        this.value = value;
        oldValue = this.game.getDrawableBoard().getDrawableNode(position).getValue();
    }

    @Override
    public void undo() {
        try {
            super.game.changeNodeValue(position, oldValue);
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        }
    }

    public void updateGame() throws NotEditableExpection {
        super.game.getBoard().changeNodeValue(position, value);
    }

    public DrawablePlay getDrawableUndoPlay() {
        return new DrawableChangeNodeValuePlay(position, value);
    }
}