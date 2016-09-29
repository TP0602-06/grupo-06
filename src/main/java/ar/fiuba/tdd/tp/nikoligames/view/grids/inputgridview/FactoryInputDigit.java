package ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueClearerCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el ingreso de valores al tablero o board
 * Patrón:
 *  1. Abstract Factory
 */
public class FactoryInputDigit implements AbstractFactoryInputGrid {

    private static final int firstDigit = 1;
    private static final int lastDigit = 9;

    AbstractSelectValueController selectValueController;

    public FactoryInputDigit(AbstractSelectValueController controller) {
        this.selectValueController = controller;
    }

    public GridView createInputGridForBoardView(GridView board) {

        GridView inputGridView = new GridOfSquares(firstDigit, lastDigit);
        selectValueController.addInputBoardView(inputGridView);

        addValidInputCells(inputGridView);

        inputGridView.setVisible(false);

        return inputGridView;
    }

    private void addValidInputCells(GridView grid) {
        for (int j = firstDigit; j <= lastDigit; j++) {
            CellView cell = new ValueToSelectCellView(j, selectValueController);
            grid.addCellView(cell);
        }
        grid.addCellView(new ValueClearerCell(selectValueController));
    }
}
