package agh.ics.oop;

public class Grass extends MapObject{
    private Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {

        return this.position;
    }

    @Override
    public String toString(){
        return "*";
    }
}
