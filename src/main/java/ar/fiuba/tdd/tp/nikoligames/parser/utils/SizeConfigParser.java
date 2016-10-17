package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import org.json.simple.JSONArray;

/**
 * Created by german on 10/17/2016.
 */
public class SizeConfigParser {

    public static SizeConfig parse(JSONArray jsonArray) {
        int rows = (int) (long) jsonArray.get(0);
        int cols = (int) (long) jsonArray.get(1);

        return new SizeConfig(rows, cols);
    }
}
