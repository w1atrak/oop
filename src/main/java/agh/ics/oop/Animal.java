package agh.ics.oop;

public class Animal extends MapObject{
    private MapDirection oriented = MapDirection.NORTH;
    private Vector2d position;

    AbstractWorldMap map;


    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOriented() {
        return this.oriented;
    }

    public  Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
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
        if( (this.map.canMoveTo(tmp) && !this.map.isOccupied(tmp)) || map.occupiedByGrass(tmp) ){ this.position = tmp; }
        //&& !(tmp.x>map.width || tmp.y>map.height || tmp.x<0 || tmp.y<0)
    }

}
