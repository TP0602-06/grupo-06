package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.SelectValueCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.Color;

/**
 * Estas son celdas que proven el input para las celdas editables.
 */
public class ValueToSelectCellView extends CellView {
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND;
    private Color foregroundColor = ColorSet.NUMBER;
    private String value;

    public ValueToSelectCellView(String value, SelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        this.value = value;
        this.setText(value);
        registerMouseHandler(selectValueController);
    }

    private void registerMouseHandler(SelectValueController selectValueController) {
        this.addMouseListener(new SelectValueCellListener(selectValueController));
    }

    public String getValue() {
        return value;
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
