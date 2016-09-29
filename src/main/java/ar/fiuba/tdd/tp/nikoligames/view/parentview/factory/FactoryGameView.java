package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.*;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.AbstractFactoryBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoardViewFromModel;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.AbstractFactoryInputGrid;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.FactoryInputDigit;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Se encarga de crear la base de la vista.
 */
public class FactoryGameView implements AbstractFactoryGameView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_VIEW_WIDTH = 800;
    private static int DEFAULT_VIEW_HEIGHT = 700;

    private static int DEFAULT_GAME_ROWS = 9;
    private static int DEFAULT_GAME_COLS = 9;

    @Override
    public GameView createDefaultGameView(Game game) {
        GameView view = new GameView(DEFAULT_TITLE, DEFAULT_VIEW_WIDTH, DEFAULT_VIEW_HEIGHT);

        AbstractSelectValueController selectValueController = new SelectValueController(game);

        AbstractFactoryBoard gridBoardFactory = new FactoryBoardViewFromModel(selectValueController);
        GridView boardView = gridBoardFactory.createBoardView(game.getDrawableBoard());

        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(selectValueController);
        GridView inputs = inputFactory.createInputGridForBoardView(boardView);

        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();
        Component restartAndCheckButtons = groupButtonFactory.makeGroupButton(game);

        view.add(restartAndCheckButtons);
        view.add(boardView);
        view.add(inputs);

        return view;
    }
}
