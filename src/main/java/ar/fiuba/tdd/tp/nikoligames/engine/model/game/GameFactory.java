package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.SizeConfig;

import java.util.ArrayList;

/**
 * Created by german on 10/1/2016.
 */
public class GameFactory {
    private BoardFactory boardFactory = new BoardFactory();
    private RulesFactory rulesFactory = new RulesFactory();

    public Game createGame(GameConfig gameConfig) throws Exception {
        SizeConfig sizeConfig = gameConfig.getSizeConfig();
        Board board = boardFactory.createBoard(sizeConfig.getRows(), sizeConfig.getCols(), gameConfig.getInitialCells());
        ArrayList<Rule> rules = rulesFactory.createRules(board, gameConfig.getRules());
        RuleManager ruleManager = new RuleManager(rules);
        ValidInputManager validInputManager = new ValidInputManager(gameConfig.getValidInputs());
        String gameName = gameConfig.getName();
        Game game = new GameImplementation(board, ruleManager, validInputManager, gameName);
        return game;
    }
}
