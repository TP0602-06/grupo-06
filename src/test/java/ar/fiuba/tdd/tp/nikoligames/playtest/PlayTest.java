package ar.fiuba.tdd.tp.nikoligames.playtest;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.ChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.reportertest.SimpleGameFactoryForTest;
import org.junit.Assert;
import org.junit.Test;

public class PlayTest {
    private SimpleGameFactoryForTest gameFactory = new SimpleGameFactoryForTest();

    @Test
    public void makeValidPlay() throws Exception {
        Game game = gameFactory.makeGame();
        AbstractPlay play = new ChangeNodeValuePlay(game, 1, SimpleGameFactoryForTest.one, new ClassicPosition(1, 1));
        Assert.assertTrue(play.process());
    }

    @Test
    public void makeInvalidPlay() throws Exception {
        Game newGame = gameFactory.makeGame();
        ChangeNodeValuePlay play = new ChangeNodeValuePlay(newGame, 1, SimpleGameFactoryForTest.one, new ClassicPosition(1, 1));
        ChangeNodeValuePlay invalidPlay = new ChangeNodeValuePlay(newGame, 1, SimpleGameFactoryForTest.one, new ClassicPosition(1, 2));
        Assert.assertTrue(play.process());
        Assert.assertFalse(invalidPlay.process());
    }

}
