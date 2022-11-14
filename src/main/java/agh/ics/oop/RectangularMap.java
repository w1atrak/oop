package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap{
    final int width;
    final int height;

    public RectangularMap(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }


    @Override
    public String toString(){
        Vector2d lower = new Vector2d(0,0);
        Vector2d upper = new Vector2d(this.width, this.height);
        MapVisualizer visual = new MapVisualizer(this);
        return visual.draw(lower,upper);


    }


}
