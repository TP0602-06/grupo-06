package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mcapolupo on 23/9/16.
 * Class used to build a {@link GameConfig} when the game is based on a board.
 */
public class BoardGameConfigParser extends GameConfigParserJson {

    @Override
    protected GameConfig buildGameConfig(JSONObject jsonObject) {

        JSONObject size = (JSONObject) jsonObject.get("size");
        JSONArray board = (JSONArray) jsonObject.get("board");

        SizeConfig sizeConfig = getSizeConfig(size);
        BoardConfig boardConfig = getBoardConfig(sizeConfig, board);

        return new GameConfig(sizeConfig, boardConfig);
    }

    private SizeConfig getSizeConfig(JSONObject jsonObject) {
        Integer rows = Integer.valueOf((String) jsonObject.get("rows"));
        Integer cols = Integer.valueOf((String)jsonObject.get("cols"));
        return new SizeConfig(rows, cols);
    }

    private BoardConfig getBoardConfig(SizeConfig sizeConfig, JSONArray jsonArray) {
        return new BoardConfigJson(sizeConfig, jsonArray);
    }
}
