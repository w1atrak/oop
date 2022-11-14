package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AnimalTest {
    @Test
    public void AnimalTesting(){
        Animal zwierze = new Animal(new GrassField(5),new Vector2d(2,2));
        OptionsParser pars = new OptionsParser();

        String[] input = {"l","f","forward","g","ge","f","f","backward","r","right"}; // (1,2) east
        MoveDirection[] expectedDir = {MoveDirection.LEFT,MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT};
        MoveDirection[] directives = pars.parse(input);

        Assertions.assertArrayEquals(expectedDir, directives);





    }
}
