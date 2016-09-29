package ar.fiuba.tdd.tp.nikoligames.engine.parser;


import org.json.simple.JSONArray;

/**
 * Created by mcapolupo on 20/9/16.
 * It is a kind of Board DTO, totally agnostic to model.
 */
public abstract class BoardConfig {

    private CellConfig[][] cells;

    public BoardConfig(SizeConfig sizeConfig, JSONArray jsonArray) {
        this.cells =  this.createCells(sizeConfig, jsonArray);
    }

    protected abstract CellConfig[][] createCells(SizeConfig sizeConfig, JSONArray jsonArray);

    public CellConfig[][] getCells() {
        return cells.clone();
    }


}
