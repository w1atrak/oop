package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap {
    final int grassPopulation;
    final int width;
    final int height;
    Vector2d lower;
    Vector2d upper;



    public GrassField(int n){
        super((int) Math.sqrt((double)n*10),(int) Math.sqrt((double)n*10));
        this.width = (int) Math.sqrt((double)n*10);
        this.height = this.width;

        this.grassPopulation = n;
        int c = 0;
        this.upper = new Vector2d(0,0);
        this.lower = new Vector2d(this.width, this.width);
        while (c < this.grassPopulation){
            int x = (int) (Math.random()*Math.sqrt((double)n*10));
            int y = (int) (Math.random()*Math.sqrt((double)n*10));
            Grass trafka = new Grass(new Vector2d(x,y));
            boolean res = this.place(trafka);
            if(res){
                this.lower = lower.lowerLeft(trafka.getPosition());
                this.upper = upper.upperRight(trafka.getPosition());
                c++;
            }
        }
    }

    @Override
    public boolean place(MapObject mapObject){
        if((!canMoveTo(mapObject.getPosition()) || isOccupied(mapObject.getPosition())) && !this.occupiedByGrass(mapObject.getPosition()) ) {
            return false;}
        this.mapObjects.put(mapObject.getPosition(),mapObject);
        if(mapObject instanceof Animal){
            this.animals.put(mapObject.getPosition(),(Animal) mapObject);
            this.animals.get(mapObject.getPosition()).addObserver(this);
        }
        return true;
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

    public boolean occupiedByGrass(Vector2d position){   // TODO zmienione na wersje ze slownikiem
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
    public boolean canMoveTo(Vector2d position){
        return true;
    }


    @Override
    public String toString(){ //TODO było zmieniane żeby for each działał, chyba działa
        MapVisualizer visual = new MapVisualizer(this);
        for(var entry : this.mapObjects.entrySet()){
            this.lower = this.lower.lowerLeft(entry.getValue().getPosition());
            this.upper = this.upper.upperRight(entry.getValue().getPosition());
        }
        System.out.println(this.animals);
        return visual.draw(this.lower,this.upper);
    }


}
