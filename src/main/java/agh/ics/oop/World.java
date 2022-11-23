package agh.ics.oop;


import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;


public class World{
    public static void run(MoveDirection[] arr){

        for (int i = 0; i < arr.length; i++) {
            String message = switch (arr[i]){
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tylu";
                case LEFT -> "W lewo";
                case RIGHT -> "W prawo";

                default -> "";
            };
            if(message.equals("")){ continue; }
            out.println(message);
        }
    }

    public static MoveDirection[] convert(String[] args){
        MoveDirection[] res = new MoveDirection[args.length];
        int i = 0;
        for(String arg: args){
            MoveDirection Movedirection = switch (arg){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> MoveDirection.STILL;
            };

            res[i] = Movedirection;
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        try {

            //engine.run();

            Application.launch(App.class,args);

        }catch (IllegalArgumentException ex){
            out.println(ex);
        }




        // ./gradlew run --args=" "
    }
}

