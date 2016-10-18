package ar.fiuba.tdd.tp.nikoligames.acceptancetests;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.playtest.PlayTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andres on 18/10/2016.
 */
public class Slitherlink {
    public static final String SLITHERINK_TABLERO1_JSON = "data/slitherlink/tablero1.json";



    @Test
    public void SlitherinkCreation() throws Exception {
        GameSetup gameSetup =new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        Assert.assertFalse(game.checkWin());
        Assert.assertTrue(game.getBoardStatus());
    }
    @Test
    public void SlitherinkFirstPlay() throws Exception {
        GameSetup gameSetup =new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        game.createUndirectedEdge(new ClassicPosition(2,1) ,new ClassicPosition(2,2) );
        Assert.assertFalse(game.checkWin());
        Assert.assertTrue(game.getBoardStatus());
    }

    @Test
    public void SlitherinkWrongPlay() throws Exception {
        GameSetup gameSetup =new GameSetup();
        Game game = gameSetup.setup(SLITHERINK_TABLERO1_JSON);
        game.createUndirectedEdge(new ClassicPosition(1,5) ,new ClassicPosition(1,6) );
        Assert.assertFalse(game.checkWin());
        Assert.assertFalse(game.getBoardStatus());
    }
    
}
