package ar.fiuba.tdd.tp.nikoligames.engine.model;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;

/**
 * Created by german on 10/1/2016.
 */
public class GameFactory {
    private BoardFactory boardFactory = new BoardFactory();

    public Game createGame(GameConfig gameConfig) {
        SizeConfig sizeConfig = gameConfig.getSizeConfig();
        Board board = boardFactory.createBoard(sizeConfig.getRows(), sizeConfig.getCols(), gameConfig.getInitialCells());
        RuleManager ruleManager = new RuleManager(board, gameConfig.getRules());
        ValidInputManager validInputManager = new ValidInputManager(gameConfig.getValidInputs());
        Game game = new GameImplementation(board,ruleManager,validInputManager);
        return game;
    }
}
