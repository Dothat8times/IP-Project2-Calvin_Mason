public class Bike {
    private int id;
    private int battery;
    private boolean inUse;

    public Bike(int id) {
        this.id = id;
        battery = 100;
        inUse = false;
    }

    public int getBattery() {
        return battery;
    }

    public int getId() {
        return id;
    }

    public boolean isInUse() {
        return inUse;
    }
}
