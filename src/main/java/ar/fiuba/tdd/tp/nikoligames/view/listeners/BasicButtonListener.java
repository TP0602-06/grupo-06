package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.ButtonCommand;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Responsabilidades:
 * 1.Capturar el evento click del mouse en el botón en los botones de configuración, inicio y check del juego
 * Patrón:
 * 1. Command
 */
public class BasicButtonListener extends MouseAdapter {

    public void mouseClicked(MouseEvent event) {
        ButtonCommand button = (ButtonCommand) event.getSource();
        button.execute();
    }
}
