package tdd.engine.model;

import java.util.ArrayList;


public class SumRule  extends Rule {

    private int sumGoal;

    public SumRule(int sum) {
        super();
        sumGoal = sum;
    }


    public boolean isBrocken() {
        int sum = 0;
        for (EditableCell cell : cells) {
            sum += cell.getNumber();
        }
        return  sumGoal != sum;
    }

}
