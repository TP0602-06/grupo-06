package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectValueCellListener extends AbstractSelectValueListener {

    protected ValueToSelectCellView getButton(MouseEvent event) {
        return (ValueToSelectCellView) event.getSource();
    }
    public SelectValueCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notofySelectValueController(MouseEvent event) {
        ValueToSelectCellView cellView = this.getButton(event);
        super.selectValueController.notifySelectedValue(cellView.getValue());
    }
}
