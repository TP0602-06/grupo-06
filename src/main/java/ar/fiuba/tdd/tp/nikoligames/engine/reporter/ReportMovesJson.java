package ar.fiuba.tdd.tp.nikoligames.engine.reporter;

import ar.fiuba.tdd.tp.nikoligames.engine.GameMove.GameMove;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.game.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 *  Esta clase se encarga de armar el reporte de movimientos en Json.
 */
public class ReportMovesJson implements ReportMoves{

    private static final String NUM_KEY = "number";
    private static final String BOARDSTATUS_KEY = "boardStatus";
    private static final String PLAYS_KEY = "plays";
    private static final String BOARD_KEY = "board";
    private static final String STATUS_KEY = "status";
    private static final String VALUES_KEY = "values";
    private static final String VALUE_KEY = "value";
    private static final String POSITION_KEY = "position";
    private boolean valid;

    public String makeReport(Game game, List<GameMove> gameMoves){
        valid = true;
        JSONObject parser = new JSONObject();
        JSONArray plays = makePlaysJson(game,gameMoves);
        JSONObject board = makeBoardReportJson(game.getDrawableBoard());
        parser.put(PLAYS_KEY,plays);
        parser.put(BOARD_KEY,board);
        return parser.toJSONString();
    }

    private JSONArray makePlaysJson(Game game, List<GameMove> gameMoves) {
        JSONArray playsArray = new JSONArray();
        for (int i = 0; i < gameMoves.size(); i++) {
            GameMove move = gameMoves.get(i);
            boolean validMove = move.makeMove(game);
            if ( !validMove ) valid = false;
            JSONObject moveJson = makeMoveJson(move,validMove);
            playsArray.add(moveJson);
        }
        return playsArray;
    }

    private JSONObject makeMoveJson(GameMove move, boolean wasValid){
        JSONObject moveJson = new JSONObject();
        moveJson.put(NUM_KEY,move.getNum());
        moveJson.put(BOARDSTATUS_KEY,wasValid);
        return moveJson;
    }

    private JSONObject makeCellJson(DrawableCell cell, Position position) {
        JSONObject cellJson = new JSONObject();

        JSONArray arrayPosition = new JSONArray();
        arrayPosition.add(position.getX());
        arrayPosition.add(position.getY());
        cellJson.put(POSITION_KEY,arrayPosition);

        cellJson.put(VALUE_KEY,cell.getValue());
        return  cellJson;
    }

    private JSONObject makeBoardReportJson(DrawableBoard board){
        JSONArray cellsJson = new JSONArray();
        for(int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Position position = new Position(i,j);
                JSONObject cell = makeCellJson(board.getADrawableCell(position),position);
                cellsJson.add(cell);
            }
        }

        JSONObject boardStatus = new JSONObject();
        boardStatus.put(STATUS_KEY,valid);
        boardStatus.put(VALUES_KEY,cellsJson);
        return boardStatus;
    }
}
