package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;
import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfigImplementation;

import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public interface GameConfig {

    String getName();

    List<NodeConfig> getInitialCells();

    List<RuleConfig> getRules();

    HashSet<String> getValidInputs();

    SizeConfig getSizeConfig();

    ViewConfig getViewConfig();
}
