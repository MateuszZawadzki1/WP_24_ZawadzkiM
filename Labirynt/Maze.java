import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze {
    private ArrayList<Room> rooms = new ArrayList();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomNr (int nr) {
        Iterator<Room> it = rooms.iterator();
        Room r;
        while (it.hasNext()) {
            r = it.next();
            if (r.getRoomNr() == nr) {
                return r;
            }
        }
        return null;
    }

    public void drawMaze(Image image) {
        Room r;
        Iterator<Room> it = rooms.iterator();
        while (it.hasNext()) {
            r = it.next();
            r.draw(image);
        }
    }
}
