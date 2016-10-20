package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.Color;

/**
 * Clase que define las celdas con valores editables.
 */
public class EditableViewCell extends AbstractEditableNumberCell {

    private static String EMPTY_STRING = "";
    private Color foregroundColor = ColorSet.NUMBER;

    public EditableViewCell(SelectValueController selectValueController) {
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

}
