package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.NoPlaysException;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawableEdgeOperationPlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.EditableViewCell;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.ViewEdge;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;

import javax.swing.JButton;

/**
 * Created by german on 10/27/2016.
 */
public class UndoButton extends JButton implements ButtonCommand {
    private Game game;
    private BoardView boardView;

    private static final String buttonText = "Undo";

    public UndoButton(Game game, BoardView boardView) {
        setText(buttonText);
        addMouseListener(new BasicButtonListener());
        this.game = game;
        this.boardView = boardView;
    }

    @Override
    public void execute() {
        try {
            DrawablePlay drawablePlay = game.undoLastPlayMade();
            if (drawablePlay instanceof DrawableChangeNodeValuePlay) {
                DrawableChangeNodeValuePlay change = (DrawableChangeNodeValuePlay) drawablePlay;
                String value = change.getValue();
                Position position = change.getPosition();
                EditableViewCell editableViewCell = boardView.getViewCell(position);
                editableViewCell.setText(value);
            }
            if (drawablePlay instanceof DrawableEdgeOperationPlay) {
                DrawableEdgeOperationPlay edgePlay = (DrawableEdgeOperationPlay) drawablePlay;
                EdgePosition edge = edgePlay.getEdgePosition();
                ViewEdge viewEdge = boardView.getViewEdge(edge);
                viewEdge.undoClick();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
