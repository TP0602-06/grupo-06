package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;

/**
 * BoardFactory. Abstrae al cliente de conocer la creacion de un tablero y le facilita su creacion.
 * Se hizo singleton para que no se instancie varias veces y no se preste a confusiones.
 */
public class BoardFactory {

    private static BoardFactory instance;

    private BoardFactory() {

    }

    public Board createBoard(SizeConfig sizeConfig, BoardConfig boardConfig) {
        Board board = new Board(sizeConfig.getRows(), sizeConfig.getCols());
        CellConfig[][] cellConfigs = boardConfig.getCells();
        CellFactory cellFactory = CellFactory.getInstance();
        for (int i = 0; i < sizeConfig.getCols(); i++) {
            for (int j = 0; j < sizeConfig.getRows(); j++) {
                board.setCell(j, i, cellFactory.createCell(cellConfigs[j][i].getInput()));
            }
        }
        return board;
    }

    public static BoardFactory getInstance() {
        if (instance == null) {
            instance = new BoardFactory();
        }
        return instance;
    }

}
