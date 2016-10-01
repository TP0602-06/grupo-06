package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.DrawCellFromModelHelper;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el board
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryBoardViewFromModel implements AbstractFactoryBoard {
    AbstractSelectValueController selectValueController;

    public FactoryBoardViewFromModel(AbstractSelectValueController controller) {
        selectValueController = controller;
    }

    @Override
    public GridView createBoardView(DrawableBoard modelBoard) {
        GridView boardGridView = new GridOfSquares(modelBoard.getRows(), modelBoard.getCols());

        selectValueController.addBoardView(boardGridView);

        fillGridWithCellsFromModel(boardGridView, modelBoard);

        boardGridView.setVisible(true);

        return boardGridView;
    }

    public void fillGridWithCellsFromModel(GridView grid, DrawableBoard modelBoard) {
        DrawCellFromModelHelper helper = new DrawCellFromModelHelper(selectValueController);

        int columns = modelBoard.getCols();
        int rows = modelBoard.getRows();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ClassicPosition position = new ClassicPosition(i, j);
                DrawableCell modelCell = modelBoard.getDrawableCell(position);
                CellView cellView = helper.drawCellFromModel(modelCell);
                cellView.setCoordinates(i, j);
                grid.addCellView(cellView);
            }
        }

    }
}
