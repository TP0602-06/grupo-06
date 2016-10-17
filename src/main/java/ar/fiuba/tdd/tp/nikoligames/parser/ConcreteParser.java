package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JsonObjectFilePathParser;

import java.io.*;
import java.util.HashSet;
import java.util.List;

public class ConcreteParser implements AbstractParser {

    public static final String GAME_NAME = "game_name";
    public static final String VALID_INPUT = "valid_input";
    public static final String GRID_SIZE = "grid_size";

    private final BoardParser boardParser = new BoardParser();
    private final RuleParser ruleParser = new RuleParser();
    private final String fileName;


    public ConcreteParser(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    @Override
    public GameConfig parse() throws Exception {
        JSONObject jsonObject = JsonObjectFilePathParser.getJsonObject(fileName);

        String gameName = parseGameName(jsonObject);
        SizeConfig sizeConfig = parseGridSize(jsonObject);
        HashSet<String> validInputsList = parseValidInputList(jsonObject);
        List<RuleConfig> rules = ruleParser.parseRules(jsonObject);

        List<NodeConfig> nodes = boardParser.parseBoard(jsonObject);

        GameConfig gameConfig = new ConcreteGameConfig(gameName, sizeConfig, validInputsList, rules, nodes);

        return gameConfig;
    }

    private String parseGameName(JSONObject jsonObject) {
        return (String) jsonObject.get(GAME_NAME);
    }

    private HashSet<String> parseValidInputList(JSONObject jsonObject) {
        HashSet<String> validInputsList = new HashSet<String>();
        JSONArray validInputs = (JSONArray) jsonObject.get(VALID_INPUT);
        for (int i = 0; i < validInputs.size(); i++) {
            String validInput = (String) validInputs.get(i);
            validInputsList.add(validInput);
        }
        return validInputsList;
    }

    private SizeConfig parseGridSize(JSONObject jsonObject) {
        JSONArray gridSize = (JSONArray) jsonObject.get(GRID_SIZE);
        SizeConfig sizeConfig = SizeConfigParser.parse(gridSize);
        return sizeConfig;
    }
}
