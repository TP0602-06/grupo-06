package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.MouseEvent;


/**
 * Responsabilidades:
 * 1. Implementación de AbstractSelectValueListener para la celda del panel que permite ingresar valores a grilla board
 * Patrón:
 * 1. OBSERVER
 */
public class SelectValueCellListener extends AbstractSelectValueListener {

    public SelectValueCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) {
        ValueToSelectCellView cellView = (ValueToSelectCellView) event.getSource();
        super.selectValueController.notifySelectedValue(cellView.getValue());
    }
}
