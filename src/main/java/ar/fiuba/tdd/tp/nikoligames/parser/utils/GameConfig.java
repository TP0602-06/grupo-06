package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;
import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfigImplementation;

import java.util.List;
import java.util.Set;

/**
 * Created by german on 9/30/2016.
 */
public interface GameConfig {

    String getName();

    List<NodeConfig> getInitialCells();

    List<RuleConfig> getRules();

    Set<String> getValidInputs();

    SizeConfig getSizeConfig();

    ViewConfig getViewConfig();
}
