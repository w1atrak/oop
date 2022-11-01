package agh.ics.oop;
import java.util.SplittableRandom;
import java.util.Vector;
import javax.swing.*;

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

        String[] input = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"}; // (2,0) S  oraz (3,5) N


        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        //System.out.println(map.toString());




        // ./gradlew run --args=" "
    }
}

