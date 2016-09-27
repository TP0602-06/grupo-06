package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Esta clase es el escuchador de borrado.
 */
public class ClearCellListener extends AbstractSelectValueListener {

    public ClearCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        super.selectValueController.notifyClearValue();
    }
}
