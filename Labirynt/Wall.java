import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(Directions d) {
        super(-1, -1);
        direction = d;
    }


    public Wall(int x, int y, Directions d) {
        super(x, y);
        direction = d;
    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();

        Graphics g = image.getGraphics(); // zwraca kontekst grafiki

        switch (direction) {
            case NORTH, SOUTH:
                g.drawLine(x, y, x + MapSite.lenght, y); // ściana pozioma
                break;

            default:
                g.drawLine(x, y, x, y + MapSite.lenght); // ściana pionowa
                break;
        }
    }

}
