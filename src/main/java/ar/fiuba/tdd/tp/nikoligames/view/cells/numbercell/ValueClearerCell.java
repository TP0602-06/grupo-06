package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.ClearCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import javax.swing.*;


/**
 * Esta celda se encarga de notificar la accion de borrar.
 */
public class ValueClearerCell extends CellView {
    public ValueClearerCell(AbstractSelectValueController selectValueController) {
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
        setText("Clear");
        registerMouseListener(selectValueController);
    }

    protected void registerMouseListener(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new ClearCellListener(selectValueController));
    }

}
