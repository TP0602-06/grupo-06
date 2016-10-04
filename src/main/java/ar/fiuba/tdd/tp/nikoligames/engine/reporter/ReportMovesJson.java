package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.GameImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.play.Play;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    private boolean valid;

    public String makeReport(Game game, List<Play> gameMoves) throws Exception {
        valid = true;
        JSONObject parser = new JSONObject();
        JSONArray plays = makePlaysJson(game, gameMoves);
        JSONObject board = makeBoardReportJson(game.getDrawableBoard());
        parser.put(PLAYS_KEY, plays);
        parser.put(BOARD_KEY, board);
        return parser.toJSONString();
    }

    private JSONArray makePlaysJson(Game game, List<Play> gameMoves) throws Exception {
        JSONArray playsArray = new JSONArray();
        for (int i = 0; i < gameMoves.size(); i++) {
            Play move = gameMoves.get(i);
            boolean validMove = move.makeMove(game);
            if (!validMove) {
                valid = false;
            }
            JSONObject moveJson = makeMoveJson(move, validMove);
            playsArray.add(moveJson);
        }
        return playsArray;
    }

    private JSONObject makeMoveJson(Play move, boolean wasValid) {
        JSONObject moveJson = new JSONObject();
        moveJson.put(NUM_KEY, move.getNum());
        moveJson.put(BOARDSTATUS_KEY, wasValid);
        return moveJson;
    }

    private JSONObject makeCellJson(DrawableCell cell, ClassicPosition position) {
        JSONObject cellJson = new JSONObject();

        JSONArray arrayPosition = new JSONArray();
        arrayPosition.add(position.getRow());
        arrayPosition.add(position.getColumn());
        cellJson.put(POSITION_KEY, arrayPosition);

        cellJson.put(VALUE_KEY, cell.getValue());
        return cellJson;
    }

    private JSONObject makeBoardReportJson(DrawableBoard board) {
        JSONArray cellsJson = new JSONArray();
        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                ClassicPosition position = new ClassicPosition(i, j);
                JSONObject cell = makeCellJson(board.getDrawableCell(position), position);
                cellsJson.add(cell);
            }
        }

        JSONObject boardStatus = new JSONObject();
        boardStatus.put(STATUS_KEY, valid);
        boardStatus.put(VALUES_KEY, cellsJson);
        return boardStatus;
    }
}
