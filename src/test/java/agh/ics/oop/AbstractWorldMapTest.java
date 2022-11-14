package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {

    @Test
    void canMoveTo() {
        RectangularMap rmap = new RectangularMap(10,10);
        Assertions.assertFalse(rmap.canMoveTo(new Vector2d(11,10)));
        GrassField gmap = new GrassField(3);
        Assertions.assertTrue(gmap.canMoveTo(new Vector2d(1030,1030)));
    }

    @Test
    void place() {
        GrassField map = new GrassField(5);
        Animal animal = new Animal(map, new Vector2d(2,3));
        map.place(animal);
        assertEquals(map.animals.get(0), animal);
    }

    @Test
    void isOccupied() {
        GrassField gmap = new GrassField(5);
        RectangularMap rmap = new RectangularMap(10,10);
        rmap.place(new Animal(gmap,new Vector2d(2,2)));
        Assertions.assertTrue(rmap.isOccupied(new Vector2d(2,2)));
        gmap.place(new Grass(new Vector2d(2,2)));
        Assertions.assertTrue(gmap.isOccupied(new Vector2d(2,2)));
    }


}