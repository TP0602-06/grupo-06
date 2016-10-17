package ar.fiuba.tdd.tp.nikoligames.reportertest;

import ar.fiuba.tdd.tp.nikoligames.ReportJsonParserForTest;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportPlaysJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class JsonReporterTest {
    private ReportJsonParserForTest parser = new ReportJsonParserForTest();

    public JsonReporterTest() throws Exception {
    }

    @Test
    public void validMoveRegisteredHasInitialKeys() throws Exception {
        JSONObject report = parser.getValidReport();
        Assert.assertTrue(report.containsKey(ReportPlaysJson.BOARD_KEY));
        Assert.assertTrue(report.containsKey(ReportPlaysJson.PLAYS_KEY));
    }

    @Test
    public void validMoveRegisteredHasBoardStatusTrue() throws Exception {
        JSONObject report = parser.getValidReport();
        Assert.assertTrue(parser.getBoardStatus(report));
    }

    @Test
    public void invalidMoveRegisteredHasBoardStatusFalse() throws Exception {
        JSONObject report = parser.getInvalidReport();
        Assert.assertFalse(parser.getBoardStatus(report));
    }

    @Test
    public void validMoveRegisteredTwoMoves() throws Exception {
        JSONObject report = parser.getValidReport();
        JSONArray plays = (JSONArray) report.get(ReportPlaysJson.PLAYS_KEY);
        int amountOfPlays = 2;
        Assert.assertEquals(plays.size(), amountOfPlays);
    }

    @Test
    public void validMoveRegisteredAllMovesValid() throws Exception {
        JSONObject report = parser.getValidReport();
        boolean allValid = parser.allPlaysValid(report);
        Assert.assertTrue(allValid);
    }

    @Test
    public void invalidMoveRegisteredInvalidMove() throws Exception {
        JSONObject report = parser.getInvalidReport();
        boolean allValid = parser.allPlaysValid(report);
        Assert.assertFalse(allValid);
    }

}
