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
public class GokigenNanameAcceptanceTest {
    public static final String DATA_JSON = "data/gokigen/tablero1.json";

    @Test
    public void firstPlayTest() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        game.createUndirectedEdge(new ClassicPosition(2, 1), new ClassicPosition(1, 2));

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void firstPlayNotAdjacentTest() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        game.createUndirectedEdge(new ClassicPosition(1, 1), new ClassicPosition(1, 2));

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void winGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(2, 1, 1, 2),
                asList(1, 2, 2, 3),
                asList(2, 3, 3, 4),
                asList(2, 3, 3, 2),
                asList(3, 2, 4, 3),
                asList(4, 3, 5, 4),
                asList(4, 3, 5, 2),
                asList(5, 2, 6, 1),
                asList(5, 2, 4, 1),
                asList(6, 2, 5, 3),
                asList(5, 4, 6, 3),
                asList(5, 4, 6, 5),
                asList(3, 1, 2, 2),
                asList(3, 1, 4, 2),

                asList(1, 3, 2, 4),
                asList(2, 4, 1, 5),
                asList(2, 4, 3, 5),
                asList(3, 5, 4, 4),
                asList(4, 4, 3, 3),
                asList(4, 4, 5, 5),
                asList(5, 5, 4, 6),
                asList(5, 5, 6, 6),

                asList(1, 6, 2, 5),
                asList(2, 5, 3, 6),
                asList(3, 6, 4, 5)
        );
        GameSetup.processCircuit(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertTrue(game.checkWin());
    }

    @Test
    public void DiagonalCellEmpty() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList(2, 1, 1, 2),
                asList(1, 2, 2, 3),
                asList(2, 3, 3, 4),
                asList(2, 3, 3, 2),
                asList(3, 2, 4, 3),
                asList(4, 3, 5, 4),
                asList(4, 3, 5, 2),
                asList(5, 2, 6, 1),
                asList(5, 2, 4, 1),
                asList(6, 2, 5, 3),
                asList(5, 4, 6, 3),
                asList(5, 4, 6, 5),
                asList(3, 1, 2, 2),
                //asList(3, 1, 4, 2),

                asList(1, 3, 2, 4),
                asList(2, 4, 1, 5),
                asList(2, 4, 3, 5),
                asList(3, 5, 4, 4),
                asList(4, 4, 3, 3),
                asList(4, 4, 5, 5),
                asList(5, 5, 4, 6),
                asList(5, 5, 6, 6),

                asList(1, 6, 2, 5),
                asList(2, 5, 3, 6),
                asList(3, 6, 4, 5)
        );
        GameSetup.processCircuit(game, values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void looseHasCycleGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(

                asList(3, 2, 2, 1), //cambia y hace ciclo

                asList(2, 1, 1, 2),
                asList(1, 2, 2, 3),
                asList(2, 3, 3, 4),
                asList(2, 3, 3, 2),
                asList(3, 2, 4, 3),
                asList(4, 3, 5, 4),
                asList(4, 3, 5, 2),
                asList(5, 2, 6, 1),
                asList(5, 2, 4, 1),
                asList(6, 2, 5, 3),
                asList(5, 4, 6, 3),
                asList(5, 4, 6, 5),

                asList(3, 1, 4, 2),

                asList(1, 3, 2, 4),
                asList(2, 4, 1, 5),
                asList(2, 4, 3, 5),
                asList(3, 5, 4, 4),
                asList(4, 4, 3, 3),
                asList(4, 4, 5, 5),
                asList(5, 5, 4, 6),
                asList(5, 5, 6, 6),

                asList(1, 6, 2, 5),
                asList(2, 5, 3, 6),
                asList(3, 6, 4, 5)
        );
        GameSetup.processCircuit(game, values);

        Assert.assertFalse(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }
}
