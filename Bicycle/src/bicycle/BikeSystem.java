package bicycle;

public interface BikeSystem {
    void addMountainBike(int startSpeed, int startCadence, int startGear, int startHeight, String bikeName);

    void addCityBike(int startSpeed, int startCadence, int startGear, String bikeName, String cityName);

    void removeBike(String bikeName);

    boolean existsBikes();

    boolean existBike(String bikeName);

    Iterator it();
}
