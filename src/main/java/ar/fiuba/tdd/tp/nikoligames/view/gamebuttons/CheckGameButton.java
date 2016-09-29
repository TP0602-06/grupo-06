package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;

import java.awt.*;
import javax.swing.*;


/**
 * Es la implementacion de un boton que verifica si se cumplen las reglas del juego.
 */
public class CheckGameButton extends JButton implements ButtonCommand {
    private Game game;

    public CheckGameButton(Game game) {
        setText("X");
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
