package ar.fiuba.tdd.tp.nikoligames.reportertest;

import ar.fiuba.tdd.tp.nikoligames.ReportJsonParserForTest;
import ar.fiuba.tdd.tp.nikoligames.engine.reporter.ReportMovesJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class JsonReporterTest {
    private ReportJsonParserForTest parser = new ReportJsonParserForTest();

    @Test
    public void validMoveRegisteredHasInitialKeys() throws Exception {
        JSONObject report = parser.getValidReport();
        Assert.assertTrue(report.containsKey(ReportMovesJson.BOARD_KEY));
        Assert.assertTrue(report.containsKey(ReportMovesJson.PLAYS_KEY));
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
        JSONArray plays = (JSONArray) report.get(ReportMovesJson.PLAYS_KEY);
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
