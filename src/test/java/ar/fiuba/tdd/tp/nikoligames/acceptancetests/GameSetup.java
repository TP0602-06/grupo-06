package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;

/**
 * Created by Andres on 18/10/2016.
 */
public class GameSetup {
    public Game setup(String boardFilePath) throws Exception {
        GameFactory gameFactory = new GameFactory();
        AbstractParser gameConfigParser = new ConcreteParser(boardFilePath);

        GameConfig gameConfig = gameConfigParser.parse();
        Game game = gameFactory.createGame(gameConfig);
        return game;
    }
}
