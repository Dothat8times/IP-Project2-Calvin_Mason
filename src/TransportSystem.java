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
