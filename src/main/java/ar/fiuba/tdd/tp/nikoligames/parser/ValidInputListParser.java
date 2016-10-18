package ar.fiuba.tdd.tp.nikoligames.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashSet;

/**
 * Created by german on 10/18/2016.
 */
public class ValidInputListParser {
    public static final String VALID_INPUT = "valid_input";

    public static HashSet<String> parseValidInputList(JSONObject jsonObject) {
        HashSet<String> validInputsList = new HashSet<String>();
        JSONArray validInputs = (JSONArray) jsonObject.get(VALID_INPUT);
        for (int i = 0; i < validInputs.size(); i++) {
            String validInput = (String) validInputs.get(i);
            validInputsList.add(validInput);
        }
        return validInputsList;
    }
}
