package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.AbstractPlay;
import ar.fiuba.tdd.tp.nikoligames.parser.PlayParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.List;

/**
 * Esta clase se encarga de armar el reporte de movimientos en Json.
 */
public class ReportMovesJson implements ReportMoves {

    public static final String NUM_KEY = "number";
    public static final String BOARDSTATUS_KEY = "boardStatus";
    public static final String PLAYS_KEY = "plays";
    public static final String BOARD_KEY = "board";
    public static final String STATUS_KEY = "status";
    public static final String VALUES_KEY = "values";
    public static final String VALUE_KEY = "value";
    public static final String POSITION_KEY = "position";

    public String makeReport(Game game, List<AbstractPlay> gameMoves) throws Exception {
        JSONObject parser = new JSONObject();
        JSONArray plays = makePlaysJson(gameMoves);
        JSONObject board = makeBoardReportJson(game.getDrawableBoard(),game.checkWin());
        parser.put(PLAYS_KEY, plays);
        parser.put(BOARD_KEY, board);
        return parser.toJSONString();
    }

    private JSONArray makePlaysJson(List<AbstractPlay> gameMoves) throws Exception {
        JSONArray playsArray = new JSONArray();
        for (int i = 0; i < gameMoves.size(); i++) {
            AbstractPlay move = gameMoves.get(i);
            //move.process();
            JSONObject playJson = PlayParser.toJson(move);
            playsArray.add(playJson);
        }
        return playsArray;
    }

    private JSONObject makeCellJson(DrawableNode cell, Position position) {
        JSONObject cellJson = new JSONObject();

        JSONArray arrayPosition = new JSONArray();
        arrayPosition.add(position.getRow());
        arrayPosition.add(position.getColumn());
        cellJson.put(POSITION_KEY, arrayPosition);

        cellJson.put(VALUE_KEY, cell.getValue());
        //TODO agregar edgeList
        return cellJson;
    }

    private JSONObject makeBoardReportJson(DrawableBoard board, boolean boardStatus) {
        JSONArray cellsJson = new JSONArray();
        Iterator boardIterator = board.getPositionIterator();
        while (boardIterator.hasNext()) {
            Position position = (Position) boardIterator.next();
            JSONObject cell = makeCellJson(board.getDrawableNode(position), position);
            cellsJson.add(cell);

        }
        JSONObject boardJson = new JSONObject();
        boardJson.put(STATUS_KEY, boardStatus);
        boardJson.put(VALUES_KEY, cellsJson);
        return boardJson;
    }
}
