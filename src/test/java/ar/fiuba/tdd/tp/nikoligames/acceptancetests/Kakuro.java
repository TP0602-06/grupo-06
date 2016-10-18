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
public class Kakuro {
    public static final String DATA_KAKURO_TABLERO1_JSON = "data/kakuro/tablero1.json";

    @Test
    public void kakuroNoHayaFirstPlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        game.changeNodeValue(new ClassicPosition(2, 2), "9");

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void kakuroWinGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "", "", "", "", "", "", "", "",
                "", "9", "7", "", "", "8", "7", "9",
                "", "8", "9", "", "8", "9", "5", "7",
                "", "6", "8", "5", "9", "7", "", "",
                "", "", "6", "1", "", "2", "6", "",
                "", "", "", "4", "6", "1", "3", "2",
                "", "8", "9", "3", "1", "", "1", "4",
                "", "3", "1", "2", "", "", "2", "1"
        );
        GameSetup.fillGame(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertTrue(game.checkWin());
    }

    @Test
    public void kakuroLooseForEmptyGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "", "", "", "", "", "", "", "",
                "", "9", "7", "", "", "8", "7", "9",
                "", "8", "9", "", "8", "9", "5", "7",
                "", "6", "8", "5", "9", "7", "", "",
                "", "", "6", "1", "", "2", "6", "",
                "", "", "", "4", "6", "1", "3", "2",
                "", "8", "9", "3", "1", "", "1", "4",
                "", "3", "1", "2", "", "", "2", ""
        );
        GameSetup.fillGame(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void kakuroLooseForNumbersGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_KAKURO_TABLERO1_JSON);

        List<String> values = Arrays.asList(
                "", "", "", "", "", "", "", "",
                "", "9", "7", "", "", "8", "7", "9",
                "", "8", "9", "", "8", "9", "5", "7",
                "", "6", "8", "5", "9", "7", "", "",
                "", "", "6", "1", "", "2", "6", "",
                "", "", "", "4", "6", "1", "3", "2",
                "", "8", "9", "3", "1", "", "1", "4",
                "", "3", "1", "2", "", "", "2", "100"
        );
        GameSetup.fillGame(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

}
