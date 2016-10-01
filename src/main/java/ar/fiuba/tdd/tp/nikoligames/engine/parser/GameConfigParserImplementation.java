package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.ConcreteGameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.SizeConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;

public class GameConfigParserImplementation implements GameConfigParser {

    public static final String GAME_NAME = "game_name";
    public static final String VALID_INPUT = "valid_input";
    public static final String GRID_SIZE = "grid_size";

    private final BoardParser boardParser = new BoardParser();
    private final RuleParser ruleParser = new RuleParser();
    private final FileReader fileReader;

    public GameConfigParserImplementation(String fileName) throws FileNotFoundException {
        fileReader = new FileReader(fileName);
    }

    @Override
    public GameConfig parse() throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        String gameName = parseGameName(jsonObject);
        SizeConfig sizeConfig = parseGridSize(jsonObject);
        HashSet<String> validInputsList = parseValidInputList(jsonObject);
        List<Rule> rules = ruleParser.parseRules(jsonObject);

        List<CellConfig> cells = boardParser.parseBoard(jsonObject);

        GameConfig gameConfig = new ConcreteGameConfig(gameName, sizeConfig, validInputsList, rules, cells);


        return gameConfig;
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
