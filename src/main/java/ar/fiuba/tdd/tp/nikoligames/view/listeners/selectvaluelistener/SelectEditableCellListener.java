package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.event.MouseEvent;


/**
 * Responsabilidades:
 * 1. Implementación de la clase AbstractSelectValueListener para la celda de la grilla board editable
 * Patrón:
 * 1. OBSERVER
 */
public class SelectEditableCellListener extends AbstractSelectValueListener {

    public SelectEditableCellListener(SelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        AbstractEditableNumberCell cellView = (AbstractEditableNumberCell) event.getSource();
        super.selectValueController.notifySelectedEditableCellView(cellView);
    }
}
