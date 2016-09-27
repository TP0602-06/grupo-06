package ar.fiuba.tdd.tp.nikoligames.view.listeners;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.AbstractEditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.event.*;

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
