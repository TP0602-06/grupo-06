package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

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
}
