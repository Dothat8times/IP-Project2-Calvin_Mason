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
    }
}
