package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

public class GameConfigParser implements AbstractGameConfigParser {

    public static final String GAME_NAME = "game_name";
    public static final String VALID_INPUT = "valid_input";
    public static final String GRID_SIZE = "grid_size";
    public static final String RULES = "rules";
    public static final String RULE_VALUES = "values";
    public static final String BOARD = "board";
    public static final String BOARD_VALUES = "values";
    public static final String BOARD_POSITION = "position";

    private final FileReader fileReader;

    public GameConfigParser(String fileName) throws FileNotFoundException {
        fileReader = new FileReader(fileName);
    }

    @Override
    public GameConfig parse() throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        String gameName = parseGameName(jsonObject);
        SizeConfig sizeConfig = parseGridSize(jsonObject);
        HashSet<String> validInputsList = parseValidInputList(jsonObject);

        GameConfig gameConfig = new ConcreteGameConfig(gameName, sizeConfig, validInputsList);

        parseRules(jsonObject, gameConfig);

        parseBoard(jsonObject, gameConfig);

        return gameConfig;
    }

    private void parseRules(JSONObject jsonObject, GameConfig gameConfig) throws Exception {
        RuleParser ruleParser = new RuleParser();

        JSONObject rulesObj = (JSONObject) jsonObject.get(RULES);
        JSONArray ruleValues = (JSONArray) rulesObj.get(RULE_VALUES);

        for (int i = 0; i < ruleValues.size(); i++) {
            JSONObject ruleObj = (JSONObject) ruleValues.get(i);

            Rule rule = ruleParser.parseRule(ruleObj);
            gameConfig.addRule(rule);
        }

    }

    private void parseBoard(JSONObject jsonObject, GameConfig gameConfig) {
        CellParser cellParser = new CellParser();

        JSONObject boardObj = (JSONObject) jsonObject.get(BOARD);
        JSONArray boardValues = (JSONArray) boardObj.get(BOARD_VALUES);
        for (int i = 0; i < boardValues.size(); i++) {
            JSONObject cellObj = (JSONObject) boardValues.get(i);
            JSONArray positionCellObj = (JSONArray) cellObj.get(BOARD_POSITION);
            int row = (int) (long) positionCellObj.get(0);
            int col = (int) (long) positionCellObj.get(1);

            Cell cell = cellParser.parseCell(cellObj);

            gameConfig.addInitialCell(row, col, cell);
        }
    }



    private String parseGameName(JSONObject jsonObject) {
        return (String) jsonObject.get(GAME_NAME);
    }

    private HashSet<String> parseValidInputList(JSONObject jsonObject) {
        HashSet<String> validInputsList = new HashSet<>();
        JSONArray validInputs = (JSONArray) jsonObject.get(VALID_INPUT);
        for (int i = 0; i < validInputs.size(); i++) {
            String validInput = (String) validInputs.get(i);
            validInputsList.add(validInput);
        }
        return validInputsList;
    }

    private SizeConfig parseGridSize(JSONObject jsonObject) {
        JSONArray gridSize = (JSONArray) jsonObject.get(GRID_SIZE);
        int rows = (int) (long) gridSize.get(0);
        int cols = (int) (long) gridSize.get(1);

        SizeConfig sizeConfig = new SizeConfig(rows, cols);
        return sizeConfig;
    }
}
