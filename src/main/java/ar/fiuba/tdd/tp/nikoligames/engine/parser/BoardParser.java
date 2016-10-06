package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.NodeConfig;
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


    public List<NodeConfig> parseBoard(JSONObject jsonObject) {
        List<NodeConfig> nodes = new ArrayList<NodeConfig>();
        NodeParser nodeParser = new NodeParser();

        JSONObject boardObj = (JSONObject) jsonObject.get(BOARD);
        JSONArray boardValues = (JSONArray) boardObj.get(BOARD_VALUES);
        for (int i = 0; i < boardValues.size(); i++) {
            JSONObject cellObj = (JSONObject) boardValues.get(i);

            NodeConfig nodeConfig = nodeParser.parseNode(cellObj);

            nodes.add(nodeConfig);
        }

        return nodes;
    }
}
