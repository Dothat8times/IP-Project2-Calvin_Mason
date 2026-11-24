public class BikeIterator {
    private Bike[] bikes;
    private int nextBike;
    private int numBikes;
    public BikeIterator(Bike[] bikes) {
        this.bikes = bikes;
        nextBike = 0;
        numBikes = bikes.length;

    }
    public boolean hasNext() {
        return nextBike < numBikes;
    }
    public Bike next() {
        return bikes[nextBike++];
    }
}
