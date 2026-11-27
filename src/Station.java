/**
 * @Author Calvin Bittinger CLIP 77939
 * @Author Mason (*to be filled in*)
 * @Overview: The Station class manages a static capacity of Bikes.
 * Each Station has its own unique name and Bikes within the station remain sorted.
 */
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
     * (for definition of "smaller" and "larger" Bikes
     * see the Bike compareTo method)
     * @pre none
     */
    private void sortBikes(){
        for(int i = 0; i < dockSize-1; i++){
            int smallestIndex = findSmallestIndex(i,dockSize);
            swapBikes(i,smallestIndex);
        }
    }

    /**
     * Finds the index of the smallest Bike in the dock array from positions start -> end
     * @param start: starting position in array (inclusive)
     * @param end: ending position in array (exclusive)
     * @return The index of the "smallest" bike in the array within the given range
     * @pre start >= 0 and end <= dockSize and end > start
     */
    private int findSmallestIndex(int start, int end){
        Bike smallestBike = dock[start];
        int smallestIndex = start;
        for(int i = start+1; i < end; i++){
            if(smallestBike.compareTo(dock[i]) > 0){
                smallestBike = dock[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * Swaps two Bikes in the dock array at positions firstIndex and secondIndex
     * @param firstIndex: index of one of the Bikes to swap
     * @param secondIndex: index of the other Bike to swap
     * @pre both firstIndex and secondIndex >= 0 and < dockSize
     */
    private void swapBikes(int firstIndex, int secondIndex){
        Bike tempBike = dock[firstIndex];
        dock[firstIndex] = dock[secondIndex];
        dock[secondIndex] = tempBike;
    }

    /**
     * Checks all currently docked Bikes to see if any match the ID provided
     * @param bikeId: String of the Bikes ID
     * @return: True if the bike exists in the dock, false otherwise
     * @pre none
     */
    public boolean hasBike(String bikeId){
        boolean found = false;
        int index = 0;
        do{
            if(dock[index].getId().equals(bikeId)){
                found = true;
            }
        }while(!found && index < dockSize);
        return found;
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
        dock[dockSize] = new Bike(bikeId);
        dockSize++;
        sortBikes();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}
