package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.NodeConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by german on 9/30/2016.
 */
public class NodeParser {

    public static final String BOARD_VALUE = "value";
    public static final String EDITABLE = "editable";
    public static final String READONLY = "readonly";
    public static final String BOARD_POSITION = "position";

    public NodeConfig parseNode(JSONObject cellObj) {

        JSONArray positionCellObj = (JSONArray) cellObj.get(BOARD_POSITION);
        int row = (int) (long) positionCellObj.get(0);
        int col = (int) (long) positionCellObj.get(1);

        String boardValue = "";
        if (cellObj.containsKey(BOARD_VALUE)) {
            boardValue = (String) cellObj.get(BOARD_VALUE);
        }
        boolean editable = (boolean) cellObj.get(EDITABLE);

        boolean readonly = (boolean) cellObj.get(READONLY);

        NodeConfig node = new NodeConfig(boardValue, row, col);
        node.setEditable(editable);
        node.setReadonly(readonly);

        return node;
    }

}
