package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

/**
 * Responsabilidades:
 * 1. Controlar la interacción entre la grilla del juego y el panel para ingresar el valor correspondiente al casillero seleccionado
 * Patrón de diseno: OBSERVER (cada botón conoce al observador - AbstractSelectValueController - y lo notifica ante un evento.
 */
public interface AbstractSelectValueController {

    void addBoardView(GridView boardView);

    void addInputBoardView(GridView inputBoardView);

    void notifySelectedEditableCellView(AbstractEditableNumberCell cellView);

    void notifySelectedComponent(Component component);

    void notifySelectedValue(String value) throws Exception;

    void notifyClearValue() throws Exception;
}
