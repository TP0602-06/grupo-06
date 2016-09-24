package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 24/09/2016.
 */
public enum CellType {
    NULLTYPE {
        public CellInterface createCell() {
            return new NullCell();
        }
    }, STRINGTYPE {
        public CellInterface createCell() {
            return new Cell();
        }
    };

    abstract public CellInterface createCell();
}
