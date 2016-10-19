package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import ar.fiuba.tdd.tp.nikoligames.view.board.BoardView;
import ar.fiuba.tdd.tp.nikoligames.view.board.ViewEdgeFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.BasicGroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.gamebuttons.factory.GroupButtonFactory;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.FactoryBoardViewImplementation;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges.EdgePositionGenerator;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges.factory.EdgePositionGeneratorFactory;

import java.awt.Component;
import java.awt.Dimension;
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
    public GameView createDefaultGameView(Game game, GameConfig gameConfig) throws Exception {
        //TODO take dimension and boolean from json
        Dimension boardDimension = new Dimension(300, 300);
        boolean cellViewMatchesNodeView = false;

        GameView view = new GameView(DEFAULT_TITLE, DEFAULT_VIEW_WIDTH, DEFAULT_VIEW_HEIGHT);

        FactoryBoard factoryGridView = new FactoryBoardViewImplementation(game);
        ViewEdgeFactory viewEdgeFactory = new ViewEdgeFactory(game);

        GridView gridView = factoryGridView.createGridView(cellViewMatchesNodeView);
        List<EdgePosition> edges = getPosibleEdges(game,gameConfig.getRules());

        BoardView boardView = new BoardView(boardDimension,gridView, viewEdgeFactory, cellViewMatchesNodeView);
        boardView.addEdges(edges);

        Component restartAndCheckButtons = createButtons(game);

        view.add(restartAndCheckButtons);
        view.add(boardView);

        factoryGridView.addInputs(view, gameConfig.getValidInputs());

        return view;
    }

    private Component createButtons(Game game) {
        GroupButtonFactory groupButtonFactory = new BasicGroupButtonFactory();
        return groupButtonFactory.makeGroupButton(game);
    }

    private List<EdgePosition> getPosibleEdges(Game game, List<RuleConfig> rules) {
        Board board = (Board) game.getDrawableBoard();
        EdgePositionGeneratorFactory factory = new EdgePositionGeneratorFactory();
        EdgePositionGenerator generator = factory.getPositionGenerator(board, rules);

        return generator.getPossibleEdgePositions();
    }
}
