package ar.fiuba.tdd.tp.nikoligames.view.config;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.PaintableHintConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.viewconfig.RegionConfig;

import java.awt.*;
import java.util.List;


/**
 * Created by tobias on 19/10/16.
 */
public interface ViewConfig {

    boolean isCellBoard();

    boolean isNodeBoard();

    Dimension getBoardDimension();

    List<PaintableHintConfig> getCellHintConfigs();

    List<PaintableHintConfig> getNodeHintConfigs();

    List<RegionConfig> getRegions();

}
