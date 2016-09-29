package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.ClearCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.*;


/**
 * Esta celda se encarga de notificar la accion de borrar.
 */
public class ValueClearerCell extends CellView {
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND;
    private Color foregroundColor = ColorSet.NUMBER;

    public ValueClearerCell(AbstractSelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setText("X");
        registerMouseListener(selectValueController);
    }

    protected void registerMouseListener(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new ClearCellListener(selectValueController));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
