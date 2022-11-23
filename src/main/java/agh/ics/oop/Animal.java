package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends MapObject{
    private MapDirection oriented = MapDirection.NORTH;
    private Vector2d position;

    GrassField map;

    ArrayList<IPositionChangeObserver> observers = new ArrayList<>();


    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOriented() {
        return this.oriented;
    }

    public  Animal(GrassField map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        for (int i = 0; i < this.observers.size(); i++) {
            if (this.observers.get(i).equals(observer)){
                this.observers.remove(i);
                break;
            }
        }
    }

    void positionChanged(Vector2d oldPos, Vector2d newPos){
        for(IPositionChangeObserver observer : this.observers){
            observer.positionChanged(oldPos,newPos);
        }
    }

    @Override
    public String toString(){
        return (String.valueOf(oriented)).substring(0,1);
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    public void move(MoveDirection direction){
        Vector2d tmp = new Vector2d(this.position.x,this.position.y);

        if (direction==MoveDirection.RIGHT){
            this.oriented = this.oriented.next();
        } else if (direction == MoveDirection.LEFT) {
            this.oriented = this.oriented.previous();
        } else if (direction == MoveDirection.FORWARD) {
            tmp = tmp.add(this.oriented.toUnitVector());
        } else if (direction == MoveDirection.BACKWARD) {
            tmp = tmp.add((this.oriented.toUnitVector()).opposite());
        }
        if( (this.map.canMoveTo(tmp) && !this.map.isOccupied(tmp)) || map.occupiedByGrass(tmp) ){
            this.positionChanged(this.position,tmp);
            this.position = tmp;
        }
    }

}
