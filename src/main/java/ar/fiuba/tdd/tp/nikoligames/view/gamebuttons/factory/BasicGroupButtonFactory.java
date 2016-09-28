package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory;

import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.CheckGameButton;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.RestartGameButton;

import java.awt.*;
import javax.swing.*;

/**
 * Esta clase crea un set de botones para utilizar en el juego.
 */
public class BasicGroupButtonFactory implements GroupButtonFactory {

    public Component makeGroupButton() {
        JPanel panel = new JPanel();
        JButton checkGame = new CheckGameButton();
        JButton restartGame = new RestartGameButton();
        panel.add(checkGame);
        panel.add(restartGame);
        panel.setVisible(true);
        return panel;
    }
}
