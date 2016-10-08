package ar.fiuba.tdd.tp.nikoligames.parser.utils;

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
