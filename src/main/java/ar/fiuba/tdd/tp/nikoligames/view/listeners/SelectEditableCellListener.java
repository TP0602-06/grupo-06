package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.AbstractFocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.FocusCellViewHelper.FocusCellViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import java.awt.event.*;

import javax.swing.*;

/**
 * Esta clase se encarga del comportamiento de las celdas editables.
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
