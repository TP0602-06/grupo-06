package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfigParser;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.impl.BoardGameConfigParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *  Desliga al cliente de conocer como se crea  un juego y lo resuelve.
 */
public abstract class GameFactory {


    // Recibe un fileReader con la configuacion del juego y lo devuelve en forma de tamblero
    protected Board createBoard(FileReader fileReader) throws FileNotFoundException {
        GameConfigParser boardGameConfigParser = new BoardGameConfigParser();
        GameConfig gameConfig = boardGameConfigParser.parse(fileReader);
        BoardFactory boardFactory = BoardFactory.getInstance();
        Board board = boardFactory.createBoard(gameConfig.getSize(), gameConfig.getBoard());
        return board;
    }

    public Game crateGame(FileReader fileReader) throws FileNotFoundException {
        Board board = this.createBoard(fileReader);
        ArrayList<Rule> rules = this.getRules(board);
        RuleManager ruleManager = new RuleManager(rules);
        Game game = new Game(board, ruleManager);
        return game;
    }

    protected abstract ArrayList<Rule> getRules(Board board);

}
