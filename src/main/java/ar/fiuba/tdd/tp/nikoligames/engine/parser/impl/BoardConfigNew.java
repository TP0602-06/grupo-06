package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;


import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mcapolupo on 20/9/16.
 * It is a kind of Board DTO, totally agnostic to model.
 */
public class BoardConfigNew extends BoardConfig {

    public BoardConfigNew(SizeConfig sizeConfig, JSONArray jsonArray) {
        super(sizeConfig, jsonArray);
    }

    @Override
    protected CellConfig[][] createCells(SizeConfig sizeConfig, JSONArray jsonArray) {
        CellConfig[][] cells = new CellConfig[sizeConfig.getRows()][sizeConfig.getCols()];

        for (int column = 0; column < 5; column++) {
            for (int row = 0; row< 5; row++) {
                cells[row][column] = new CellConfig("?");
            }
        }

        for (Object rowObject : jsonArray) {
            JSONObject valueObject = (JSONObject) rowObject;

            JSONArray position = (JSONArray) valueObject.get("position");

            Integer row = (Integer) position.get(0);
            Integer column = (Integer) position.get(1);
            String value = (String) valueObject.get("value");

            cells[row][column] = new CellConfig(value);

            JSONArray regions = (JSONArray) valueObject.get("regions");
            for (Object region : regions) {
                JSONArray regionArray = (JSONArray) region;

            }
        }

        return cells;
    }
}
