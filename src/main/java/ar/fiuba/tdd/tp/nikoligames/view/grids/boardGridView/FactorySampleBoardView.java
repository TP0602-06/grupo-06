package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.KakuroCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.ClueCellView;
import ar.fiuba.tdd.tp.nikoligames.view.cells.numbercell.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Created by german on 9/25/2016.
 */
public class FactorySampleBoardView implements AbstractFactoryBoard {
    AbstractSelectValueController selectValueController;

    public FactorySampleBoardView(AbstractSelectValueController controller) {
        selectValueController = controller;
    }

    public GridView createBoardView(DrawableBoard modelBoard) {
        GridView boardGridView = new GridOfSquares(9, 9);

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
                } else if (j % 4 == 0) {
                    KakuroCellView kakuroCell = new KakuroCellView();
                    kakuroCell.setBottom(9);
                    cell = kakuroCell;

                } else {
                    cell = new EditableNumberCell(selectValueController);
                }
                cell.setCoordinates(i, j);
                board.addCellView(cell);
            }
        }
    }
}
