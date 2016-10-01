package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.SelectValueCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Estas son celdas que proven el input para las celdas editables.
 */
public class ValueToSelectCellView extends CellView {
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND;
    private Color foregroundColor = ColorSet.NUMBER;
    private int value;

    public ValueToSelectCellView(int value, SelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        this.value = value;
        this.setText(Integer.toString(value));
        registerMouseHandler(selectValueController);
    }

    private void registerMouseHandler(SelectValueController selectValueController) {
        this.addMouseListener(new SelectValueCellListener(selectValueController));
    }

    public String getValue() {
        return Integer.toString(value);
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
