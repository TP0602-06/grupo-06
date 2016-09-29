package ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.selectvaluelistener.*;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.*;

/**
 * Estas celdas son la vista de celdas que contienen numeros predeterminados.
 * Una vez creadas no puede cambiarse su valor.
 */
public class ClueCellView extends CellView {

    private Color backgroundColor = ColorSet.NORMAL_BACKGROUND ;
    private Color foregroundColor = ColorSet.CLUE ;


    public ClueCellView(int clue, AbstractSelectValueController selectValueController) {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        this.setText(Integer.toString(clue));
        registerMouseListener(selectValueController);
    }

    private void registerMouseListener(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new SelectComponentCellListener(selectValueController));
    }

    @Override
    public void clearFocus() {
        this.setBackground(backgroundColor);
    }
}


