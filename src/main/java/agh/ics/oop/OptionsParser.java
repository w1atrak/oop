package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {


    public MoveDirection[] parse(String[] args){
        List<MoveDirection> res = new ArrayList<MoveDirection>();
        for(String i : args){
            if(i.equals("f") || i.equals("forward")) {
                res.add(MoveDirection.FORWARD);
            }
            else if(i.equals("b") || i.equals("backward")) {
                res.add(MoveDirection.BACKWARD);
            }else if(i.equals("l") || i.equals("left")) {
                res.add(MoveDirection.LEFT);
            }else if(i.equals("r") || i.equals("right")) {
                res.add(MoveDirection.RIGHT);
            }
        }
        MoveDirection[] fres = new MoveDirection[ res.size() ];
        res.toArray(fres);
        return fres;
    }
}

