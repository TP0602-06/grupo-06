package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.BoardConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.CellConfig;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.SizeConfig;

/**
 * Created by Andres on 24/09/2016.
 */
public class BoardFactory {

    private static BoardFactory instance;

    private  BoardFactory(){

    }

    public Board createBoard(SizeConfig sizeConfig, BoardConfig boardConfig) {
        Board board = new Board(sizeConfig.getCols(), sizeConfig.getRows());
        CellConfig[][] cellConfigs = boardConfig.getCells();
        CellFactory cellFactory = CellFactory.getInstance();
        for (int i = 0; i < sizeConfig.getCols(); i++) {
            for (int j = 0; j < sizeConfig.getRows(); j++) {
                board.setCell(i, j, cellFactory.createCell(cellConfigs[i][j].getInput()));
            }
        }
        return board;
    }

    public static BoardFactory getInstance(){
        if(instance == null){
            instance = new BoardFactory();
        }
        return  instance;
    }

}
