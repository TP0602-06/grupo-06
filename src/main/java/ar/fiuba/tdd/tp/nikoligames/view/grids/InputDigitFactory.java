package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ValueClearerCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numberCell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewController.AbstractSelectValueController;

import java.awt.*;

/**
 * Esta clase se encarga de la construccion de una grid input.
 */
public class InputDigitFactory implements InputGridFactory {
    private static final int firstDigit = 1;
    private static final int lastDigit = 9;

    public GridView createInputGrid() {
        return new GridOfSquares(firstDigit, lastDigit);
    }

    public void addInputCells(GridView grid, AbstractSelectValueController controller){

        for (int j = firstDigit; j <=lastDigit ; j++) {
            Component component = new ValueToSelectCellView(j,controller);
            grid.addCellView(component);
        }

        grid.addCellView(new ValueClearerCell(controller));

    }
}
