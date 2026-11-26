public class Bike {
    private String id;
    private int battery;
    private boolean inUse;

    public Bike(String id) {
        this.id = id;
        battery = 100;
        inUse = false;
    }

    /**
     * Compares two Bikes to each other.
     * This method first compares the battery % of each Bike in which the
     * "Larger" Bike is the one with the higher battery.
     * If both Bikes have the same battery, their ids are compared.
     * The Bike with the smallest identifier in alphabetical order is
     * considered "Larger"
     * @param anotherBike: Bike to be compared to this bike
     * @return >0 if this is "Larger" than anotherBike
     * <0 if this is "Smaller" than anotherBike
     */
    public int compareTo(Bike anotherBike){
        if(this.battery == anotherBike.getBattery()){
            return anotherBike.getId().compareTo(this.id);
        }
        else{
            return this.battery - anotherBike.getBattery();
        }
    }

    public int getBattery() {
        return battery;
    }

    public String getId() {
        return id;
    }

    public boolean isInUse() {
        return inUse;
    }
}
