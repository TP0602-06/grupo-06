package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfigParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by mcapolupo on 24/9/16.
 */

public class BoardGameConfigParserTest {

    private static final String SUDOKU_CONFIG_PATH = "./src/test/config/sudoku/easy.json";
    private static final String KAKURO_CONFIG_PATH = "./src/test/config/kakuro/easy.json";

    @Test
    public void testBuildGameConfigSudoku() throws FileNotFoundException {

        //Setup
        FileReader fileReader = new FileReader(SUDOKU_CONFIG_PATH);
        GameConfigParser boardGameConfigParser = new BoardGameConfigParser();

        //Call method
        GameConfig gameConfig = boardGameConfigParser.parse(fileReader);

        //Asserts
        assertEquals(new Integer(9), gameConfig.getSize().getRows());
        assertEquals(new Integer(9), gameConfig.getSize().getCols());
        assertEquals("?", gameConfig.getBoard().getCells()[0][8].getInput());
        assertEquals("6", gameConfig.getBoard().getCells()[8][0].getInput());

    }

    @Test
    public void testBuildGameConfigKakuro() throws FileNotFoundException {

        //Setup
        FileReader fileReader = new FileReader(KAKURO_CONFIG_PATH);
        GameConfigParser boardGameConfigParser = new BoardGameConfigParser();

        //Call method
        GameConfig gameConfig = boardGameConfigParser.parse(fileReader);

        //Asserts
        assertEquals(new Integer(10), gameConfig.getSize().getRows());
        assertEquals(new Integer(12), gameConfig.getSize().getCols());
        assertEquals("16\\*", gameConfig.getBoard().getCells()[0][2].getInput());
        assertEquals("*\\*", gameConfig.getBoard().getCells()[9][11].getInput());

    }

}
