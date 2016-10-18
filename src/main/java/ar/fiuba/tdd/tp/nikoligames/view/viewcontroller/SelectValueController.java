package ar.fiuba.tdd.tp.nikoligames.view.viewcontroller;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.Component;

/**
 * Responsabilidades:
 * 1. Controlar la interacción entre la grilla del juego y el panel para ingresar el valor correspondiente al casillero seleccionado
 * Patrón de diseno: OBSERVER (cada botón conoce al observador - SelectValueController - y lo notifica ante un evento.
 */
public interface SelectValueController {

    void addBoardView(GridView boardView);

    void addInputBoardView(GridView inputBoardView);

    void notifySelectedEditableCellView(AbstractEditableNumberCell cellView);

    void notifySelectedComponent(Component component);

    void notifySelectedValue(String value) throws Exception;

    void notifyClearValue() throws Exception;
}
