package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.game.GameFactory;
import ar.fiuba.tdd.tp.nikoligames.parser.AbstractParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by german on 10/18/2016.
 */
public class inshinohaya {

    public static final String DATA_INSHI_TABLERO1_JSON = "data/inshi/tablero1.json";

    public Game setup(String boardFilePath) throws Exception {
        GameFactory gameFactory = new GameFactory();
        AbstractParser gameConfigParser = new ConcreteParser(boardFilePath);

        GameConfig gameConfig = gameConfigParser.parse();
        Game game = gameFactory.createGame(gameConfig);
        return game;
    }

    @Test
    public void InshiNoHayaFirstPlay() throws Exception {
        Game game = setup(DATA_INSHI_TABLERO1_JSON);

        game.changeNodeValue(new ClassicPosition(1, 1), "3");

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }
}