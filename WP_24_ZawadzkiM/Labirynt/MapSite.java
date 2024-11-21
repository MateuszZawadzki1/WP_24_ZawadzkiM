import java.awt.Image;

enum Directions {
    NORTH, SOUTH, EAST, WEST
};

public abstract class MapSite {
    private int x, y; // wspolrzedne
    public final static int lenght = 50; // rozmiar sciany

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int setX(int a) {
        return x = a;
    }

    public int setY(int b) {
        return y = b;
    }

    /**
     * Rysuje element labiryntu
     * 
     * @param image - obiekt na którym rysujemy
     */
    public void draw(Image image) {

    }
}