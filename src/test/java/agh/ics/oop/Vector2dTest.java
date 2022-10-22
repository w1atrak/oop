package agh.ics.oop;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class Vector2dTest {
    @Test
    public void test_equals(){
        Vector2d tmp = new Vector2d(2,2);
        Assertions.assertFalse(tmp.equals(5));
        Assertions.assertTrue(tmp.equals(tmp));
        Vector2d tmp2 = new Vector2d(2,2);
        Assertions.assertTrue(tmp.equals(tmp2));
        Vector2d tmp3 = new Vector2d(14,2);
        Assertions.assertFalse(tmp.equals(tmp3));
    }

    @Test
    public void test_toString(){
        Vector2d tmp = new Vector2d(2,3);
        Assertions.assertTrue(tmp.toSstring().equals("(2,3)"));
    }

    @Test
    public void test_precedes(){
        Vector2d tmp = new Vector2d(2,3);

        Assertions.assertTrue(tmp.precedes(tmp));
        Vector2d tmp2 = new Vector2d(12,3);
        Assertions.assertTrue(tmp.precedes(tmp2));
        Vector2d tmp3 = new Vector2d(2,13);
        Assertions.assertTrue(tmp.precedes(tmp3));

        Assertions.assertFalse(tmp2.precedes(tmp));
        Assertions.assertFalse(tmp3.precedes(tmp));
    }

    @Test
    public void test_follows(){
        Vector2d tmp = new Vector2d(2,3);

        Assertions.assertTrue(tmp.follows(tmp));
        Vector2d tmp2 = new Vector2d(12,3);
        Assertions.assertFalse(tmp.follows(tmp2));
        Vector2d tmp3 = new Vector2d(2,13);
        Assertions.assertFalse(tmp.follows(tmp3));

        Assertions.assertTrue(tmp2.follows(tmp));
        Assertions.assertTrue(tmp3.follows(tmp));

    }

    @Test
    public void test_upperRight(){
        Vector2d t1 = new Vector2d(1,2);
        Vector2d t2 = new Vector2d(30,-50);

        Vector2d res = t1.upperRight(t2);
        Assertions.assertTrue(res.x==30&&res.y==2);
    }

    @Test
    public void test_lowerLeft(){
        Vector2d t1 = new Vector2d(1,2);
        Vector2d t2 = new Vector2d(30,-50);

        Vector2d res = t1.lowerLeft(t2);
        Assertions.assertTrue(res.x==1&&res.y==-50);
    }

    @Test
    public void test_add(){
        Vector2d tmp = new Vector2d(10,10);
        Vector2d tmp2 = new Vector2d(21,21);
        Vector2d res = tmp.add(tmp2);
        Assertions.assertTrue(res.x==31&&res.y==31);

    }

    @Test
    public void test_subtract(){
        Vector2d tmp = new Vector2d(10,10);
        Vector2d tmp2 = new Vector2d(21,21);
        Vector2d res = tmp.subtract(tmp2);
        Assertions.assertTrue(res.x==-11&&res.y==-11);
    }

    @Test
    public void test_opposite(){
        Vector2d tmp = new Vector2d(10,-10);
        Vector2d res = tmp.opposite();
        Assertions.assertTrue(res.x==-tmp.x&&res.y==-tmp.y);

    }
}
