package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.ButtonCommand;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase se ocupa de ejecutar el comando del boton.
 */
public class BasicButtonListener extends MouseAdapter {

    public void mouseClicked(MouseEvent event){
        ButtonCommand button = (ButtonCommand) event.getSource();
        button.execute();
    }
}
