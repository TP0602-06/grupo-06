package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.DrawCellFromModelHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.rulehelper.CellViewMakeUpHelper;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.AbstractFactoryInputGrid;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.FactoryInputDigit;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueControllerImp;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el board
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryBoardViewImplementation implements FactoryBoard {
    private SelectValueController selectValueController;
    private DrawableBoard modelBoard;

    public FactoryBoardViewImplementation(Game game) {
        selectValueController = new SelectValueControllerImp(game);
        modelBoard = game.getDrawableBoard();
    }

    @Override
    public GridView createGridView(boolean nodeMatchesCell) {
        Integer oneLesss = nodeMatchesCell ? 0: 1;
        Integer rows = modelBoard.getRows() - oneLesss;
        Integer cols = modelBoard.getCols() - oneLesss;

        GridView boardGridView = new GridOfSquares(rows, cols);

        selectValueController.addBoardView(boardGridView);

        fillGridWithCellsFromModel(boardGridView, modelBoard, rows, cols);
        boardGridView.setVisible(true);

        return boardGridView;
    }

    public void fillGridWithCellsFromModel(GridView grid, DrawableBoard modelBoard, Integer rows, Integer cols) {
        DrawCellFromModelHelper helper = new DrawCellFromModelHelper(selectValueController);
        CellViewMakeUpHelper makeup = new CellViewMakeUpHelper();

        //TODO agarrar celdas que se van a ver como tales nada mas
        //TODO beatuyfy deberia estar fuera o dentro?? tiene q sacar info del json
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++ ) {
                Position modelPosition = new ClassicPosition(i + 1,j + 1);
                Position drawPosition = new ClassicPosition(i,j);
                DrawableNode modelCell = modelBoard.getDrawableNode(modelPosition);
                CellView cellView = helper.drawCellFromModel(modelCell);
                cellView.setCoordinates(drawPosition.getRow(), drawPosition.getColumn());
                makeup.beautyfy(cellView, modelCell);
                grid.addCellView(cellView);
            }
        }

    }

    @Override
    public void addInputs(GameView view, HashSet<String> inputs) {
        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(selectValueController);
        try {
            GridView viewInputs = inputFactory.createInputGridForBoardView(inputs);
            view.add(viewInputs);
        } catch (Exception exception) {
        }

    }
}
