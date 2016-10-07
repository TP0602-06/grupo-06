package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.SizeConfig;

/**
 * Created by german on 10/1/2016.
 */
public class GameFactory {
    private BoardFactory boardFactory = new BoardFactory();
    private RulesFactory rulesFactory = new RulesFactory();

    public Game createGame(GameConfig gameConfig) {
        SizeConfig sizeConfig = gameConfig.getSizeConfig();
        Board board = boardFactory.createBoard(sizeConfig.getRows(), sizeConfig.getCols(), gameConfig.getInitialCells());

        RuleFactory ruleFactory = new RuleFactory(board);
        List<Rule> rules = ruleFactory.createRules(gameConfig.getRules());

        ValidInputManager validInputManager = new ValidInputManager(gameConfig.getValidInputs());
        String gameName = gameConfig.getName();

        Game game = new GameImplementation(board, rules, validInputManager, gameName);
        return game;
    }
}
