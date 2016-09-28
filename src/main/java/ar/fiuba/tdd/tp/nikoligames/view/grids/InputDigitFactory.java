package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueClearerCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import java.awt.*;

/**
 * Esta clase se encarga de la construccion de una grid input.
 */
public class InputDigitFactory implements InputGridFactory {
    private static final int firstDigit = 1;
    private static final int lastDigit = 9;

    public GridView createInputGrid() {
        GridView board = new GridOfSquares(firstDigit, lastDigit);
        board.setVisible(false);
        return board;
    }

    public void addInputCells(GridView grid, AbstractSelectValueController controller) {

        for (int j = firstDigit; j <= lastDigit; j++) {
            CellView cell = new ValueToSelectCellView(j, controller);
            grid.addCellView(cell);
        }

        grid.addCellView(new ValueClearerCell(controller));

    }
}
