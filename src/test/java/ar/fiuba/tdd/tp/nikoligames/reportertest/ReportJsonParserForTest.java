package ar.fiuba.tdd.tp.nikoligames.reportertest;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.model.play.ChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.reporter.AbstractPlaysReporter;
import ar.fiuba.tdd.tp.nikoligames.reporter.ReportPlaysJson;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReportJsonParserForTest {
    Game game;
    private SimpleGameFactoryForTest gameFactory = new SimpleGameFactoryForTest();

    public ReportJsonParserForTest() throws Exception {
        game = gameFactory.makeGame();
    }

    public JSONObject getValidReport() throws Exception {
        List<AbstractPlay> plays = getValidPlays();
        return getReport(plays);

    }

    public JSONObject getInvalidReport() throws Exception {
        List<AbstractPlay> plays = getInvalidPlays();
        return getReport(plays);
    }

    private JSONObject getReport(List<AbstractPlay> plays) throws Exception {
        AbstractPlaysReporter reporter = new ReportPlaysJson();
        return reporter.makeJsonReport(game, plays);
    }

    public boolean allPlaysValid(JSONObject report) throws Exception {
        JSONArray plays = (JSONArray) report.get(ReportPlaysJson.PLAYS_KEY);
        boolean allValid = true;
        for (int i = 0; i < plays.size(); i++) {
            JSONObject play = (JSONObject) plays.get(i);
            boolean valid = (boolean) play.get(PlayParser.BOARDSTATUS_KEY);
            allValid = valid && allValid;
        }
        return allValid;
    }

    public boolean getBoardStatus(JSONObject report) {
        JSONObject board = (JSONObject) report.get(ReportPlaysJson.BOARD_KEY);
        return (boolean) board.get(ReportPlaysJson.STATUS_KEY);
    }

    private List<AbstractPlay> getValidPlays() {
        ChangeNodeValuePlay validSecondPlay = new ChangeNodeValuePlay(game,2, SimpleGameFactoryForTest.two, new ClassicPosition(1, 2));
        return getPlays(validSecondPlay);
    }

    private List<AbstractPlay> getInvalidPlays() {
        ChangeNodeValuePlay invalidSecondPlay = new ChangeNodeValuePlay(game,2, SimpleGameFactoryForTest.one, new ClassicPosition(1, 2));
        return getPlays(invalidSecondPlay);
    }

    private List<AbstractPlay> getPlays(AbstractPlay lastPlay) {
        List<AbstractPlay> plays = new ArrayList<>();
        AbstractPlay firstPlay = new ChangeNodeValuePlay(game,1, SimpleGameFactoryForTest.one, new ClassicPosition(1, 1));

        plays.add(firstPlay);
        plays.add(lastPlay);
        return plays;
    }
}
