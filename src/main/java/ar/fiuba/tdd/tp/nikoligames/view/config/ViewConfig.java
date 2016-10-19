package ar.fiuba.tdd.tp.nikoligames.view.config;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.CellHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;

import java.awt.*;
import java.util.List;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewConfig {
    boolean isCellBoard;
    Dimension boardDimension;
    List<CellHintConfig> cellHintConfigs;
    private List<RegionConfig> regions;

    public ViewConfig(boolean isCellBoard, Dimension boardDimension,
                      List<CellHintConfig> cellHintConfigs, List<RegionConfig> regionConfigs) {
        this.isCellBoard = isCellBoard;
        this.boardDimension = boardDimension;
        this.cellHintConfigs = cellHintConfigs;
        this.regions = regionConfigs;
    }

    public boolean isCellBoard() {
        return isCellBoard;
    }

    public boolean isNodeBoard() {
        return !isCellBoard;
    }

    public Dimension getBoardDimension() {
        return boardDimension;
    }

    public List<CellHintConfig> getCellHintConfigs() {
        return cellHintConfigs;
    }

    public List<RegionConfig> getRegions() {
        return regions;
    }
}
