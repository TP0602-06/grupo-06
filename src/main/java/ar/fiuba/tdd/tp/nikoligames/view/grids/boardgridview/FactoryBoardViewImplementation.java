package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;
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

import java.util.List;
import java.util.Set;

/**
 * Responsabilidades:
 * 1. Implementa la abstracción para la encapsulación de la creación de una grilla para el board
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryBoardViewImplementation implements FactoryBoard {
    private SelectValueController selectValueController;
    private DrawableBoard modelBoard;
    private CellViewMakeUpHelper makeUpHelper;

    public FactoryBoardViewImplementation(Game game, List<PaintableHintConfig> cellHintConfigs) {
        selectValueController = new SelectValueControllerImp(game);
        modelBoard = game.getDrawableBoard();
        makeUpHelper = new CellViewMakeUpHelper(cellHintConfigs);
    }

    @Override
    public GridView createGridView(boolean nodeMatchesCell, List<RegionConfig> regionConfigs) throws Exception {
        Integer oneLesss = nodeMatchesCell ? 0 : 1;
        Integer rows = modelBoard.getRows() - oneLesss;
        Integer cols = modelBoard.getCols() - oneLesss;

        GridView boardGridView = new GridOfSquares(rows, cols);

        selectValueController.addGridView(boardGridView);

        fillGridWithCellsFromModel(boardGridView, rows, cols);
        boardGridView.paintRegions(regionConfigs);

        boardGridView.setVisible(true);
        return boardGridView;
    }

    public void fillGridWithCellsFromModel(GridView grid, Integer rows, Integer cols) {
        DrawCellFromModelHelper helper = new DrawCellFromModelHelper(selectValueController);

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                Position position = new ClassicPosition(i, j);
                DrawableNode modelCell = modelBoard.getDrawableNode(position);
                CellView cellView = helper.drawCellFromModel(modelCell);
                cellView.setCoordinates(position.getRow(), position.getColumn());
                makeUpHelper.beautyfy(cellView, modelCell);
                grid.addCellView(cellView);
            }
        }

    }

    @Override
    public void addInputs(GameView view, Set<String> inputs) {
        if (inputs.isEmpty()) {
            return;
        }

        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(selectValueController);
        GridView viewInputs = inputFactory.createInputGridForBoardView(inputs);
        view.add(viewInputs);
    }
}
