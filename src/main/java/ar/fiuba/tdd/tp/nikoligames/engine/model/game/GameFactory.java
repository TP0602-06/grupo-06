package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.NotValidRuleException;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RulesFactory;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/1/2016.
 */
public class GameFactory {
    private BoardFactory boardFactory = new BoardFactory();

    public Game createGame(GameConfig gameConfig) throws Exception {

        Board board = makeBoard(gameConfig);
        List<Rule> rules = makeRules(gameConfig, board);

        Game game = new GameImplementation(board, rules);
        return game;
    }

    private List<Rule> makeRules(GameConfig gameConfig, Board board) throws NotValidRuleException {
        RulesFactory rulesFactory = new RulesFactory(board);
        List<Rule> rules = new ArrayList<Rule>();

        Rule validInpusRule = rulesFactory.createValidValueRule(gameConfig.getValidInputs());
        rules.add(validInpusRule);//La pongo primera esta regla para que sea la primera que rompa

        List<Rule> otherRules = rulesFactory.createRules(gameConfig.getRules());

        rules.addAll(otherRules);
        return rules;
    }

    private Board makeBoard(GameConfig gameConfig) throws Exception {
        SizeConfig sizeConfig = gameConfig.getSizeConfig();
        return boardFactory.createBoard(sizeConfig, gameConfig.getInitialCells());
    }
}
