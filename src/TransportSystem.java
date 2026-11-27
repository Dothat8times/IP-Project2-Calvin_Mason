/**
 * @Author Calvin Bittinger CLIP 77939
 * @Author Mason Brown CLIP 76851
 * @Overview: TransportSystem manages Users, Stations and Bikes within Stations.
 *
 */
public class TransportSystem {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 2;

    private Station[] stations;
    private int stationsSize;
    private User[] users;
    private int usersSize;
    private int lastRegisteredTime;
    private Bike[] ridingBikes;
    private int ridingSize;


    /**
     * Retrieves the index of a station with the matching name provided
     * @param stationName: String of the name of the Station
     * @return Integer value of the index of the Station in stations array.
     * @pre hasStation(stationName) == true
     */
    private int stationIndex(String stationName){
        int index = 0;
        boolean found = false;
        do{
            if(stations[index].getName().equals(stationName)){
                found = true;
                index--;
            }
            index++;
        }while(!found && index < stationsSize);
        return index;
    }

    /**
     * Checks the array of Stations to see if it is full.
     * @return True if the station is full, false otherwise.
     * @pre none
     */
    private boolean stationsIsFull(){
        return stationsSize == stations.length;
    }

    /**
     * Increments the size of the stations array by the GROWTH_FACTOR so that
     * more Stations can be added.
     * @pre none
     */
    private void growStations(){
        Station[] temp = new Station[stations.length*GROWTH_FACTOR];
        for(int i = 0; i < stationsSize; i++){
            temp[i] = stations[i];
        }
        stations = temp;
    }

    /**
     * Checks every Station in the system and Bikes being ridden to see
     * if a Bike with a matching ID exists
     * @param bikeId: String ID of the Bike to look for
     * @return True if the Bike already exists in the system, false otherwise.
     * @pre none
     */
    public boolean hasBikeInSystem(String bikeId){
        boolean found = false;
        int index = 0;
        do{
            if(stations[index].hasBike(bikeId)){
                found = true;
            }
            index++;
        }while(!found && index < stationsSize);
        index = 0;
        while(!found && index < ridingSize){
            if(ridingBikes[index].getId().equals(bikeId)){
                found = true;
            }
            index++;
        }
        return found;
    }

    /**
     * hasStation checks the stations array for the station with the same name
     * provided in the parameters.
     * @param stationName: String of the name of the Station to be found.
     * @return True if a Station with a matching name exists in the stations array.
     * @pre none
     */
    public boolean hasStation(String stationName){
        boolean found = false;
        int index = 0;
        do{
            if(stations[index].getName().equals(stationName)){
                found = true;
            }
            index++;
        }while(!found && index < stationsSize);
        return found;
    }

    /**
     * Checks an individual Station in the system to see if it is at capacity.
     * @param stationName: Name of the Station being checked.
     * @return True if the Station is full, false otherwise.
     * @pre hasStation(stationName) == true
     */
    public boolean stationIsFull(String stationName){
        return stations[stationIndex(stationName)].isFull();
    }

    /**
     * Adds a new Station to the system with the name stationName and capacity slots for bikes
     * @param stationName: String name of the new Station
     * @param capacity: Integer maximum amount of Bikes the station can hold
     * @pre hasStation(stationName) == false && capacity > 0
     */
    public void addStation(String stationName, int capacity){
        if(stationsIsFull()){
            growStations();
        }
        stations[stationsSize] = new Station(stationName, capacity);
        stationsSize++;
    }

    /**
     * Adds a new Bike in to the Station with name stationName.
     * @param bikeId: String name of the new Bike's desired id.
     * @param stationName: String name of the Station where the Bike is to be added.
     * @pre bikeInSystem(bikeId) == false && hasStation(stationName) == true &&
     * stationIsFull(stationName) == false
     */
    public void addBike(String bikeId, String stationName){
        stations[stationIndex(stationName)].addBike(bikeId);
    }

    /**
     * A TransportSystem manages Users, Stations, and the Bikes within those Stations.
     * At default, there are no Stations, Users or Bikes and Time is 0.
     */
    public TransportSystem(){
        stations = new Station[DEFAULT_CAPACITY];
        stationsSize = 0;
        users = new User[DEFAULT_CAPACITY];
        usersSize = 0;
        lastRegisteredTime = 0;
        ridingBikes = new Bike[DEFAULT_CAPACITY];
        ridingSize = 0;
    }

    public void addUser(String name, int balance) {
        if (usersSize < DEFAULT_CAPACITY) {
            users[usersSize] = new User(name, balance);
            usersSize++;
        }
        else {
            User[] newList = new User[users.length+1];
            for (int i=0;i<users.length;i++) {
                newList[i] = users[i];
            }
            newList[users.length] = new User(name, balance);
            users = newList;
        }
    }
    public boolean userAlreadyExists(String username) {
        if (usersSize == 0) {
            return false;
        }
        boolean found = false;
        int i = 0;
        do {
            found = users[i].getName().equals(username);
            i++;
        } while (!found && i<usersSize);
        return found;
    }
}
