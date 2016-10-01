package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.event.MouseEvent;

/**
 * Responsabilidades:
 * 1. Implementación de AbstractSelectValueListener para celda clear del panel para ingresar numeros a cada casillero del juego
 * Patrón:
 * 1. OBSERVER
 */
public class ClearCellListener extends AbstractSelectValueListener {

    public ClearCellListener(SelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) throws Exception {
        super.selectValueController.notifyClearValue();
    }
}
