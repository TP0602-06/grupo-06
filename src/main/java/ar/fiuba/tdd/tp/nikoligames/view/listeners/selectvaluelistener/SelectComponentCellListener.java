package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.*;
import javax.swing.*;



/**
 * Responsabilidades:
 * 1. Implementación de la clase AbstractSelectValueListener para la celda de la grilla board no editable
 * Patrón:
 * 1. OBSERVER
 */
public class SelectComponentCellListener extends AbstractSelectValueListener {

    public SelectComponentCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        JButton cellView = (JButton) event.getSource();
        super.selectValueController.notifySelectedComponent(cellView);
    }
}
