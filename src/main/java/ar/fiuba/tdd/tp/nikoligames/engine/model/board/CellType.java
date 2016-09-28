package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 24/09/2016.
 */
public enum CellType {


     STRINGTYPE {
        public AbstractCell createCell() {
            return new Cell();
        }
    }, NONEDITABLETYPE {
        public AbstractCell createCell() {
            return new NonEditableCell();
        }
    };

    public abstract AbstractCell createCell();

}
