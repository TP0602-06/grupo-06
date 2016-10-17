package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.ChangeNodeValuePlay;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMoves;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMovesJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

        ReportMoves reporter = new ReportMovesJson();
        String reportText = reporter.makeReport(game, plays);
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(reportText);
    }

    public boolean allPlaysValid(JSONObject report) throws Exception {
        JSONArray plays = (JSONArray) report.get(ReportMovesJson.PLAYS_KEY);
        boolean allValid = true;
        for (int i = 0; i < plays.size(); i++) {
            JSONObject play = (JSONObject) plays.get(i);
            boolean valid = (boolean) play.get(ReportMovesJson.BOARDSTATUS_KEY);
            allValid = valid && allValid;
        }
        return allValid;
    }

    public boolean getBoardStatus(JSONObject report) {
        JSONObject board = (JSONObject) report.get(ReportMovesJson.BOARD_KEY);
        return (boolean) board.get(ReportMovesJson.STATUS_KEY);
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
