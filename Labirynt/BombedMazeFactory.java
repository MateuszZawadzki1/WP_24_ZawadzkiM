public class BombedMazeFactory {
    /*Tworzy labirynt, zawierajacy bomby w pokojach oraz sciany po zniszczeniu */
    public Wall makeWall(){
        return BombedWall;
    }

    Room makeRoom(int n) {
        return new RoomWithABomb(n);
    }
}
