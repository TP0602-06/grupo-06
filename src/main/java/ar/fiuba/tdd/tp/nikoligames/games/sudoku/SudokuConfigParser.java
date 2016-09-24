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
        JSONObject problem = (JSONObject) jsonObject.get("problem");
        JSONObject solution = (JSONObject) jsonObject.get("solution");

        SizeConfig sizeConfig = getSizeConfig(size);
        BoardConfig problemConfig = getBoardConfig(problem);
        BoardConfig solutionConfig = getBoardConfig(solution);

        return new GameConfig(sizeConfig, problemConfig, solutionConfig);
    }

    private SizeConfig getSizeConfig(JSONObject jsonObject) {
        Long rows = (Long) jsonObject.get("rows");
        Long cols = (Long) jsonObject.get("cols");
        return new SizeConfig(rows, cols);
    }

    private BoardConfig getBoardConfig(JSONObject jsonObject) {
        JSONArray rows = (JSONArray) jsonObject.get("board");
        rows.forEach(r -> System.out.println(((JSONObject) r).get("row")));
        return new BoardConfig();
    }
}
