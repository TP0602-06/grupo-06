package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

public class ClassicPosition extends Position {

    public ClassicPosition(int row, int col) {
        super(row - 1, col - 1);
    }
}