package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap {
    final int grassPopulation;
    final int width;
    final int height;
    Vector2d lower;
    Vector2d upper;
    MapBoundary boundary;

    public MapBoundary getBoundary(){
        return this.boundary;
    }

    public GrassField(int n){
        super((int) Math.sqrt((double)n*10),(int) Math.sqrt((double)n*10));
        this.width = (int) Math.sqrt((double)n*10);
        this.height = this.width;
        this.boundary = new MapBoundary();
        this.grassPopulation = n;
        int c = 0;
        this.upper = new Vector2d(0,0);
        this.lower = new Vector2d(this.width, this.width);
        while (c < this.grassPopulation){  //TODO powielenie kodu z placeGrass
            int x = (int) (Math.random()*Math.sqrt((double)n*10));
            int y = (int) (Math.random()*Math.sqrt((double)n*10));
            Grass trafka = new Grass(new Vector2d(x,y));
            boolean res = this.place(trafka);
            if(res){
                this.boundary.xAxis.add(trafka);
                this.boundary.yAxis.add(trafka);
                c++;
            }
        }
    }

    @Override
    public boolean place(MapObject mapObject){
        if((!canMoveTo(mapObject.getPosition()) || isOccupied(mapObject.getPosition())) && !this.occupiedByGrass(mapObject.getPosition()) ) {
            if(mapObject instanceof Animal){
                throw new IllegalArgumentException(mapObject.getPosition().toString() + " isn't a valid position to place an object");
            }
            return false;}
        this.mapObjects.put(mapObject.getPosition(),mapObject);
        if(mapObject instanceof Animal){
            this.animals.put(mapObject.getPosition(),(Animal) mapObject);
            this.animals.get(mapObject.getPosition()).addObserver(this);
        }
        this.boundary.xAxis.add(mapObject);
        this.boundary.yAxis.add(mapObject);
        return true;
    }
    public boolean placeGrass(){
        while (true){
            int x = (int) (Math.random()*(this.width+1));
            int y = (int) (Math.random()*(this.height+1));
            Grass trafka = new Grass(new Vector2d(x,y));
            boolean res = this.place(trafka);
            if (res){
                this.boundary.yAxis.add(trafka);
                this.boundary.xAxis.add(trafka);
                return true; }
        }
    }

    public boolean occupiedByGrass(Vector2d position){   //
        if(this.mapObjects.containsKey(position) && this.mapObjects.get(position) instanceof Grass){
            this.mapObjects.remove(position);
            this.placeGrass();
            return true;
        }
        return false;

       // for (int i = 0; i < this.mapObjects.size(); i++) {
         //   if(this.mapObjects.get(i).getPosition().equals(position) && this.mapObjects.get(i) instanceof Grass) {
           //     this.mapObjects.remove(i);
             //   this.placeGrass();
               // return true;
            //}
       // }
       // return false;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition,newPosition);
        this.boundary.positionChanged(oldPosition,newPosition);
    }

        @Override
    public boolean canMoveTo(Vector2d position){
        return true;
    }


    public Vector2d getLowerLeft(){
        return new Vector2d(this.boundary.xAxis.first().getPosition().x,this.boundary.yAxis.first().getPosition().y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(this.boundary.xAxis.last().getPosition().x,this.boundary.yAxis.last().getPosition().y);
    }
    @Override
    public String toString(){ //
        MapVisualizer visual = new MapVisualizer(this);
        //for(var entry : this.mapObjects.entrySet()){
          //  this.lower = this.lower.lowerLeft(entry.getValue().getPosition());
            //this.upper = this.upper.upperRight(entry.getValue().getPosition());
        //}
        return visual.draw(getLowerLeft(), getUpperRight());
    }


}
