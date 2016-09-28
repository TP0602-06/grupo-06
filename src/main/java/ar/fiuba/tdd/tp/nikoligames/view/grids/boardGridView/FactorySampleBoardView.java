package ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView;

import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardGridView.AbstractFactoryBoard;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Created by german on 9/25/2016.
 */
public class FactorySampleBoardView implements AbstractFactoryBoard {
    AbstractSelectValueController selectValueController;


    public FactorySampleBoardView(AbstractSelectValueController controller){
        selectValueController = controller;
    }

    public GridView createBoardView(Integer rows, Integer cols) {
        GridView boardGridView = new GridOfSquares(rows, cols);

        selectValueController.addBoardView(boardGridView);

        fillWithSampleCells(boardGridView);

        boardGridView.setVisible(true);

        return boardGridView;
    }

    private void fillWithSampleCells(GridView board) {
        int rows = board.getRows();
        int cols = board.getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                CellView cell;
                if (j % 3 == 0) {
                    cell = new ClueCellView(j, selectValueController);
                } else {
                    cell = new EditableNumberCell(selectValueController);
                }
                cell.setCoordinates(i, j);
                board.addCellView(cell);
            }
        }
    }
}
