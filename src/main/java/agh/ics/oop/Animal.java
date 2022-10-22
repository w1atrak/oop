package agh.ics.oop;

public class Animal {
    private MapDirection oriented = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOriented() {
        return this.oriented;
    }

    public Animal(){
    }

    @Override
    public String toString(){
        return "Oriented " + String.valueOf(oriented) + " at " + position.toSstring() ;
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
            this.position =  this.position.add(this.oriented.toUnitVector());
        } else if (direction == MoveDirection.BACKWARD) {
            this.position = this.position.add((this.oriented.toUnitVector()).opposite());
        }

        if(this.position.x>4 || this.position.y>4 || this.position.x<0 || this.position.y<0){ this.position = tmp; }
    }

}
