package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public interface ViewConfig {

    List<RuleConfig> getRules();

    boolean NodeMatchesCell();

    List<CellHintConfig> getCellHints();
}
