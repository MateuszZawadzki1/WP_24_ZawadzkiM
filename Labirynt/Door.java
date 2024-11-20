
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {

    private Room roomOne;
    private Room roomTwo;
    private boolean isOpen = true;

    public Door(Room roomOne, Room roomTwo, boolean isOpen) {
        super(-1, -1); // współrzedne nieokreślone
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
        this.isOpen = isOpen;
    }

    @Override
    public void draw(Image image) {
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        Graphics g = image.getGraphics();
        int doorLength = MapSite.lenght / 3;

        if (x1 == x2) {     // Rooms are horizontally
            int y = Math.min(y1, y2);
            int startX = x1;
            int endX = startX + MapSite.lenght;


            g.drawLine(startX, y, startX + (MapSite.lenght - doorLength)/2, y);
            g.drawLine(endX - (MapSite.lenght - doorLength) / 2, y, endX, y);
        } else {  // Rooms are vertically
            int x = Math.min(x1, x2) + MapSite.lenght; 
            int startY = y1;
            int endY = startY + MapSite.lenght;
    
            g.drawLine(x, startY, x, startY + (MapSite.lenght - doorLength) / 2); 
            g.drawLine(x, endY - (MapSite.lenght - doorLength) / 2, x, endY); 
        }
    }
}
