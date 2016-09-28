package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfigParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * Created by mcapolupo on 21/9/16.
 * This class knows how to build a {@link GameConfig} from a json file.
 */
public abstract class GameConfigParserJson implements GameConfigParser {

    JSONParser jsonParser = new JSONParser();

    @Override
    public GameConfig parse(FileReader fileReader) {

        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) jsonParser.parse(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buildGameConfig(jsonObject);

    }

    protected abstract GameConfig buildGameConfig(JSONObject jsonObject);

}
