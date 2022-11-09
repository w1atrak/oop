package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    public void simulationEngineTest(){
        String[] input = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"}; // (2,0) S  oraz (3,5) N
        MoveDirection[] directions = new OptionsParser().parse(input);
        GrassField     map = new GrassField( 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertFalse(!map.canMoveTo(new Vector2d(11,5)));
        assertTrue(map.isOccupied(new Vector2d(2,-1)));
        assertFalse(map.place(new Animal(map,new Vector2d(2,-1))));
        assertEquals(map.objectAt(new Vector2d(2,-1)),map.animals.get(0));

    }

}