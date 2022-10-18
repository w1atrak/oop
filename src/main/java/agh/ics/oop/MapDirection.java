package agh.ics.oop;

enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    STILL;


    public String toString(){
        switch (this) {
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            case WEST: return "Zachód";
            case EAST: return "Wschód";
        }
        return "";
    }
    public MapDirection next(){
        switch (this) {
            case NORTH: return EAST;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            case EAST: return SOUTH;
        }
        return STILL;
    }
    public MapDirection previous(){
        switch (this) {
            case NORTH: return WEST;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            case EAST: return NORTH;
        }
        return STILL;
    }

    public Vector2d toUnitVector(){
        int tx=0;
        int ty=0;
        switch (this) {
            case NORTH: tx = 0; ty = 1;
            case SOUTH: tx = 0; ty = -1;
            case WEST: tx = -1; ty = 0;
            case EAST: tx = 1; ty = 0;
        }


        Vector2d result = new Vector2d(tx,ty);
        return result;
    }

}