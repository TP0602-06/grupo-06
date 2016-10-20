package ar.fiuba.tdd.tp.nikoligames.parser;

import ar.fiuba.tdd.tp.nikoligames.parser.utils.ConcreteGameConfig;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;

/**
 * Created by mcapolupo on 20/9/16.
 * All implementations know how to parse any file type to create a {@link ConcreteGameConfig}
 */
public interface GameParser {

    GameConfig parse() throws Exception;
}
