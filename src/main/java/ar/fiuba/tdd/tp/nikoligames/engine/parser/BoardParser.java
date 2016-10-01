package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public class BoardParser {
    public static final String BOARD = "board";
    public static final String BOARD_VALUES = "values";
    public static final String BOARD_POSITION = "position";

    public List<CellConfig> parseBoard(JSONObject jsonObject) {
        List<CellConfig> cells = new ArrayList<CellConfig>();
        CellParser cellParser = new CellParser();

        JSONObject boardObj = (JSONObject) jsonObject.get(BOARD);
        JSONArray boardValues = (JSONArray) boardObj.get(BOARD_VALUES);
        for (int i = 0; i < boardValues.size(); i++) {
            JSONObject cellObj = (JSONObject) boardValues.get(i);
            JSONArray positionCellObj = (JSONArray) cellObj.get(BOARD_POSITION);
            int row = (int) (long) positionCellObj.get(0);
            int col = (int) (long) positionCellObj.get(1);

            Cell cell = cellParser.parseCell(cellObj);
            CellConfig cellConfig = new CellConfig(cell, row, col);
            cells.add(cellConfig);
        }

        return cells;
    }
}
