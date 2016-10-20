package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.NodeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfigParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by german on 9/30/2016.
 */
public class NodeParser {

    public static final String BOARD_VALUE = "value";
    public static final String EDITABLE = "editable";
    public static final String BOARD_POSITION = "position";

    public NodeConfig parseNode(JSONObject cellObj) {

        JSONArray positionCellObj = (JSONArray) cellObj.get(BOARD_POSITION);
        SizeConfig position = SizeConfigParser.parse(positionCellObj);
        boolean editable = (boolean) cellObj.get(EDITABLE);
        NodeConfig node;
        if (cellObj.containsKey(BOARD_VALUE)) {
            String boardValue = (String) cellObj.get(BOARD_VALUE);
            node = new NodeConfig(boardValue, position.getRows(), position.getCols());
        } else {
            node = new NodeConfig(position.getRows(), position.getCols());
        }
        node.setEditable(editable);

        return node;
    }

}
