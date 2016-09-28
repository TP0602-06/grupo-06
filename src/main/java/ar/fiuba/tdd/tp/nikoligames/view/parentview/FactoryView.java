package ar.fiuba.tdd.tp.nikoligames.view.parentview;

import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.*;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

import java.awt.*;

/**
 * Se encarga de crear la base de la vista.
 */
public class FactoryView implements AbstractFactoryView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_VIEW_WIDTH = 600;
    private static int DEFAULT_VIEW_HEIGHT = 800;

    private static int DEFAULT_GAME_ROWS = 9;
    private static int DEFAULT_GAME_COLS = 9;

    @Override
    public View createDefaultGameView() {
        View view = new View(DEFAULT_TITLE, DEFAULT_VIEW_WIDTH, DEFAULT_VIEW_HEIGHT);

        AbstractSelectValueController selectValueController = new SelectValueController();

        AbstractFactoryBoard gridBoardFactory = new FactorySampleBoardView(selectValueController);
        GridView board = gridBoardFactory.createBoardView(DEFAULT_GAME_ROWS, DEFAULT_GAME_COLS);

        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(selectValueController);
        GridView inputs = inputFactory.createInputGridForBoardView(board);

        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();
        Component restartAndCheckButtons = groupButtonFactory.makeGroupButton();

        view.add(restartAndCheckButtons);
        view.add(board);
        view.add(inputs);

        return view;
    }
}
