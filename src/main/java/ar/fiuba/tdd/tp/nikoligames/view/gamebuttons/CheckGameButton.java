package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;

import java.awt.*;
import javax.swing.*;


/**
 * Created by tobias on 27/09/16.
 */
public class CheckGameButton extends JButton implements ButtonCommand {
    private Game game;

    public CheckGameButton(Game game) {
        setText("End Game and Check");
        addMouseListener(new BasicButtonListener());
        this.game = game;
    }

    public void execute() {

        if (game.checkRules()) {
            setBackground(Color.GREEN);
        } else {
            setBackground(ColorSet.ERROR);
        }

    }
}
