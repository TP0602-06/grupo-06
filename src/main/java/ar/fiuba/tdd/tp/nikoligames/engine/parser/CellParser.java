package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import org.json.simple.JSONObject;

/**
 * Created by german on 9/30/2016.
 */
public class CellParser {

    public static final String BOARD_VALUE = "value";
    public static final String EDITABLE = "editable";
    public static final String READONLY = "readonly";

    public Cell parseCell(JSONObject cellObj) {

        String boardValue = "";
        if (cellObj.containsKey(BOARD_VALUE)) {
            boardValue = (String) cellObj.get(BOARD_VALUE);
        }
        boolean editable = (boolean) cellObj.get(EDITABLE);


        Cell cell = new Cell(boardValue, editable);

        return cell;
    }

}
