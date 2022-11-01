package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    final int width;
    final int height;
    public ArrayList<Animal> animals = new ArrayList<>();


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){
        return position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height;
    }

    public boolean isOccupied(Vector2d position){
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)){ return true; }
        }
        return false;
    }

    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()) || isOccupied(animal.getPosition())) {return false;}

        this.animals.add(animal);
        return true;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)){ return animal; }
        }
        return null;
    }

    @Override
    public String toString(){
        Vector2d lower = new Vector2d(0,0);
        Vector2d upper = new Vector2d(this.width, this.height);
        MapVisualizer visual = new MapVisualizer(this);
        return visual.draw(lower,upper);


    }


}
