
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {

    protected Room roomOne;
    protected Room roomTwo;
    protected boolean isOpen = true;

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

        if (y1 == y2) { // Rooms are horizontally aligned (poziomo)
            int x = Math.max(x1, x2);
            int startY = y1;
            int endY = startY + MapSite.lenght;

            g.drawLine(x, startY, x, startY + (MapSite.lenght - doorLength)/2);
            g.drawLine(x, endY - (MapSite.lenght - doorLength) / 2, x, endY);

        } else if (x1 == x2) { // Rooms are vertically aligned (pionowo)
            int y = Math.max(y1, y2); // X-koordynata jest taka sama dla obu pokoi
            int startX = x1; // Zaczynamy od górnego pokoju
            int endX = startX + MapSite.lenght;
            g.drawLine(startX, y, startX + (MapSite.lenght - doorLength) / 2, y);
            g.drawLine(endX - (MapSite.lenght - doorLength) /2, y, endX, y);
        }
        System.out.println("Door between rooms: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");

    }
}