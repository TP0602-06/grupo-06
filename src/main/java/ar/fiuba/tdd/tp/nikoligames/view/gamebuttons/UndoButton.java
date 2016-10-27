package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.NoPlaysException;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableEdgeOperationPlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;

import javax.swing.JButton;

/**
 * Created by german on 10/27/2016.
 */
public class UndoButton extends JButton implements ButtonCommand {
    private Game game;
    private static final String buttonText = "Undo";

    public UndoButton(Game game) {
        setText(buttonText);
        addMouseListener(new BasicButtonListener());
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            DrawablePlay drawablePlay = game.undoLastPlayMade();
            //if (drawablePlay instanceof DrawableChangeNodeValuePlay) {

            //}
            if (drawablePlay instanceof DrawableEdgeOperationPlay) {
                DrawableEdgeOperationPlay drawableEdgeOperationPlay = (DrawableEdgeOperationPlay) drawablePlay;

                switch (drawableEdgeOperationPlay.getEdgeOperation()) {
                    case CREATE_UNDIRECTED:

                        break;
                    case CREATE_DIRECTED:
                        break;
                    case REMOVE_DIRECTED:
                        break;
                    case REMOVE_UNDIRECTED:
                        break;
                    default:
                        break;
                }
            }
        } catch (NoPlaysException e) {
            e.printStackTrace();
        }
    }
}
