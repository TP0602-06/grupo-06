package ar.fiuba.tdd.tp.nikoligames.view.config;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewConfigImplementation implements ViewConfig {
    boolean isCellBoard;
    Dimension boardDimension;
    List<PaintableHintConfig> cellHintConfigs;
    List<PaintableHintConfig> nodeHintConfigs;
    private List<RegionConfig> regions;

    public ViewConfigImplementation(boolean isCellBoard, Dimension boardDimension,
                                    List<PaintableHintConfig> cellHintConfigs, List<RegionConfig> regionConfigs,
                                    List<PaintableHintConfig> nodeHintConfigs) {
        this.isCellBoard = isCellBoard;
        this.boardDimension = boardDimension;
        this.cellHintConfigs = cellHintConfigs;
        this.regions = regionConfigs;
        this.nodeHintConfigs = nodeHintConfigs;
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

    public List<PaintableHintConfig> getCellHintConfigs() {
        return cellHintConfigs;
    }

    public List<PaintableHintConfig> getNodeHintConfigs() {
        return nodeHintConfigs;
    }

    public List<RegionConfig> getRegions() {
        return regions;
    }
}
