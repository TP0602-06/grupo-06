package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

/**
 * Clase que define las celdas con valores editables.
 */
public class EditableNumberCell extends AbstractEditableNumberCell {

    private static String EMPTY_STRING = "";

    public EditableNumberCell(AbstractSelectValueController selectValueController) {
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
        registerMouseHandler(selectValueController);
    }

    public void changeValue(Integer value){
        this.setText(Integer.toString(value));
    }
    public void clearValue() {
        this.setText(EMPTY_STRING);
    }

    private void registerMouseHandler(AbstractSelectValueController selectValueController){
        this.addMouseListener(new SelectEditableCellListener(selectValueController));
    }
}
