package ar.fiuba.tdd.tp.nikoligames.acceptancetests.setup;

import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.parser.ArgsParser;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import ar.fiuba.tdd.tp.nikoligames.reporter.AbstractPlaysReporter;
import ar.fiuba.tdd.tp.nikoligames.reporter.ReportPlaysJson;

import java.util.List;

/**
 * Created by fedebrasburg on 10/20/16.
 */
public class CheckGame {
    public static boolean checkGame(String boardPath, String playsPath) throws Exception {
        GameSetup gs = new GameSetup();
        Game game = gs.setup(boardPath);
        return checkWin(playsPath, game);
    }

    private static boolean checkWin(String playsPath, Game game) throws Exception {

        List<AbstractPlay> plays = PlayParser.parse(playsPath, game);

        for (AbstractPlay play : plays) {
            play.process();
        }

        return game.checkWin();
    }
}
