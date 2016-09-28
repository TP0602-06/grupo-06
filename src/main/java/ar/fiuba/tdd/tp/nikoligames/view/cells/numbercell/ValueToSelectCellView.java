package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectValueCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import javax.swing.*;
import java.awt.*;

/**
 * Estas son celdas que proven el input para las celdas editables.
 */
public class ValueToSelectCellView extends CellView {
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND ;
    private Color foregroundColor = ColorSet.NUMBER ;
    private int value;

    public ValueToSelectCellView(int value, AbstractSelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        this.value = value;
        this.setText(Integer.toString(value));
        registerMouseHandler(selectValueController);
    }

    private void registerMouseHandler(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new SelectValueCellListener(selectValueController));
    }

    public Integer getValue() {
        return value;
    }
    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
