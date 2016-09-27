package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import java.awt.event.*;

import javax.swing.*;

/**
 * Esta clase se encarga del comportamiento de las celdas.
 */
public class SelectEditableCellListener extends AbstractSelectValueListener {

    protected AbstractEditableNumberCell getButton(MouseEvent event) {
        return (AbstractEditableNumberCell) event.getSource();
    }
    public SelectEditableCellListener(AbstractSelectValueController selectValueController) {
        super(selectValueController);
    }

    protected void notofySelectValueController(MouseEvent event) {
        AbstractEditableNumberCell cellView = this.getButton(event);
        super.selectValueController.notifySelectedEditableCellView(cellView);
    }
}
