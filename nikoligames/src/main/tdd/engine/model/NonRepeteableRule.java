package tdd.engine.model;

import java.util.ArrayList;

public class NonRepeteableRule extends Rule {

    public boolean isBrocken() {
        for (int i = 0; cells.size() > i; i++) {
            for (int j = i; cells.size() > j; j++) {
                if (cells.get(i).isEqual(cells.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

}
