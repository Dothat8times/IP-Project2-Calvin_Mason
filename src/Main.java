/**
 * @Author Calvin Bittinger CLIP 77939
 * @Author Mason (*TO BE FILLED IN*)
 */

import java.util.Scanner;
public class Main {
    private static final String EXIT_CMD = "exit";
    private static final String INSTALL_CMD = "install";
    private static final String ADD_CMD = "add";
    private static final String REGISTER_CMD = "register";
    private static final String PICKUP_CMD = "pickup";
    private static final String RETURN_CMD = "return";
    private static final String STATION_CMD = "station";
    private static final String PAY_CMD = "pay";
    private static final String TOP_CMD = "top";
    private static final String INVALID_CMD_REPLY = "Invalid command.%n";
    private static final String EXIT_REPLY = "Application exited.%n";
    private static final String STATION_ALREADY_EXISTS = "Station %s already exists.%n";
    private static final String INVALID_CAPACITY = "Station %s cannot be created with %d docking stations.%n";
    private static final String INSTALL_REPLY = "Station %s is available with %d docking stations.%n";
    private static final String BIKE_ALREADY_EXISTS = "Bike %d already exists.%n";
    private static final String STATION_NOT_FOUND = "Station %s not found.%n";
    private static final String NO_DOCK_AVAILABLE = "Station %s does not have available docks.%n";
    private static final String ADD_REPLY = "Station %s now has a bike %d in one of its docking stations.%n";
    private static final String USER_ALREADY_REGISTERED = "User %s already registered.%n";
    private static final String REGISTER_REPLY = "User %s successfully registered with balance %2f euros.%n";
    private static final String USER_NOT_REGISTERED = "User %s not registered.%n";
    private static final String USER_ALREADY_RIDING = "User %s already riding.%n";
    private static final String INSUFFICIENT_BALANCE = "Insufficient balance.%n";
    private static final String NO_BIKE_AVAILABLE = "No bike available.%n";
    private static final String PICKUP_REPLY = "Bike %d unlocked.%n";
    private static final String USER_NOT_RIDING = "User %s is not riding.%n";
    private static final String STATION_FULL = "Station %s is full.%n";
    private static final String RETURN_REPLY = "Cost: %f euros.%n";
    private static final String STATION_HAS_NO_BIKES = "Station %s has no bikes.%n";
    private static final String STATION_REPLY = "%s: %d/%d docks occupied.\n %d, %d%%.\n %d, %d%%.%n";
    private static final String INVALID_AMOUNT = "Invalid amount %f euros.%n";
    private static final String PAY_REPLY = "%s has a balance of %f euros.%n";
    private static final String NO_TRIPS_REGISTERED = "No trips registered.%n";
    private static final String TOP_REPLY = "%s, %d, $d minutes.%n";

    /**
     *
     * @param in
     */
    private static void runInstallCommand(Scanner in){
        String stationName = in.next();
        int stationCapacity = in.nextInt();
        if(TransportSystem.hasStation()){
            System.out.printf(STATION_ALREADY_EXISTS,stationName);
        }
        else if(stationCapacity < 1){
            System.out.printf(INVALID_CAPACITY,stationName,stationCapacity);
        }
        else{ //precondition for addStation is met
            TransportSystem.addStation(stationName,stationCapacity);
            System.out.printf(INSTALL_REPLY,stationName,stationCapacity);
        }
    }
    /**
     * Runs the command interpreter for the program. Will continue to accept commands
     * until the user calls the 'exit' command. (Commands are case-sensitive)
     * @param in open and non-null scanner.
     */
    private static void runCommandInterpreter(Scanner in, TransportSystem transportSystem){
        String command = in.next();
        do{
            switch (command) {
                case (REGISTER_CMD):
                    String username = in.next();
                    int balance = in.nextInt();
                    if (transportSystem.userAlreadyExists(username)) {
                        System.out.printf(USER_ALREADY_REGISTERED, username);
                    } else {
                        transportSystem.addUser(username, balance);
                        System.out.printf(REGISTER_REPLY, username, centsToEuros(balance));
                    }
                    break;
                default:
                    runInvalidCommand();
            switch (command){
                case(INSTALL_CMD) -> runInstallCommand(in);
                default -> { runInvalidCommand();}
            }
            in.nextLine();
            command = in.next();
        }while(!command.equals(EXIT_CMD));
        System.out.printf(EXIT_REPLY);
    }

    /**
     * Called when the user inputs an invalid command to the command interpreter.
     * Prints out the error message, then allows the user to continue using the
     * program.
     */
    private static void runInvalidCommand(){
        System.out.printf(INVALID_CMD_REPLY);
    }

    private static double centsToEuros(int cents) {
        return cents / 100.00;

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TransportSystem GIRA = new TransportSystem();
        runCommandInterpreter(input, GIRA);
        input.close();
    }
}
