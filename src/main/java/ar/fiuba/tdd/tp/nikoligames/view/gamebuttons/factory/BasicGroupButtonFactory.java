package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.CheckGameButton;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Responsabilidades:
 * 1. Es la implementacion de la factory para crear botones
 * Patrón:
 * 1. Commmand
 * 2. Abstract Factory
 */
public class BasicGroupButtonFactory implements GroupButtonFactory {

    public Component makeGroupButton(Game game) {
        JPanel panel = new JPanel();
        JButton checkGame = new CheckGameButton(game);
        panel.add(checkGame);
        panel.setVisible(true);
        return panel;
    }
}
