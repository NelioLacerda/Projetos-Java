package bicycle;

public class BikeSystemClass implements BikeSystem{

    private Bicycle[] bicycles;
    private int numOfBikes;
    public BikeSystemClass(){
        this.bicycles = new Bicycle[10];
        this.numOfBikes = 0;
    }

    private int searchIndex(String bikeName){
        int i = 0;
        int result = -1;
        boolean hasFound = false;
        while (!hasFound && i < numOfBikes){
            if (bicycles[i].getBikeName().equals(bikeName)){
                result = i;
                hasFound = true;
            }else{
                i++;
            }
        }
        return result;
    }

    @Override
    public void addMountainBike(int startSpeed, int startCadence, int startGear, int startHeight, String bikeName) {
        if (isFull()){
            grow();
        }
        bicycles[numOfBikes++] = new MountainBikeClass(startSpeed, startCadence, startGear, startHeight, bikeName);
    }

    @Override
    public void addCityBike(int startSpeed, int startCadence, int startGear, String bikeName, String cityName) {
        if (isFull()){
            grow();
        }
        bicycles[numOfBikes++] = new CityBikeClass(startSpeed, startCadence, startGear, bikeName, cityName);
    }

    private boolean isFull(){
        return numOfBikes == bicycles.length;
    }

    private void grow(){
        int size = bicycles.length;
        Bicycle[] tmp = new Bicycle[2 * size];
        for (int i = 0; i < size; i++) {
            tmp[i] = bicycles[i];
        }
        bicycles = tmp;
    }
    @Override
    public void removeBike(String bikeName) {
        int i = searchIndex(bikeName);
        for (int j = i; j < numOfBikes; j++) {
            bicycles[j] = bicycles[j+1];
        }
        numOfBikes--;
    }

    @Override
    public boolean existsBikes() {
        return numOfBikes > 0;
    }

    @Override
    public boolean existBike(String bikeName) {
        return searchIndex(bikeName) != -1;
    }

    @Override
    public Iterator it() {
        return new IteratorClass(bicycles, numOfBikes);
    }
}
