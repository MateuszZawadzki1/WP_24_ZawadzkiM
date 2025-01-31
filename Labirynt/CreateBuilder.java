public class CreateBuilder implements MazeBuilder{
    private Maze maze;

    public CreateBuilder() {
        maze = new Maze();
    }

    public Directions commonWall(Room room1, Room room2) {
        if (room1.getX() == room2.getX()) {
            if (room1.getY() < room2.getY()) {
                return Directions.SOUTH;
            } else {
                return Directions.NORTH;
            }
        } else {
            if (room1.getX() < room2.getX()) {
                return Directions.EAST;
            } else {
                return Directions.WEST;
            }
        }
    }

    @Override
    public void buildMaze() {
        maze = new Maze();
    }

    @Override
    public void buildRoom(int roomNr, int x, int y) {
        Room r = new Room(x, y, roomNr);
        r.setSite(Directions.NORTH, new Wall(Directions.NORTH));
        r.setSite(Directions.EAST, new Wall(Directions.EAST));
        r.setSite(Directions.WEST, new Wall(Directions.WEST));
        //r.setSite(Directions.SOUTH, new Wall(Directions.SOUTH));
        r.setSite(Directions.SOUTH, new BombedWall(x, y, Directions.SOUTH, true));  // TEST BOMBEDWALL
        maze.addRoom(r);
    }

    @Override
    public void buildDoor(int nrOne, int nrTwo) {
        Room roomOne = maze.getRoomNr(nrOne);
        Room roomTwo = maze.getRoomNr(nrTwo);

        Door door = new Door(roomOne, roomTwo, true);

        roomOne.setSite(commonWall(roomOne, roomTwo), door);
        roomTwo.setSite(commonWall(roomTwo, roomOne), door);
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
    
}
