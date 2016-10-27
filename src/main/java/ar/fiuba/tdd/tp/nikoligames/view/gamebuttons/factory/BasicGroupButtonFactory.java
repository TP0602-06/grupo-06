package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.CheckGameButton;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.UndoButton;

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

    public Component makeGroupButton(Game game, BoardView boardView) {
        JPanel panel = new JPanel();
        JButton checkGame = new CheckGameButton(game);
        JButton undo = new UndoButton(game, boardView);
        panel.add(checkGame);
        panel.add(undo);
        panel.setVisible(true);
        return panel;
    }
}
