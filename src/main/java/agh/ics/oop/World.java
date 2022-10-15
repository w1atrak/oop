package agh.ics.oop;
import static java.lang.System.out;

public class World{
    public static void run(Direction[] arr){

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

    public static Direction[] convert(String[] args){
        Direction[] res = new Direction[args.length];
        int i = 0;
        for(String arg: args){
            Direction direction = switch (arg){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.STILL;
            };

            res[i] = direction;
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        out.println("Start");



        Direction[] instructions = convert(args);
        run(instructions);

        out.println("Stop");
    }
}