package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by german on 10/18/2016.
 */
public class Inshinohaya {

    public static final String DATA_INSHI_TABLERO1_JSON = "data/inshi/tablero1.json";

    @Test
    public void inshiNoHayaFirstPlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_INSHI_TABLERO1_JSON);

        game.changeNodeValue(new ClassicPosition(1, 1), "3");

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void inshiNoHayaWinGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_INSHI_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "3", "4", "1", "5", "2",
                "2", "1", "3", "4", "5",
                "5", "3", "2", "1", "4",
                "1", "5", "4", "2", "3",
                "4", "2", "5", "3", "1"
        );
        GameSetup.fillGame(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertTrue(game.checkWin());
    }

    @Test
    public void inshiNoHayaLooseGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_INSHI_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "1", "4", "1", "5", "2",
                "2", "1", "3", "4", "5",
                "5", "3", "2", "1", "4",
                "1", "5", "4", "2", "3",
                "4", "2", "5", "3", "1"
        );
        GameSetup.fillGame(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

}
