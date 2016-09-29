package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by matias on 29/09/16.
 */
public class BoardGameConfigParserNew extends GameConfigParserJson {
    @Override
    protected GameConfig buildGameConfig(JSONObject jsonObject) {

        JSONObject board = (JSONObject) jsonObject.get("board");
        JSONArray values = (JSONArray) board.get("values");

        SizeConfig sizeConfig = new SizeConfig(5, 5);
        BoardConfig boardConfig = getBoardConfig(sizeConfig, values);

        return new GameConfig(sizeConfig, boardConfig);
    }

    private BoardConfig getBoardConfig(SizeConfig sizeConfig, JSONArray jsonArray) {
        return new BoardConfigNew(sizeConfig, jsonArray);
    }
}
