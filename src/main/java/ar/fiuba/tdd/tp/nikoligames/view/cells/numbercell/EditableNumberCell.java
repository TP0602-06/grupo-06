package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.*;

/**
 * Clase que define las celdas con valores editables.
 */
public class EditableNumberCell extends AbstractEditableNumberCell {

    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND ;
    private Color foregroundColor = ColorSet.NUMBER ;
    private static String EMPTY_STRING = "";

    public EditableNumberCell(AbstractSelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        registerMouseHandler(selectValueController);
    }

    public void changeValue(Integer value) {
        this.setText(Integer.toString(value));
    }

    public void clearValue() {
        this.setText(EMPTY_STRING);
    }

    private void registerMouseHandler(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new SelectEditableCellListener(selectValueController));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}
