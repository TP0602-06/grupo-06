package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.SizeConfigParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/18/2016.
 */
public class JsonArrayOfPositionsParser {

    public static List<Position> parseJsonObjectListOfPositions(JSONObject regionObject, String regionKey) {

        JSONArray regionObj = (JSONArray) regionObject.get(regionKey);

        return JsonArrayOfPositionsParser.parseJsonArrayOfPositions(regionObj);
    }

    public static List<Position> parseJsonArrayOfPositions(JSONArray regionObj) {

        ArrayList<Position> positionsList = new ArrayList<Position>();

        for (int j = 0; j < regionObj.size(); j++) {
            JSONArray regioCellObj = (JSONArray) regionObj.get(j);
            SizeConfig position = SizeConfigParser.parse(regioCellObj);
            positionsList.add(new ClassicPosition(position.getRows(), position.getCols()));
        }
        return positionsList;
    }
}
