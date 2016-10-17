package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
import ar.fiuba.tdd.tp.nikoligames.view.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoardViewImplementation;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.AbstractFactoryInputGrid;
import ar.fiuba.tdd.tp.nikoligames.view.grids.inputgridview.FactoryInputDigit;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectEdgeController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueController;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.SelectValueControllerImp;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Responsabilidades:
 * 1. Implementar la abstracción de Factory para crear el componente GameView
 * Patrón:
 * 1. Abstract Factory
 */
public class FactoryGameViewImplementation implements FactoryGameView {
    private static String DEFAULT_TITLE = "Nikolio games";
    private static int DEFAULT_VIEW_WIDTH = 800;
    private static int DEFAULT_VIEW_HEIGHT = 700;

    @Override
    public GameView createDefaultGameView(Game game, HashSet<String> validInputs) throws Exception {
        //TODO take information from a json
        //TODO create edges
        //TODO take dimension from json
        GameView view = new GameView(DEFAULT_TITLE, DEFAULT_VIEW_WIDTH, DEFAULT_VIEW_HEIGHT);

        SelectValueController selectValueController = new SelectValueControllerImp(game);
        SelectEdgeController selectEdgeController = new SelectEdgeController(game);

        GridView gridView = createBoardView(game, selectValueController);
        List<DrawableEdge> edges = createEdges(game, selectEdgeController);

        BoardView boardView = new BoardView(new Dimension(300, 300),gridView);
        boardView.addDrawbleEdges(edges);

        Component restartAndCheckButtons = createButtons(game);
        GridView inputs = createInputPanel(selectValueController, gridView, validInputs);

        view.add(restartAndCheckButtons);
        view.add(boardView);
        view.add(inputs);

        return view;
    }

    private Component createButtons(Game game) {
        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();
        return groupButtonFactory.makeGroupButton(game);
    }

    private GridView createInputPanel(SelectValueController controller, GridView boardView, HashSet<String> inputs) throws Exception {
        AbstractFactoryInputGrid inputFactory = new FactoryInputDigit(controller);
        return inputFactory.createInputGridForBoardView(boardView, inputs);
    }

    private GridView createBoardView(Game game, SelectValueController selectValueController) {
        FactoryBoard gridBoardFactory = new FactoryBoardViewImplementation(selectValueController);
        return gridBoardFactory.createBoardView(game.getDrawableBoard());
    }

    private List<DrawableEdge> createEdges(Game game, SelectEdgeController edgeController) {
        //Todo create drawableEdges
        List<DrawableEdge> edges = new ArrayList<>();
        Position first = new ClassicPosition(1,1);
        Position second = new ClassicPosition(1,2);
        Position third = new ClassicPosition(2,1);
        EdgePosition testEdge = new EdgePosition(first,second);
        EdgePosition testEdge2 = new EdgePosition(third,first);
        edges.add(new DrawableEdge(testEdge,edgeController));
        edges.add(new DrawableEdge(testEdge2,edgeController));
        return edges;
    }
}
