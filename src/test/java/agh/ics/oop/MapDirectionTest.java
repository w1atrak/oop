package agh.ics.oop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {
    @Test
    public void testNext(){
        MapDirection tmp = MapDirection.NORTH;
        Assertions.assertTrue((tmp.next() == MapDirection.EAST));

        tmp = MapDirection.EAST;
        Assertions.assertSame(tmp.next(), MapDirection.SOUTH);

        tmp = MapDirection.SOUTH;
        Assertions.assertSame(tmp.next(), MapDirection.WEST);

        tmp = MapDirection.WEST;
        Assertions.assertSame(tmp.next(), MapDirection.NORTH);

    }
}
