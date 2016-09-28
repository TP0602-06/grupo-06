package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;

import javax.swing.*;

/**
 * Created by tobias on 27/09/16.
 */
public class RestartGameButton extends JButton implements ButtonCommand {
    private Game game;

    public RestartGameButton(Game game) {
        setText("Restart");
        this.game = game;
    }

    public void execute() {
        //TODO restart game from 0;
    }
}
