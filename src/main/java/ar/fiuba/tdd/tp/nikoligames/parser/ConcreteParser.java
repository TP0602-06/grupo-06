package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.*;
import org.json.simple.JSONObject;
import utils.JsonObjectFilePathParser;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;

public class ConcreteParser implements GameParser {

    private final BoardParser boardParser = new BoardParser();
    private final RuleParser ruleParser = new RuleParser();
    private final String fileName;

    public ConcreteParser(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    @Override
    public GameConfig parse() throws Exception {
        JSONObject jsonObject = JsonObjectFilePathParser.getJsonObject(fileName);

        String gameName = GameNameParser.parseGameName(jsonObject);

        SizeConfig sizeConfig = SizeConfigParser.parseGridSize(jsonObject);

        HashSet<String> validInputsList = ValidInputListParser.parseValidInputList(jsonObject);

        List<RuleConfig> rules = ruleParser.parseRules(jsonObject);

        List<NodeConfig> nodes = boardParser.parseBoard(jsonObject);

        GameConfig gameConfig = new ConcreteGameConfig(gameName, sizeConfig, validInputsList, rules, nodes);

        return gameConfig;
    }


}
