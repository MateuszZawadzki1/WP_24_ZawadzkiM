public class BombedMazeFactory {
    /*Tworzy labirynt, zawierajacy bomby w pokojach oraz sciany po zniszczeniu */
    public Wall makeWall(int x, int y, Directions d){
        return new BombedWall(x, y, d);
    }

    Room makeRoom(int n) {
        return new RoomWithABomb(n);
    }
}
