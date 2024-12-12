import java.awt.Graphics;
import java.awt.Image;

public class BombedWall extends Wall {
// Implementacja metody setDamage(true), sciana  bedzie rysowana jako uszkodzona
    public BombedWall(int x, int y, Directions d){
        super(x, y, d);
    }

    public void setDamage(boolean dmg) {

    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();
        int jump = MapSite.lenght/5;

        Graphics g = image.getGraphics(); // zwraca kontekst grafiki

        switch (getDirection()) {
            case NORTH, SOUTH:
                g.drawLine(x+jump, y, (x + jump) + jump, y); // ściana pozioma uszkodzona
                g.drawLine((x + jump) + jump+jump, y, (x + jump) + jump+jump+jump, y);
                break;

            default:
                g.drawLine(x, y+jump, x, y+y+jump); // ściana pionowa uszkodzona
                g.drawLine(x, (y+jump)+jump+jump, x, (y+jump)+jump+jump+jump);
                break;
        }
    }
    
}
