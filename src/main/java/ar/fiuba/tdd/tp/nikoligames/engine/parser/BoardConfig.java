package ar.fiuba.tdd.tp.nikoligames.engine.parser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mcapolupo on 20/9/16.
 */
public class BoardConfig {

    private CellConfig[][] cells;

    public BoardConfig(SizeConfig sizeConfig, JSONArray jsonArray) {
        cells = new CellConfig[sizeConfig.getRows()][sizeConfig.getCols()];
        populateCells(jsonArray);
    }

    private void populateCells(JSONArray jsonArray) {
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
    }

    public CellConfig[][] getCells() {
        return cells.clone(); //TODO: findbug tira EI_EXPOSE_REP
    }


}
