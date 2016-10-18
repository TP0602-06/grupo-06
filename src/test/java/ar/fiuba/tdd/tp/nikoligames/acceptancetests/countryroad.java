package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by german on 10/18/2016.
 */
public class countryroad {
    public static final String DATA_JSON = "data/countryroad/tablero1.json";

    @Test
    public void countryroadFirstPlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        game.createUndirectedEdge(new ClassicPosition(1, 1), new ClassicPosition(1, 2));

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void countryRoadPartialSoFarSoGoodGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(1, 1),
                asList(1, 2),
                asList(2, 2),
                asList(2, 3),
                asList(2, 4)
        );
        GameSetup.processContunuosCircuit(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void countryRoadPartialSoFarSoBadGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(1, 1, 1, 2),
                asList(1, 2, 2, 2),
                asList(2, 2, 2, 3),
                asList(2, 3, 2, 4),
                asList(2, 3, 3, 3)
        );
        GameSetup.processCircuit(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void countryRoadCompleteWinGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(1, 1),
                asList(1, 2),
                asList(2, 2),
                asList(2, 3),
                asList(2, 4),
                asList(3, 4),
                asList(4, 4),
                asList(4, 5),
                asList(5, 5),
                asList(5, 6),
                asList(4, 6),
                asList(3, 6),
                asList(3, 5),
                asList(2, 5),
                asList(1, 5),
                asList(1, 6),
                asList(1, 7),
                asList(2, 7),
                asList(3, 7),
                asList(4, 7),
                asList(5, 7),
                asList(6, 7),
                asList(7, 7),
                asList(7, 6),
                asList(6, 6),
                asList(6, 5),
                asList(6, 4),
                asList(5, 4),
                asList(5, 3),
                asList(6, 3),
                asList(7, 3),
                asList(7, 2),
                asList(7, 1),
                asList(6, 1),
                asList(6, 2),
                asList(5, 2),
                asList(4, 2),
                asList(3, 2),
                asList(3, 1),
                asList(2, 1),
                asList(1, 1)
        );
        GameSetup.processContunuosCircuit(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertTrue(game.checkWin());
    }

    @Test
    public void countryRoadNoOneCycleLooseGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(1, 1),
                asList(1, 2),
                asList(2, 2),
                asList(2, 3),
                asList(2, 4),
                asList(3, 4),
                asList(4, 4),
                asList(4, 5),
                asList(5, 5),
                asList(5, 6),
                asList(4, 6),
                asList(3, 6),
                asList(3, 5),
                asList(2, 5),
                asList(1, 5),
                asList(1, 6),
                asList(1, 7),
                asList(2, 7),
                asList(3, 7),
                asList(4, 7),
                asList(5, 7),
                asList(6, 7),
                asList(7, 7),
                asList(7, 6),
                asList(6, 6),
                asList(6, 5),
                asList(6, 4),
                asList(5, 4),
                asList(5, 3),
                asList(6, 3),
                asList(7, 3),
                asList(7, 2),
                asList(7, 1),
                asList(6, 1),
                asList(6, 2),
                asList(5, 2),
                asList(4, 2),
                asList(3, 2),
                asList(3, 1),
                asList(2, 1),
                asList(2, 2)
        );
        GameSetup.processContunuosCircuit(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void countryRoadNoClosedCycleLooseGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(1, 1),
                asList(1, 2),
                asList(2, 2),
                asList(2, 3),
                asList(2, 4),
                asList(3, 4),
                asList(4, 4),
                asList(4, 5),
                asList(5, 5),
                asList(5, 6),
                asList(4, 6),
                asList(3, 6),
                asList(3, 5),
                asList(2, 5),
                asList(1, 5),
                asList(1, 6),
                asList(1, 7),
                asList(2, 7),
                asList(3, 7),
                asList(4, 7),
                asList(5, 7),
                asList(6, 7),
                asList(7, 7),
                asList(7, 6),
                asList(6, 6),
                asList(6, 5),
                asList(6, 4),
                asList(5, 4),
                asList(5, 3),
                asList(6, 3),
                asList(7, 3),
                asList(7, 2),
                asList(7, 1),
                asList(6, 1),
                asList(6, 2),
                asList(5, 2),
                asList(4, 2),
                asList(3, 2),
                asList(3, 1),
                asList(2, 1)
        );
        GameSetup.processContunuosCircuit(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }
}
