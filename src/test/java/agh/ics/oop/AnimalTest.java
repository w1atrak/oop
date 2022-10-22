package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AnimalTest {
    @Test
    public void AnimalTesting(){
        Animal zwierze = new Animal();
        OptionsParser pars = new OptionsParser();

        String[] input = {"l","f","forward","g","ge","f","f","backward","r","right"}; // (1,2) east
        MoveDirection[] expectedDir = {MoveDirection.LEFT,MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT};
        MoveDirection[] directives = pars.parse(input);

        Assertions.assertArrayEquals(expectedDir, directives);

        for(MoveDirection i : directives){
            Vector2d position = zwierze.getPosition();
            Assertions.assertFalse(position.x < 0 || position.x > 4 || position.y < 0 || position.y > 4 );
            zwierze.move(i);
        }

        Assertions.assertTrue(zwierze.getPosition().x==1 && zwierze.getPosition().y==2);
        Assertions.assertSame(zwierze.getOriented(), MapDirection.EAST);

    }
}
