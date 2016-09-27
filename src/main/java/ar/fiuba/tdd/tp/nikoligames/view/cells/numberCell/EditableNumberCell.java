package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.focusHelpers.focusGridViewHelper.AbstractFocusGridViewHelper;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectCellListener;

import javax.swing.*;

/**
 * Clase que define las celdas con posicion, son celdas con numeros, por eso heredan.
 */
public class EditableNumberCell extends JButton implements AbstractEditableNumberCell {

    private static String EMPTY_STRING = "";

    public EditableNumberCell(AbstractFocusGridViewHelper focusGridViewHelper) {
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
        registerMouseHandler(focusGridViewHelper);
    }

    public void changeValue(Integer value){
        this.setText(Integer.toString(value));
    }
    public void clearValue() {
        this.setText(EMPTY_STRING);
    }

    private void registerMouseHandler(AbstractFocusGridViewHelper focusGridViewHelper){
        this.addMouseListener(new SelectCellListener(focusGridViewHelper));
    }
}
