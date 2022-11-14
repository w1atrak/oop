package agh.ics.oop;


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

        String[] input = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f",  "f", "f","f","f"}; // (2,0) S  oraz (3,5) N
        if(args.length == 0){
            args = input;
        }

        Map<Vector2d, Animal> ani = new HashMap<>();
        ani.put(new Vector2d(2,3),new Animal(new GrassField(3),new Vector2d(2,3)));
        Animal[] anims = new Animal[1];


        for(var entry : ani.entrySet()){
            anims[0] = entry.getValue();
        }



        // TODO działa ale zwierzęta nie zmieniają pozycji przynajmniej kurwa wizualnie

        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);

        map.place(new Grass(new Vector2d(3,5)));

        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();



        // ./gradlew run --args=" "
    }
}

