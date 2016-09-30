package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.Reader;
import java.util.HashSet;

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
    public static final String BOARD = "board";
    public static final String BOARD_VALUES = "values";
    public static final String BOARD_POSITION = "position";
    public static final String BOARD_VALUE = "value";
    public static final String EDITABLE = "editable";
    public static final String READONLY = "readonly";

    @Override
    public GameConfig parse(Reader fileReader) throws Exception {
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

    private void parseBoard(JSONObject jsonObject, GameConfig gameConfig) {
        JSONObject boardObj = (JSONObject) jsonObject.get(BOARD);
        JSONArray boardValues = (JSONArray) boardObj.get(BOARD_VALUES);
        for (int i = 0; i < boardValues.size(); i++) {
            JSONObject boardValueObj = (JSONObject) boardValues.get(i);

            JSONArray positionCellObj = (JSONArray) boardValueObj.get(BOARD_POSITION);
            int row = (int) (long) positionCellObj.get(0);
            int col = (int) (long) positionCellObj.get(1);

            String boardValue = "";
            if (boardValueObj.containsKey(BOARD_VALUE)) {
                boardValue = (String) boardValueObj.get(BOARD_VALUE); //TODO: crear la celda correspondiente con un Builder! (paso a paso le voy diciendo que tiene)
            }
            boolean editable = (boolean) boardValueObj.get(EDITABLE);

            boolean readonly = (boolean) boardValueObj.get(READONLY);

            Cell cell = new Cell(boardValue, editable, readonly);
            gameConfig.addInitialCell(row, col, cell);
        }
    }

    private void parseRules(JSONObject jsonObject, GameConfig gameConfig) throws Exception {
        JSONObject rulesObj = (JSONObject) jsonObject.get(RULES);
        JSONArray ruleValues = (JSONArray) rulesObj.get(RULE_VALUES);
        for (int i = 0; i < ruleValues.size(); i++) {
            JSONObject ruleObj = (JSONObject) ruleValues.get(i);


            String definition = (String) ruleObj.get(RULE_DEFINITION);

            RuleBuilder ruleBuilder = new RuleBuilder(definition);

            JSONArray regionObj = (JSONArray) ruleObj.get("region");
            for (int j = 0; i < regionObj.size(); i++) {
                JSONArray regioCellObj = (JSONArray) ruleObj.get(j);
                int row = (int) (long) regioCellObj.get(0);
                int col = (int) (long) regioCellObj.get(1);
                ruleBuilder.addCellToRegion(row, col);
            }

            if (ruleObj.containsKey(RULE_OPERATION_VALUE)) {
                String ruleValue = (String) ruleObj.get(RULE_OPERATION_VALUE);
                ruleBuilder.setValue(ruleValue);
            }

            Rule rule = ruleBuilder.createRule();
            gameConfig.addRule(rule);
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
