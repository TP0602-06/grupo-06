package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

/**
 * Responsabilidades: objeto que se usa para identificar rapidamente un Edge en el board
 */
public class EdgePosition {
    public EdgePosition(Position position1, Position position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    public Position getPosition1() {
        return position1;
    }

    public Position getPosition2() {
        return position2;
    }

    Position position1;
    Position position2;

    @SuppressWarnings("CPD-START")
    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || getClass() != otherObj.getClass()) {
            return false;
        }

        EdgePosition that = (EdgePosition) otherObj;

        return (position1.equals(that.position1) && position2.equals(that.position2));
    }

    @SuppressWarnings("CPD-END")

    @Override
    public int hashCode() {
        int result = position1.hashCode();
        result = 31 * result + (position2.hashCode());
        return result;
    }
}
