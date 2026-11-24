public class Station {

    private String name;
    private int capacity;
    private Bike[] dock;

    public Station(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        dock = new Bike[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}
