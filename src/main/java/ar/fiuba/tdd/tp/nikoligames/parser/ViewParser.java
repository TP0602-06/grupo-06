package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.CellHintConfig;
import ar.fiuba.tdd.tp.nikoligames.view.cells.NotValidCellHintException;
import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewParser {
    public static final String VIEW = "view";
    public static final String IS_CELL_BOARD = "is_cell_board";
    public static final String CELL_HINT_NAME = "definition";
    public static final String CELL_HINTS = "cell_hints";
    public static final String CELL_HINT_VALUE = "value";
    public static final Integer X_INDEX = 0;
    public static final Integer Y_INDEX = 1;
    public static final String POSITION = "pos";
    public static final String BOARD_DIMENSION = "board_dimension";

    public ViewConfig parseView(JSONObject jsonObject) throws Exception {
        if (!jsonObject.containsKey(VIEW)) {
            throw new Exception("No view configuration in file");
        }
        JSONObject viewObj = (JSONObject) jsonObject.get(VIEW);
        boolean isCellBoard = parseIsCellBoard(viewObj);
        List<CellHintConfig> cellHintConfigs = parseCellHintConfig(viewObj);
        Dimension boardDimension  = parseBoardDimensionBoard(viewObj);
        return new ViewConfig(isCellBoard, boardDimension, cellHintConfigs);
    }

    private boolean parseIsCellBoard(JSONObject viewObj) {
        if (!viewObj.containsKey(IS_CELL_BOARD)) {
            return true;
        }
        return (boolean) viewObj.get(IS_CELL_BOARD);
    }

    private Dimension parseBoardDimensionBoard(JSONObject viewObj) throws Exception {
        if (!viewObj.containsKey(BOARD_DIMENSION)) {
            throw new Exception("ViewConig -> No dimension specified for Board ");
        }
        JSONArray dimensionObject = (JSONArray) viewObj.get(BOARD_DIMENSION);
        Integer width = Integer.parseInt(dimensionObject.get(X_INDEX).toString());
        Integer height = Integer.parseInt(dimensionObject.get(Y_INDEX).toString());
        return new Dimension(width,height);
    }

    private List<CellHintConfig> parseCellHintConfig(JSONObject viewObj) throws NotValidCellHintException {
        List<CellHintConfig> cellHintConfigs = new ArrayList<>();

        if (viewObj.containsKey(CELL_HINTS)) {
            JSONArray cellHints = (JSONArray) viewObj.get(CELL_HINTS);

            Iterator<JSONObject> iterator = cellHints.iterator();
            while (iterator.hasNext()) {
                JSONObject cellHintObj = iterator.next();
                String name = cellHintObj.get(CELL_HINT_NAME).toString();
                String value = cellHintObj.get(CELL_HINT_VALUE).toString();
                JSONArray pos = (JSONArray) cellHintObj.get(POSITION);
                Integer row = Integer.parseInt(pos.get(X_INDEX).toString());
                Integer colum = Integer.parseInt(pos.get(Y_INDEX).toString());
                CellHintConfig hintConfig = new CellHintConfig(name, value, row, colum);
                cellHintConfigs.add(hintConfig);
            }
        }
        return cellHintConfigs;
    }

}