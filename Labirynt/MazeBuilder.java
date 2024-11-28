public interface MazeBuilder {
    void buildMaze();
    void buildRoom(int roomNr, int x, int y);   // build room with walls
    void buildDoor(int roomOne, int roomTwo);    // make door
    Maze getMaze(); // Return made labirynt
}