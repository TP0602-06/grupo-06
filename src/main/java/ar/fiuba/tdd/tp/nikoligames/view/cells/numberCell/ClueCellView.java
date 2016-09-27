package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectComponentCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import javax.swing.*;

/**
 * Estas celdas son la vista de celdas que contienen numeros.
 * Una vez creadas no puede cambiarse su valor
 */
public class ClueCellView extends JButton {

    public ClueCellView(int clue, AbstractSelectValueController selectValueController) {
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.CLUE);
        this.setText(Integer.toString(clue));
        registerMouseListener(selectValueController);
    }

    private void registerMouseListener(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new SelectComponentCellListener(selectValueController));
    }
}


