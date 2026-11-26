/**
 * @Author Calvin Bittinger CLIP 77939
 * @Author Mason (*to be filled in*)
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
    private int globalTime;
    private Bike[] ridingBikes;
    private int ridingSize;

    /**
     * Checks every Station in the system and Bikes being ridden to see
     * if a Bike with a matching ID exists
     * @param bikeId: String ID of the Bike to look for
     * @return True if the Bike already exists in the system, false otherwise.
     * @pre none
     */
    public boolean bikeInSystem(String bikeId){
        for(int i = 0; i < stationsSize; i++){
            if(stations[i].hasBike(bikeId)){
                return true;
            }
        }
        for(int i = 0; i < ridingSize; i++){
            if(ridingBikes[i].getId().equals(bikeId)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the index of a station with the matching name provided
     * @param stationName: String of the name of the Station
     * @return Integer value of the index of the Station in stations array.
     * @pre hasStation(stationName) == true
     */
    private int stationIndex(String stationName){
        for(int i = 0;i < stationsSize; i++){
            if(stations[i].getName().equals(stationName)){
                return i;
            }
        }
        //only happens if the precondition is ignored
        return -1;
    }

    /**
     * hasStation checks the stations array for the station with the same name
     * provided in the parameters.
     * @param stationName: String of the name of the Station to be found.
     * @return True if a Station with a matching name exists in the stations array.
     * @pre none
     */
    public boolean hasStation(String stationName){
        for(int i = 0; i < stationsSize; i++){
            if(stations[i].getName().equals(stationName)){
                return true;
            }
        }
        return false;
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
     *
     * @param bikeId
     * @param stationName
     * @pre bikeInSystem(bikeId) == false && hasStation(stationName) == true &&
     * stationIsFull(stationName) == false
     */
    public void addBike(String bikeId, String stationName){

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
        globalTime = 0;
        ridingBikes = new Bike[DEFAULT_CAPACITY];
        ridingSize = 0;
    }
}
