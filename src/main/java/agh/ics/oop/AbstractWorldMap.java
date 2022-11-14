package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    int width;
    int height;
    Map<Vector2d, MapObject> mapObjects = new HashMap<>();
    Map<Vector2d, Animal> animals = new HashMap<>();


    public AbstractWorldMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition,animal);
        this.mapObjects.remove(oldPosition);
        this.mapObjects.put(newPosition,animal);
    }

    public boolean canMoveTo(Vector2d position){

        //System.out.println(position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height);
        return position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height;
    }

    public boolean isOccupied(Vector2d position){
        return (mapObjects.containsKey(position));  //)  //{
        //    return true;
        //}

        //for (int i = 0; i < mapObjects.size(); i++) {
           // if(this.mapObjects.get(i).getPosition().equals(position)){ return true; }

       // for(MapObject mapObject: this.mapObjects){
        //    if(mapObject.getPosition().equals(position)){ return true; }
        //}
       // return false;
    }

    public boolean place(MapObject mapObject){
        if(!canMoveTo(mapObject.getPosition()) || isOccupied(mapObject.getPosition())) {
            return false;}
        this.mapObjects.put(mapObject.getPosition(),mapObject);
        return true;
    }

    public Object objectAt(Vector2d position){
        if(mapObjects.containsKey(position)) {
            return mapObjects.get(position);
        }
        return null;
    }




}
