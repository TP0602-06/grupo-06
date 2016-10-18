package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.*;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfigParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.JsonObjectFilePathParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/16/2016.
 */
public class PlayParser {
    public static final String POSITION_KEY = "position";
    public static final String NUM_KEY = "number";
    public static final String BOARDSTATUS_KEY = "boardStatus";
    public static final String VALUE_KEY = "value";
    private static final String TWO_POSITION_KEY = "node_positions";
    private static final String EDGE_ACTION = "edge_action";
    private static final String CREATE_UNDIRECTED = "CREATE_UNDIRECTED";
    private static final String CREATE_DIRECTED = "CREATE_DIRECTED";
    private static final String REMOVE_UNDIRECTED = "REMOVE_UNDIRECTED";
    private static final String REMOVE_DIRECTED = "REMOVE_DIRECTED";

    public static JSONObject toJson(AbstractPlay play) {
        JSONObject moveJson = new JSONObject();
        moveJson.put(NUM_KEY, play.getNumber());
        moveJson.put(BOARDSTATUS_KEY, play.getBoardStatus());

        return moveJson;
    }

    private static AbstractPlay parseSingle(JSONObject object, Game game) throws Exception {

        int number = parseNumber(object);

        if (object.containsKey(POSITION_KEY)) {
            return parseChangeNodeValuePlay(object, game, number);
        }

        if (object.containsKey(TWO_POSITION_KEY)) {
            return parseEdgeOperationPlay(object, game, number);
        }

        throw new Exception("not a valid play");
    }

    private static AbstractPlay parseEdgeOperationPlay(JSONObject object, Game game, int number) throws Exception {
        List<Position> positions = getPositions(object);
        Position position1 = positions.get(0);
        Position position2 = positions.get(1);

        if (!object.containsKey(EDGE_ACTION)) {
            throw new Exception("You must specify edge action (createUndirected, createDirected, removeUndirected, removeDirected");
        }
        String edgeAction = (String) object.get(EDGE_ACTION);
        switch (edgeAction) {
            case CREATE_UNDIRECTED:
                return new CreateUndirectedEdgePlay(game, number, position1, position2);
            case CREATE_DIRECTED:
                return new CreateDirectedEdgePlay(game, number, position1, position2);
            case REMOVE_UNDIRECTED:
                return new RemoveUndirectedEdgePlay(game, number, position1, position2);
            case REMOVE_DIRECTED:
                return new RemoveDirectedEdgePlay(game, number, position1, position2);
            default:
                throw new Exception("not a valid edge operation");
        }
    }

    private static List<Position> getPositions(JSONObject object) throws Exception {
        List<Position> positions = JsonArrayOfPositionsParser.parseJsonObjectListOfPositions(object, TWO_POSITION_KEY);
        if (positions.size() != 2) {
            throw new Exception("You can connect only two nodes by an edge");
        }
        return positions;
    }

    private static AbstractPlay parseChangeNodeValuePlay(JSONObject object, Game game, int number) throws Exception {
        JSONArray positionJsonArrayObj = (JSONArray) object.get(POSITION_KEY);
        SizeConfig positionConfig = SizeConfigParser.parse(positionJsonArrayObj);

        Position position = new ClassicPosition(positionConfig.getRows(), positionConfig.getCols());

        if (!object.containsKey(VALUE_KEY)) {
            throw new Exception("The play to change node value must have 'value' String field");
        }
        String value = (String) object.get(VALUE_KEY);
        AbstractPlay play = new ChangeNodeValuePlay(game, number, value, position);
        return play;
    }

    private static int parseNumber(JSONObject object) throws Exception {
        if (!object.containsKey(NUM_KEY)) {
            throw new Exception("The play must have an int 'number' ");
        }
        return (int) (long) object.get(NUM_KEY);
    }

    public static List<AbstractPlay> parse(String inputFileName, Game game) throws IOException, ParseException {
        JSONObject jsonObject = JsonObjectFilePathParser.getJsonObject(inputFileName);

        JSONArray playJsonArray = (JSONArray) jsonObject.get("plays");
        List<AbstractPlay> plays = new ArrayList<AbstractPlay>();
        for (int i = 0; i < playJsonArray.size(); i++) {
            JSONObject playJsonObject = (JSONObject) playJsonArray.get(i);

            try {
                AbstractPlay play = PlayParser.parseSingle(playJsonObject, game);
                plays.add(play);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return plays;
    }
}
