package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.NotValidRuleException;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.SizeConfig;

import java.util.List;

/**
 * Created by german on 10/1/2016.
 */
public class GameFactory {
    private BoardFactory boardFactory = new BoardFactory();

    public Game createGame(GameConfig gameConfig) throws NotValidRuleException {
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
