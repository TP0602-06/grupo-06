package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Clase que define las celdas con valores editables.
 */
public class EditableNumberCell extends AbstractEditableNumberCell {

    private static String EMPTY_STRING = "";
    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND;
    private Color foregroundColor = ColorSet.NUMBER;

    public EditableNumberCell(SelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        registerMouseHandler(selectValueController);
    }

    public void changeValue(String value) {
        this.setText(value);
    }

    public void clearValue() {
        this.setText(EMPTY_STRING);
    }

    private void registerMouseHandler(SelectValueController selectValueController) {
        this.addMouseListener(new SelectEditableCellListener(selectValueController));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
