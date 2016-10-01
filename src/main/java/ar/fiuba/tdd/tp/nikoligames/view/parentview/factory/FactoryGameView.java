package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.AbstractFactoryBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoardViewFromModel;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.AbstractFactoryInputGrid;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.FactoryInputDigit;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Responsabilidades:
 * 1. Implementar la abstracción de Factory para crear el componente GameView
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryGameView implements AbstractFactoryGameView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_VIEW_WIDTH = 800;
    private static int DEFAULT_VIEW_HEIGHT = 700;

    @Override
    public GameView createDefaultGameView(GameImplementation game) {
        GameView view = new GameView(DEFAULT_TITLE, DEFAULT_VIEW_WIDTH, DEFAULT_VIEW_HEIGHT);

        AbstractSelectValueController selectValueController = new SelectValueController(game);
        GridView boardView = createBoardView(game, selectValueController);
        GridView inputs = createInputPanel(selectValueController, boardView);

        Component restartAndCheckButtons = createButtons(game);

        view.add(restartAndCheckButtons);
        view.add(boardView);
        view.add(inputs);

        return view;
    }

    private Component createButtons(GameImplementation game) {
        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();
        return groupButtonFactory.makeGroupButton(game);
    }

    private GridView createInputPanel(AbstractSelectValueController selectValueController, GridView boardView) {
        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(selectValueController);
        return inputFactory.createInputGridForBoardView(boardView);
    }

    private GridView createBoardView(GameImplementation game, AbstractSelectValueController selectValueController) {
        AbstractFactoryBoard gridBoardFactory = new FactoryBoardViewFromModel(selectValueController);
        return gridBoardFactory.createBoardView(game.getDrawableBoard());
    }
}
