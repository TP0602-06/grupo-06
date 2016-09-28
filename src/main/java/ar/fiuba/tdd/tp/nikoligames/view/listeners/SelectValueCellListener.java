package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.MouseEvent;

/**
 * Esta clase se encarga del comportamiento cuando un valor es seleccionado.
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