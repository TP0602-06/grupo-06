package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

import javax.swing.*;

/**
 * Estas celdas son la vista de celdas que contienen numeros.
 */
public class NumberCellView extends CellView {

    public NumberCellView() {
        super();
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
    }

    public void setNumber(Integer number) {
        this.setText(String.valueOf(number));
    }

}


