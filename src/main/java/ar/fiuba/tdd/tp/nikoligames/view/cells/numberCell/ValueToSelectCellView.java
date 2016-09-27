package ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectEditableCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.SelectValueCellListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import javax.swing.*;

/**
 * Estas son celdas que proven el input para las celdas editables.
 */
public class ValueToSelectCellView extends JButton {

    private int value;

    public ValueToSelectCellView(int value, AbstractSelectValueController selectValueController){
        setBackground(ColorSet.NORMAL_BACKGROUND);
        setForeground(ColorSet.NUMBER);
        this.value = value;
        this.setText(Integer.toString(value));
        registerMouseHandler(selectValueController);
    }

    private void registerMouseHandler(AbstractSelectValueController selectValueController) {
        this.addMouseListener(new SelectValueCellListener(selectValueController));
    }

    public Integer getValue(){
        return value;
    }

}
