package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Andres on 18/10/2016.
 */
public class Slitherlink {
    public static final String SLITHERINK_TABLERO1_JSON = "data/slitherlink/tablero1.json";


    @Test
    public void slitherlinkCreation() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        Assert.assertFalse(game.checkWin());
        Assert.assertTrue(game.getBoardStatus());
    }

    @Test
    public void slitherlinkFirstPlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        game.createUndirectedEdge(new ClassicPosition(2, 1), new ClassicPosition(2, 2));
        Assert.assertFalse(game.checkWin());
        Assert.assertTrue(game.getBoardStatus());
    }

    @Test
    public void slitherlinkWrongPlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        game.createUndirectedEdge(new ClassicPosition(1, 5), new ClassicPosition(1, 6));
        Assert.assertFalse(game.checkWin());
        Assert.assertFalse(game.getBoardStatus());
    }

    @Test
    public void slitherinkWholePlay() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        List<List<Integer>> values = asList(
                asList(1, 1, 1, 2),
                asList(1, 2, 1, 3),
                asList(1, 3, 1, 4),
                asList(1, 4, 2, 4),
                asList(2, 4, 3, 4),
                asList(3, 4, 3, 5),
                asList(3, 5, 4, 5),
                asList(4, 5, 4, 6),
                asList(4, 6, 3, 6),
                asList(3, 6, 2, 6),
                asList(2, 6, 2, 7),
                asList(2, 7, 3, 7),
                asList(3, 7, 4, 7),
                asList(4, 7, 5, 7),
                asList(5, 7, 6, 7),
                asList(6, 7, 7, 7),
                asList(7, 7, 7, 6),
                asList(7, 6, 6, 6),
                asList(6, 6, 6, 5),
                asList(6, 5, 7, 5),
                asList(7, 5, 7, 4),
                asList(7, 4, 7, 3),
                asList(7, 3, 7, 2),
                asList(7, 2, 7, 1),
                asList(7, 1, 6, 1),
                asList(6, 1, 6, 2),
                asList(6, 2, 6, 3),
                asList(6, 3, 6, 4),
                asList(6, 4, 5, 4),
                asList(5, 4, 5, 3),
                asList(5, 3, 4, 3),
                asList(4, 3, 3, 3),
                asList(3, 3, 2, 3),
                asList(2, 3, 2, 2),
                asList(2, 2, 3, 2),
                asList(3, 2, 3, 1),
                asList(3, 1, 2, 1),
                asList(2, 1, 1, 1)
        );
        gameSetup.processCircuit(game, values);
        Assert.assertTrue(game.checkWin());
        Assert.assertTrue(game.getBoardStatus());
    }
}
