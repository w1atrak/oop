package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    int width;
    int height;
    ArrayList<MapObject> mapObjects = new ArrayList<>();

    public AbstractWorldMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){

        //System.out.println(position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height);
        return position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height;
    }

    public boolean isOccupied(Vector2d position){
        for (int i = 0; i < mapObjects.size(); i++) {
            if(this.mapObjects.get(i).getPosition().equals(position)){ return true; }
        }
       // for(MapObject mapObject: this.mapObjects){
        //    if(mapObject.getPosition().equals(position)){ return true; }
        //}
        return false;
    }

    public boolean place(MapObject mapObject){
        if(!canMoveTo(mapObject.getPosition()) || isOccupied(mapObject.getPosition())) {
            return false;}
        this.mapObjects.add(mapObject);
        return true;
    }

    public Object objectAt(Vector2d position){
        for(MapObject mapObject: this.mapObjects){
            if(mapObject.getPosition().equals(position)){ return mapObject; }
        }
        return null;
    }

    public boolean placeGrass(){
        while (true){
            int x = (int) (Math.random()*(this.width+1));
            int y = (int) (Math.random()*(this.height+1));
            Grass trafka = new Grass(new Vector2d(x,y));
            boolean res = this.place(trafka);
            if (res){ return true; }
        }
    }

    public boolean occupiedByGrass(Vector2d position){
        for (int i = 0; i < this.mapObjects.size(); i++) {
            if(this.mapObjects.get(i).getPosition().equals(position) && this.mapObjects.get(i) instanceof Grass) {
                this.mapObjects.remove(i);
                this.placeGrass();
                return true;
            }
        }
        return false;
    }

}
