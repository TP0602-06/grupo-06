package ar.fiuba.tdd.tp.nikoligames.entrega2test;

import ar.fiuba.tdd.tp.nikoligames.acceptancetests.setup.CheckGame;
import ar.fiuba.tdd.tp.nikoligames.acceptancetests.setup.GameSetup;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.parser.ArgsParser;
import ar.fiuba.tdd.tp.nikoligames.parser.ConcreteParser;
import ar.fiuba.tdd.tp.nikoligames.parser.GameParser;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.reporter.AbstractPlaysReporter;
import ar.fiuba.tdd.tp.nikoligames.reporter.ReportPlaysJson;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.FactoryGameViewImplementation;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by fedebrasburg on 10/20/16.
 */
public class WInTest {

    private String boardCountryroadPath = "data/countryroad/tableroEntrega2.json";
    private String playsCountryroadPath = "data/countryroad/playsEntrega2.json";

    private String boardInshiPath = "data/inshi/tablero1.json";
    private String playsInshiPath = "data/inshi/plays1.json";

    private String boardGokigenPath = "data/gokigen/tablero1.json";
    private String playsGokigenPath = "data/gokigen/playsentrega2.json";

    private String boardSlitherlinkPath = "data/slitherlink/tablero2.json";
    private String playsSlitherlinkPath = "data/slitherlink/plays2.json";

    @Test
    public void countryroadTest() throws Exception {
        Assert.assertTrue(CheckGame.checkGame(boardCountryroadPath, playsCountryroadPath));
    }

    @Test
    public void inshiTest() throws Exception {
        Assert.assertTrue(CheckGame.checkGame(boardInshiPath, playsInshiPath));
    }

    @Test
    public void gokigenTest() throws Exception {
        Assert.assertTrue(CheckGame.checkGame(boardGokigenPath, playsGokigenPath));
    }

    @Test
    public void slitherlinkTest() throws Exception {
        Assert.assertTrue(CheckGame.checkGame(boardSlitherlinkPath, playsSlitherlinkPath));
    }


}
