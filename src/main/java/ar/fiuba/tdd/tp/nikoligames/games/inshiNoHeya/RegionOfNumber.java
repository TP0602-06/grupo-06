package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class RegionOfNumber {

    private int number;
    private ArrayList<Position> list;

    public RegionOfNumber(ArrayList<Position>  list,int number){
        this.number = number;
        this.list = list;
    }

    public ArrayList<Position> listOfPositions(){
        return list;
    }

    public int number(){
        return number;
    }
}
