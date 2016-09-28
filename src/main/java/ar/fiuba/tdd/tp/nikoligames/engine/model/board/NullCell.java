package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

class NullCell extends AbstractCell {

    public boolean isNullCell() {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isEditable() {
        return false;
    }

}
