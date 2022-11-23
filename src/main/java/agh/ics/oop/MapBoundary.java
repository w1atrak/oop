package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    Map<Vector2d, Animal> animals = new HashMap<>();
    Map<Vector2d, MapObject> mapObjects = new HashMap<>();



    public TreeSet<MapObject> xAxis = new TreeSet<>((m1,m2)->{
        if(m1.getPosition().x != m2.getPosition().x) return m1.getPosition().x-m2.getPosition().x;
        if(m1.getPosition().y != m2.getPosition().y) return m1.getPosition().y-m2.getPosition().y;
        if(m1 instanceof Animal) return 1;
        return -1;
    });
    public TreeSet<MapObject> yAxis = new TreeSet<>((m1,m2)->{
        if(m1.getPosition().y != m2.getPosition().y) return m1.getPosition().y-m2.getPosition().y;
        if(m1.getPosition().x != m2.getPosition().x) return m1.getPosition().x-m2.getPosition().x;
        if(m1 instanceof Animal) return 1;
        return -1;
    });

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(MapObject mapObject : xAxis){
            if(mapObject.getPosition().equals(oldPosition)){
                this.yAxis.remove(mapObject);
                this.xAxis.remove(mapObject);
                this.xAxis.add(new Grass(newPosition));
                this.yAxis.add(new Grass(newPosition));
                break;
            }
        }
    }

}
