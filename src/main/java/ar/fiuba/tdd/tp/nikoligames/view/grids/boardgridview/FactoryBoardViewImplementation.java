package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.DrawCellFromModelHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.rulehelper.CellViewMakeUpHelper;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.util.Iterator;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el board
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryBoardViewImplementation implements FactoryBoard {
    SelectValueController selectValueController;

    public FactoryBoardViewImplementation(SelectValueController controller) {
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
        CellViewMakeUpHelper makeup = new CellViewMakeUpHelper();

        Iterator positionIterator = modelBoard.getPositionIterator();
        while (positionIterator.hasNext()) {
            Position position = (Position) positionIterator.next();
            DrawableNode modelCell = modelBoard.getDrawableNode(position);
            CellView cellView = helper.drawCellFromModel(modelCell);
            cellView.setCoordinates(position.getRow(), position.getColumn());
            makeup.beautyfy(cellView, modelCell);
            grid.addCellView(cellView);
        }

    }
}
