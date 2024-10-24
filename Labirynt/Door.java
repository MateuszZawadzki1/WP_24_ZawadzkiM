public class Door extends MapSite {
    

    public Door (this.room1, this.room2, bool isOpen) {
        super(-1, -1); // współrzedne nieokreślone
        this.room1 = room1;
        this.room2 = room2;
        this.isOpen = isOpen;
    }

    private Room room1;
    private Room room2;
    
    private boolean isOpen = true;

    
}
