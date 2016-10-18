package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.acceptancetests.setup.GameSetup;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by german on 10/18/2016.
 */
public class Sudoku {

    public static final String DATA_KAKURO_TABLERO1_JSON = "data/sudoku/tablero1.json";

    @Test
    public void winGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "2", "4", "1", "3",
                "1", "", "", "",
                "4", "", "", "1",
                "3", "1", "2", ""
        );
        GameSetup.fillGame(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertTrue(game.checkWin());
    }

    @Test
    public void notCompletedGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "2", "4", "1", "3",
                "1", "", "", "",
                "4", "", "", "1",
                "3", "1", "", ""
        );
        GameSetup.fillGame(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void looseGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "2", "4", "1", "3",
                "1", "", "", "",
                "4", "", "", "1",
                "3", "1", "4", ""
        );
        GameSetup.fillGame(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void invalidInputGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "2", "4", "1", "3",
                "1", "", "", "",
                "4", "", "", "1",
                "3", "1", "5", ""
        );
        GameSetup.fillGame(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }
}
