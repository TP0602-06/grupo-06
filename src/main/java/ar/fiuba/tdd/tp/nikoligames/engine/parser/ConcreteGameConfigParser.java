package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.impl.BoardConfigNew;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.impl.GameConfigParserJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Reader;

/**
 * Created by matias on 29/09/16.
 */
public class ConcreteGameConfigParser extends GameConfigParser {
    @Override
    protected BoardConfig buildGameConfig(JSONObject jsonObject) {

        JSONObject board = (JSONObject) jsonObject.get("board");
        JSONArray values = (JSONArray) board.get("values");

        SizeConfig sizeConfig = new SizeConfig(5, 5);
        BoardConfig boardConfig = getBoardConfig(sizeConfig, values);

        return null;
    }

    private BoardConfig getBoardConfig(SizeConfig sizeConfig, JSONArray jsonArray) {
        return new BoardConfigNew(sizeConfig, jsonArray);
    }

    @Override
    public BoardConfig parse(Reader fileReader) {
        return null;
    }
}
