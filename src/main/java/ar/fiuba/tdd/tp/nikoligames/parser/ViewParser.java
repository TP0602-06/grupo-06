package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;
import org.json.simple.JSONObject;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewParser {
    public static final String VIEW = "view";
    public static final String IS_CELL_BOARD = "is_cell_board";

    public ViewConfig parseView(JSONObject jsonObject) {
        JSONObject viewObj = (JSONObject) jsonObject.get(VIEW);
        boolean isCellBoard = (boolean) viewObj.get(IS_CELL_BOARD);
        return new ViewConfig(isCellBoard);
    }
}