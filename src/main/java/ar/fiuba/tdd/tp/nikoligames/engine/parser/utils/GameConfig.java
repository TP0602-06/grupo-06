package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.RuleConfig;

import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public interface GameConfig {

    String getName();

    List<CellConfig> getInitialCells();

    List<RuleConfig> getRules();

    HashSet<String> getValidInputs();

    SizeConfig getSizeConfig();
}
