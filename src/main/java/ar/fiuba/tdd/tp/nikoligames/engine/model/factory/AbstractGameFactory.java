package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.AbstractGameConfigParser;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Responsabilidades:
 * 1.Desliga al cliente de conocer como se crea  un juego y lo resuelve.
 * Patrón: Abstract Factory
 */
public abstract class AbstractGameFactory {

    protected Board createBoard(Reader fileReader) throws FileNotFoundException {
        AbstractGameConfigParser boardGameConfigParser = new BoardGameConfigParser();
        GameConfig gameConfig = boardGameConfigParser.parse(fileReader);
        BoardFactory boardFactory = BoardFactory.getInstance();
        Board board = boardFactory.createBoard(gameConfig.getSize(), gameConfig.getBoard());
        return board;
    }

    public Game crateGame(Reader fileReader) throws FileNotFoundException {
        Board board = this.createBoard(fileReader);
        ArrayList<Rule> rules = this.getRules(board);
        RuleManager ruleManager = new RuleManager(rules);
        Game game = new Game(board, ruleManager);
        return game;
    }

    protected abstract ArrayList<Rule> getRules(Board board);

}
