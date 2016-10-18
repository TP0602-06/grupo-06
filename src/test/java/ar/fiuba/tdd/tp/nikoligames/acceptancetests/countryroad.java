package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
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

        game.createUndirectedEdge(new ClassicPosition(1,1), new ClassicPosition(1,2));

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }

    @Test
    public void countryroadWinGame() throws Exception {
        GameSetup gameSetup = new GameSetup();
        Game game = gameSetup.setup(DATA_JSON);

        List<List<Integer>> values = asList(
                asList( 1, 1, 1 , 2 ),
                asList( 1, 2, 2 , 2 ),
                asList( 2, 2, 2 , 3 ),
                asList( 2, 3, 2 , 4 )
                );
        GameSetup.processCircuit(game,values);

        Assert.assertTrue(game.getBoardStatus());
        Assert.assertFalse(game.checkWin());
    }
}
