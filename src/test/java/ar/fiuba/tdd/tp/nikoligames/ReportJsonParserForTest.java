package ar.fiuba.tdd.tp.nikoligames;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.BoardImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager.ValidInputManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.Play;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMoves;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMovesJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReportJsonParserForTest {
    private SimpleGameFactoryForTest gameFactory = new SimpleGameFactoryForTest();

    public JSONObject getValidReport() throws Exception {
        List<Play> plays = getValidPlays();
        return getReport(plays);

    }

    public JSONObject getInvalidReport() throws Exception {
        List<Play> plays = getInvalidPlays();
        return getReport(plays);
    }

    private JSONObject getReport(List<Play> plays) throws Exception {
        Game newGame = gameFactory.makeGame();
        ReportMoves reporter = new ReportMovesJson();
        String reportText = reporter.makeReport(newGame, plays);
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

    private List<Play> getValidPlays() {
        Play validSecondPlay = new Play(2, SimpleGameFactoryForTest.two, new ClassicPosition(1, 2));
        return getPlays(validSecondPlay);
    }

    private List<Play> getInvalidPlays() {
        Play invalidSecondPlay = new Play(2, SimpleGameFactoryForTest.one, new ClassicPosition(1, 2));
        return getPlays(invalidSecondPlay);
    }

    private List<Play> getPlays(Play lastPlay) {
        List<Play> plays = new ArrayList<>();
        Play firstPlay = new Play(1, SimpleGameFactoryForTest.one, new ClassicPosition(1, 1));

        plays.add(firstPlay);
        plays.add(lastPlay);
        return plays;
    }
}
