package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;

import java.awt.Color;
import javax.swing.JButton;


/**
 * Responsabilidades:
 * 1. Es la implementacion de una abstracción para la encapsulación del comando para verificar si se cumplen las reglas del juego
 * Patrón:
 * 1. Commmand
 */
public class CheckGameButton extends JButton implements ButtonCommand {
    private Game game;

    public CheckGameButton(Game game) {
        setText("Check");
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
