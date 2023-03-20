package bicycle;

  class MountainBikeClass extends BicycleClass implements MountainBike{
    private int height;

    public MountainBikeClass(int startSpeed, int startCadence, int startGear, int startHeight, String bikeName) {
        super(startSpeed, startCadence, startGear, bikeName);
        this.height = startHeight;
    }

    @Override
    public void setHeight(int newValue) {
        this.height = newValue;
    }

}
