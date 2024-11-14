import java.awt.Image;

public class Room extends MapSite {
    private MapSite[] sides = new MapSite[4];
    private int nr;

    public Room(int x, int y, int roomNr){
        super(x, y);
        nr = roomNr;
    }


    public void setSite(Directions d, MapSite mapsite){
        switch (d){
            case NORTH, WEST:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX());
                    mapsite.setY(getY());
                }
                if (d == d.NORTH) {
                    sides[0] = mapsite; 
                } else {
                    sides[3] = mapsite;
                }
                break;
            case SOUTH:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX());
                    mapsite.setY(getY() + lenght);                    
                }
                sides[2] = mapsite;
                break;
            case EAST:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX() + lenght);
                    mapsite.setY(getY());
                }
                sides[1] = mapsite;
                break;
            default:
            break;
        }
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapSite : sides) {
            if (mapSite != null)
                mapSite.draw(image);
        }
    }
}