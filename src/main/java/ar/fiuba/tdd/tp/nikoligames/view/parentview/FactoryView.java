package ar.fiuba.tdd.tp.nikoligames.view.parentview;

import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.*;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;

/**
 * Se encarga de crear la base de la vista.
 */
public class FactoryView implements AbstractFactoryView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_WIDTH = 600;
    private static int DEFAULT_HEIGHT = 800;

    @Override
    public View createDefaultWindow() {
        View view = new View(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        AbstractFactoryBoard gridBoardFactory = new FactoryGridView();
        InputGridFactory inputFactory = new InputDigitFactory();

        GridView board = gridBoardFactory.createDefaultBoard(9, 9);
        GridView inputs = inputFactory.createInputGrid();
        AbstractSelectValueController selectValueController = new SelectValueController(board, inputs);
        gridBoardFactory.setCells(board, selectValueController);
        inputFactory.addInputCells(inputs, selectValueController);

        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();

        view.add(groupButtonFactory.makeGroupButton());
        view.add(board);
        view.add(inputs);

        return view;
    }
}
