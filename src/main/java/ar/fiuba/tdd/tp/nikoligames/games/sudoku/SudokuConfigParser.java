package ar.fiuba.tdd.tp.nikoligames.games.sudoku;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.impl.GameConfigParserJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mcapolupo on 23/9/16.
 */
public class SudokuConfigParser extends GameConfigParserJson {

    @Override
    protected GameConfig buildGameConfig(JSONObject jsonObject) {

        JSONObject size = (JSONObject) jsonObject.get("size");
        JSONArray board = (JSONArray) jsonObject.get("board");

        SizeConfig sizeConfig = getSizeConfig(size);
        BoardConfig boardConfig = getBoardConfig(board);

        return new GameConfig(sizeConfig, boardConfig);
    }

    private SizeConfig getSizeConfig(JSONObject jsonObject) {
        long rows = (long) jsonObject.get("rows");
        long cols = (long) jsonObject.get("cols");
        return new SizeConfig(rows, cols);
    }

    private BoardConfig getBoardConfig(JSONArray jsonArray) {
        return new BoardConfig(jsonArray);
    }
}
