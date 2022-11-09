package agh.ics.oop;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap {
    final int grassPopulation;
    final int width;
    final int height;
    Vector2d lower;
    Vector2d upper;
    ArrayList<Animal> animals = new ArrayList<>();


    public GrassField(int n){
        super((int) Math.sqrt((double)n*10),(int) Math.sqrt((double)n*10));
        this.width = (int) Math.sqrt((double)n*10);
        this.height = this.width;
        this.grassPopulation = n;
        int c = 0;
        this.upper = new Vector2d(0,0);
        this.lower = new Vector2d(this.width, this.width);
        while (c < n){
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
        if(!canMoveTo(mapObject.getPosition()) || isOccupied(mapObject.getPosition())) {
            return false;}
        this.mapObjects.add(mapObject);
        if(mapObject instanceof Animal){
            this.animals.add((Animal) mapObject);
        }
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d position){
        return true;
    }



    @Override
    public String toString(){
        MapVisualizer visual = new MapVisualizer(this);
        for(MapObject mapObject : this.mapObjects){
            this.lower = this.lower.lowerLeft(mapObject.getPosition());
            this.upper = this.upper.upperRight(mapObject.getPosition());
        }
        return visual.draw(this.lower,this.upper);
    }


}
