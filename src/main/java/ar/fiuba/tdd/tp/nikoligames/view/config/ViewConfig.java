package ar.fiuba.tdd.tp.nikoligames.view.config;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.CellHintConfig;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellHint;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Andres on 17/10/2016.
 */
public class ViewConfig {
    boolean isCellBoard;
    Dimension boardDimension;
    List<CellHintConfig> cellHintConfigs;

    public ViewConfig(boolean isCellBoard, Dimension boardDimension, List<CellHintConfig> cellHintConfigs) {
        this.isCellBoard = isCellBoard;
        this.boardDimension = boardDimension;
        this.cellHintConfigs = cellHintConfigs;
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
}
