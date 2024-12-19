import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class MagicDoor extends Door{
    // Uaktywnianie czaru, przechodzenie przez drzwi odpala czar, drzwi sa zamkniete
    // Mozna je odczarowac
    // Rysuje symbol przy drzwiach(?)

    public MagicDoor(Room roomOne, Room roomTwo, boolean isOpen){
        super(roomOne, roomTwo, isOpen);
        this.isOpen = false;
    }
    
    @Override
    public void draw(Image image) {
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        Graphics g = image.getGraphics();
        int doorLength = MapSite.lenght / 3;

        g.setColor(Color.RED); // Change color for cursed door

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
