package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by german on 10/17/2016.
 */
public class SizeConfigParser {
    public static final String GRID_SIZE = "grid_size";

    public static SizeConfig parse(JSONArray jsonArray) {
        int rows = (int) (long) jsonArray.get(0);
        int cols = (int) (long) jsonArray.get(1);

        return new SizeConfig(rows, cols);
    }

    public static SizeConfig parseGridSize(JSONObject jsonObject) {
        JSONArray gridSize = (JSONArray) jsonObject.get(GRID_SIZE);
        SizeConfig sizeConfig = SizeConfigParser.parse(gridSize);
        return sizeConfig;
    }
}
