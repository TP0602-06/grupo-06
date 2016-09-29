package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.*;


/**
 * Responsabilidades:
 * 1. Implementación de la clase AbstractSelectValueListener para la celda de la grilla board editable
 * Patrón:
 * 1. OBSERVER
 */
public class SelectEditableCellListener extends AbstractSelectValueListener {

    public SelectEditableCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        AbstractEditableNumberCell cellView = (AbstractEditableNumberCell) event.getSource();
        super.selectValueController.notifySelectedEditableCellView(cellView);
    }
}
