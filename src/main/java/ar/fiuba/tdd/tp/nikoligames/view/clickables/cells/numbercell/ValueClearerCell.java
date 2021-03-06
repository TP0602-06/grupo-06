package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.ClearCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.Color;


/**
 * Esta celda se encarga de notificar la accion de borrar.
 */
public class ValueClearerCell extends CellView {
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND;
    private Color foregroundColor = ColorSet.NUMBER;
    private static final String content = "X";

    public ValueClearerCell(SelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setText(content);
        registerMouseListener(selectValueController);
    }

    protected void registerMouseListener(SelectValueController selectValueController) {
        this.addMouseListener(new ClearCellListener(selectValueController));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
