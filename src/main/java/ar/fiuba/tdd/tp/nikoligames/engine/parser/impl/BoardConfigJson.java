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
public class BoardConfigJson extends BoardConfig {

    public BoardConfigJson(SizeConfig sizeConfig, JSONArray jsonArray) {
        super(sizeConfig, jsonArray);
    }

    @Override
    protected CellConfig[][] createCells(SizeConfig sizeConfig, JSONArray jsonArray) {
        CellConfig[][] cells = new CellConfig[sizeConfig.getRows()][sizeConfig.getCols()];

        int rowCounter = 0;
        for (Object rowObject : jsonArray) {
            JSONObject jsonRow = (JSONObject) rowObject;
            String row = (String) jsonRow.get("row");
            String[] inputs = row.split(" ");
            int colCounter = 0;
            for (String input : inputs) {
                cells[rowCounter][colCounter] = new CellConfig(input);
                colCounter++;
            }
            rowCounter++;
        }
        return cells;
    }
}
