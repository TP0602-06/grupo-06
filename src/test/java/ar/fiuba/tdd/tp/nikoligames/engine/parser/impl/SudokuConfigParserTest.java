package ar.fiuba.tdd.tp.nikoligames.engine.parser.impl;

import ar.fiuba.tdd.tp.nikoligames.engine.parser.GameConfig;
import ar.fiuba.tdd.tp.nikoligames.games.sudoku.SudokuConfigParser;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by mcapolupo on 24/9/16.
 */

public class SudokuConfigParserTest {

    private static final String CONFIG_PATH = "./src/test/config/sudoku/easy.json";

    @Test
    public void testBuildGameConfig() throws FileNotFoundException {

        //Setup
        FileReader fileReader = new FileReader(CONFIG_PATH);
        SudokuConfigParser sudokuConfigParser = new SudokuConfigParser();

        //Call method
        GameConfig gameConfig = sudokuConfigParser.parse(fileReader);

        //Asserts
        assertEquals(new Long(9), gameConfig.getSize().getCols());
        assertEquals(new Long(9), gameConfig.getSize().getRows());
        assertNotNull(gameConfig.getBoard());
        assertEquals("?", gameConfig.getBoard().getCells()[0][8].getInput());
        assertEquals("6", gameConfig.getBoard().getCells()[8][0].getInput());

    }

}
