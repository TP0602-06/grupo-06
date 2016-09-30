package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 29/09/16.
 */
public class GameConfigParser implements AbstractGameConfigParser {

    public static final String GAME_NAME = "game_name";
    public static final String VALID_INPUT = "valid_input";
    public static final String GRID_SIZE = "grid_size";
    public static final String RULES = "rules";
    public static final String RULE_VALUES = "values";
    public static final String RULE_DEFINITION = "definition";
    public static final String RULE_OPERATION_VALUE = "value";

    @Override
    public GameConfig parse(Reader fileReader) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        JSONObject gameName = (JSONObject) jsonObject.get(GAME_NAME);
        SizeConfig sizeConfig = parseGridSize(jsonObject);

        List<String> validInputsList = parseValidInputList(jsonObject);

        JSONObject rulesObj = (JSONObject) jsonObject.get(RULES);
        JSONArray ruleValues = (JSONArray) rulesObj.get(RULE_VALUES);
        for(int i = 0; i < ruleValues.size(); i++) {
            JSONObject ruleObj = (JSONObject) ruleValues.get(i);
            String definition = (String) ruleObj.get(RULE_DEFINITION); //TODO: ver si es valida
            JSONArray regionObj = (JSONArray) ruleObj.get("region");
            for(int j = 0; i < regionObj.size(); i++) {
                JSONArray regioCellObj = (JSONArray) ruleObj.get(j);
                int row = (int)(long) regioCellObj.get(0);
                int col = (int)(long) regioCellObj.get(1);
            }

            if (ruleObj.containsKey("value")){
                String value = (String) ruleObj.get(RULE_OPERATION_VALUE); //TODO: crear la rule Correspondiente
            }
        }
        return null;
    }

    private List<String>  parseValidInputList(JSONObject jsonObject) {
        List<String> validInputsList = new ArrayList<>();
        JSONArray validInputs = (JSONArray) jsonObject.get(VALID_INPUT);
        for(int i = 0; i < validInputs.size(); i++){
            String validInput = (String) validInputs.get(i);
            validInputsList.add(validInput);
        }
        return validInputs;
    }

    private SizeConfig parseGridSize(JSONObject jsonObject) {
        JSONArray gridSize = (JSONArray) jsonObject.get(GRID_SIZE);
        int rows = (int) (long) gridSize.get(0);
        int cols = (int) (long) gridSize.get(1);

        SizeConfig sizeConfig = new SizeConfig(rows,cols);
        return sizeConfig;
    }
}
