package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.CheckGameButton;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.RestartGameButton;

import java.awt.*;
import javax.swing.*;

/**
 * Esta clase crea un set de botones para utilizar en el juego.
 */
public class BasicGroupButtonFactory implements GroupButtonFactory {

    public Component makeGroupButton(Game game) {
        JPanel panel = new JPanel();
        JButton checkGame = new CheckGameButton(game);
        JButton restartGame = new RestartGameButton(game);
        panel.add(checkGame);
        panel.add(restartGame);
        panel.setVisible(true);
        return panel;
    }
}
