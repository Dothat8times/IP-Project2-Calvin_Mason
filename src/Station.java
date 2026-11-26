public class Station {

    private String name;
    private int capacity;
    private Bike[] dock;
    private int dockSize;

    public Station(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        dock = new Bike[capacity];
        dockSize = 0;
    }

    /**
     * Sorts the dock array of Bikes from smallest -> largest
     * @pre none
     */
    private void sortBikes(){
        for(int i = 1; i < dockSize; i++){

        }
    }

    /**
     * Checks all currently docked Bikes to see if any match the ID provided
     * @param bikeId: String of the Bikes ID
     * @return: True if the bike exists in the dock, false otherwise
     * @pre none
     */
    public boolean hasBike(String bikeId){
        for(int i = 0; i < dockSize; i++){
            if(dock[i].getId().equals(bikeId)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the Station has any available space in dock
     * @return True if the Station is full, false otherwise
     * @pre none
     */
    public boolean isFull(){
        return dockSize == capacity;
    }

    /**
     * Adds a new Bike to the Station
     * @param bikeId
     * @pre isFull() == false
     */
    public void addBike(String bikeId){

    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}
