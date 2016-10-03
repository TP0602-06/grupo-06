package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.SelectComponentCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.Color;

/**
 * Estas celdas son la vista de celdas que contienen numeros predeterminados.
 * Una vez creadas no puede cambiarse su valor.
 */
public class NotEditableViewCell extends CellView {

    public NotEditableViewCell(String clue, SelectValueController selectValueController) {
        setForeground(ColorSet.CLUE);
        this.setText(clue);
        registerMouseListener(selectValueController);
    }

    private void registerMouseListener(SelectValueController selectValueController) {
        this.addMouseListener(new SelectComponentCellListener(selectValueController));
    }

}


