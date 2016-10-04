package ar.fiuba.tdd.tp.nikoligames.playtest;

import ar.fiuba.tdd.tp.nikoligames.SimpleGameFactoryForTest;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.Play;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import org.junit.Assert;
import org.junit.Test;

public class PlayTest {
    private SimpleGameFactoryForTest gameFactory = new SimpleGameFactoryForTest();

    @Test
    public void makeValidPlay() throws Exception {
        Game newGame = gameFactory.makeGame();
        Play play = new Play(1, SimpleGameFactoryForTest.one,new ClassicPosition(1,1));
        Assert.assertTrue(play.makeMove(newGame));
    }

    @Test
    public void makeInvalidPlay() throws Exception {
        Game newGame = gameFactory.makeGame();
        Play play = new Play(1,SimpleGameFactoryForTest.one,new ClassicPosition(1,1));
        Play invalidPlay = new Play(2,SimpleGameFactoryForTest.one,new ClassicPosition(1,2));
        play.makeMove(newGame);
        Assert.assertFalse(invalidPlay.makeMove(newGame));
    }


}
