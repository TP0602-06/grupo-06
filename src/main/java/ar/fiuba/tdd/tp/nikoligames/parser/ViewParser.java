package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.CellHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;
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
    public static final String REGIONS_VIEW = "regions";

    public ViewConfig parseView(JSONObject jsonObject) throws Exception {
        if (!jsonObject.containsKey(VIEW)) {
            throw new Exception("No view configuration in file");
        }
        JSONObject viewObj = (JSONObject) jsonObject.get(VIEW);
        boolean isCellBoard = parseIsCellBoard(viewObj);
        List<CellHintConfig> cellHintConfigs = parseCellHintConfig(viewObj);
        Dimension boardDimension = parseBoardDimensionBoard(viewObj);
        List<RegionConfig> regionConfigs = parseRegionConfigs(viewObj);

        return new ViewConfig(isCellBoard, boardDimension, cellHintConfigs, regionConfigs);
    }

    private int getIntFrom(JSONArray postion, Integer index) {
        return Integer.parseInt(postion.get(index).toString());
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
        Integer width = getIntFrom(dimensionObject, X_INDEX);
        Integer height = getIntFrom(dimensionObject, Y_INDEX);
        return new Dimension(width, height);
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
                Integer row = getIntFrom(pos, X_INDEX);
                Integer colum = getIntFrom(pos, Y_INDEX);
                CellHintConfig hintConfig = new CellHintConfig(name, value, row, colum);
                cellHintConfigs.add(hintConfig);
            }
        }
        return cellHintConfigs;
    }

    private List<RegionConfig> parseRegionConfigs(JSONObject viewObj) {
        List<RegionConfig> regionConfigList = new ArrayList<>();

        if (viewObj.containsKey(REGIONS_VIEW)) {
            JSONArray regions = (JSONArray) viewObj.get(REGIONS_VIEW);

            Iterator regionsIterator = regions.iterator();
            while (regionsIterator.hasNext()) {
                JSONArray regionArray = (JSONArray) regionsIterator.next();
                List<Position> positions = new ArrayList<>();
                Iterator<JSONArray> positionIterator = regionArray.iterator();
                while (positionIterator.hasNext()) {
                    JSONArray postion = positionIterator.next();
                    Integer row = getIntFrom(postion, X_INDEX);
                    Integer colum = getIntFrom(postion, Y_INDEX);
                    Position newPos = new ClassicPosition(row, colum);
                    positions.add(newPos);
                }
                RegionConfig regionConfig = new RegionConfig(positions);
                regionConfigList.add(regionConfig);
            }
        }
        return regionConfigList;
    }

}