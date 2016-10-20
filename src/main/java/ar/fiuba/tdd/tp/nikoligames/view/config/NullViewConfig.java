package ar.fiuba.tdd.tp.nikoligames.view.config;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by tobias on 19/10/16.
 */
public class NullViewConfig implements ViewConfig {

    public boolean isCellBoard() {
        return true;
    }

    public boolean isNodeBoard() {
        return false;
    }

    public Dimension getBoardDimension() {
        return new Dimension(300,300);
    }

    public List<PaintableHintConfig> getCellHintConfigs() {
        return new ArrayList<>();
    }

    public List<PaintableHintConfig> getNodeHintConfigs() {
        return new ArrayList<>();
    }

    public List<RegionConfig> getRegions() {
        return new ArrayList<>();
    }
}
