package ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueClearerCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ValueToSelectCellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el ingreso de valores al tablero o board
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryInputDigit implements AbstractFactoryInputGrid {

    private static final int firstDigit = 1;
    private static final int lastDigit = 9;

    SelectValueController selectValueController;
    private HashSet<String> validInputs;

    public FactoryInputDigit(SelectValueController controller) {
        this.selectValueController = controller;
    }

    public GridView createInputGridForBoardView(GridView board, HashSet<String> validInputs) throws Exception {
        this.validInputs = validInputs;
        if (validInputs.size() == 0) throw new Exception("No están definidos los inputs del juego");
        GridView inputGridView = new GridOfSquares(1, validInputs.size());
        selectValueController.addInputBoardView(inputGridView);

        addValidInputCells(inputGridView);

        inputGridView.setVisible(false);

        return inputGridView;
    }

    private void addValidInputCells(GridView grid) {
        Iterator<String> iterator = this.validInputs.iterator();
        while (iterator.hasNext()) {
            String validInput = iterator.next();
            CellView cell = new ValueToSelectCellView(validInput, selectValueController);
            grid.addCellView(cell);
        }

        grid.addCellView(new ValueClearerCell(selectValueController));
    }
}
