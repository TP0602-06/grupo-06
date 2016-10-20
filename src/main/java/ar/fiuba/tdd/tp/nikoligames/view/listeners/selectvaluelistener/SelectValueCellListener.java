package ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.event.MouseEvent;


/**
 * Responsabilidades:
 * 1. Implementación de AbstractSelectValueListener para la celda del panel que permite ingresar valores a grilla board
 * Patrón:
 * 1. OBSERVER
 */
public class SelectValueCellListener extends AbstractSelectValueListener {

    public SelectValueCellListener(SelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notifySelectValueController(MouseEvent event) throws Exception {
        ValueToSelectCellView cellView = (ValueToSelectCellView) event.getSource();
        super.selectValueController.notifySelectedValue(cellView.getValue());
    }
}
