package ar.fiuba.tdd.tp.nikoligames.engine.model.board;


public enum CellType {


    NULLTYPE {
        public AbstractCell createCell() {
            return new NullCell();
        }
    }, STRINGTYPE {
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
