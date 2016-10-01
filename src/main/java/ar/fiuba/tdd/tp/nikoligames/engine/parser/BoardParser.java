package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class BoardParser {
    public static final String BOARD = "board";
    public static final String BOARD_VALUES = "values";
    public static final String BOARD_POSITION = "position";

    private JSONObject getJsonObject(JSONObject jsonObject,String key){
        return (JSONObject) jsonObject.get(key);
    }
    private JSONArray getJsonArray(JSONObject jsonObject, String key){
        return  (JSONArray)jsonObject.get(key);
    }
    private JSONArray getBoardValues(JSONObject gameObject){
        return  (JSONArray) this.getJsonArray(this.getJsonObject(gameObject,BOARD),BOARD_VALUES);
    }
    private JSONObject getCellObject(JSONObject gameObject,int cellNumber){
        return  (JSONObject) this.getBoardValues(gameObject).get(cellNumber);
    }
    private JSONArray getCellPosition(JSONObject gameObject,int cellNumber){
        return  (JSONArray) this.getCellObject(gameObject,cellNumber).get(BOARD_POSITION);
    }
    public List<CellConfig> parseBoard(JSONObject jsonObject) {
        List<CellConfig> cells = new ArrayList<>();
        CellParser cellParser = new CellParser();


        JSONArray boardValues = this.getBoardValues(jsonObject);
        for (int i = 0; i < boardValues.size(); i++) {
            JSONObject cellObj = this.getCellObject(jsonObject,i);
            JSONArray positionCellObj = this.getCellPosition(jsonObject,i);
            int row = (int) (long) positionCellObj.get(0);
            int col = (int) (long) positionCellObj.get(1);

            Cell cell = cellParser.parseCell(cellObj);
            CellConfig cellConfig = new CellConfig(cell, row, col);
            cells.add(cellConfig);
        }

        return cells;
    }
}
