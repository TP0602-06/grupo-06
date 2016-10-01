package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.ConcreteGameConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.GameConfig;

/**
 * Created by mcapolupo on 20/9/16.
 * All implementations know how to parse any file type to create a {@link ConcreteGameConfig}
 */
public interface GameConfigParser {

    GameConfig parse() throws Exception;
}
