package ar.fiuba.tdd.tp.nikoligames.games.heya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tobias on 29/09/16.
 */
public class HeyaGameTest {

    @Test
    public void testInvalidMultiplication(){
        Game game = makeHeyaBoardGameWithInvalidNumbers();
        Assert.assertFalse(game.checkRules());
    }

    @Test
    public void testValidMultiplication(){
        Game game = makeHeyaBoardGameWithInvalidNumbers();
        Assert.assertTrue(game.checkRules());
    }

    private Game makeEmptyHeyaGame(){
        return new HeyaGame();
    }

    private Game makeHeyaGameWithValidNumbers(){
        Game game = makeEmptyHeyaGame();
        game.insertValueInCell(new Position(1,1),"3");
        game.insertValueInCell(new Position(1,2),"4");
        game.insertValueInCell(new Position(1,3),"1");
        return game;
    }

    private Game makeHeyaBoardGameWithInvalidNumbers(){
        Game game = makeEmptyHeyaGame();
        game.insertValueInCell(new Position(1,1),"3");
        game.insertValueInCell(new Position(2,1),"4");
        return game;
    }
}
