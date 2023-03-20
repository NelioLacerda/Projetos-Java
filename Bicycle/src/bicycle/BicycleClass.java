package bicycle;

 class BicycleClass implements Bicycle{
    private int speed, cadence, gear;
    private String bikeName;

    public BicycleClass(int startSpeed, int startCadence, int startGear, String bikeName) {
        this.speed = startSpeed;
        this.cadence = startCadence;
        this.gear = startGear;
        this.bikeName = bikeName;
    }

    @Override
    public void setCadence(int newValue) {
        this.cadence = newValue;
    }

    @Override
    public void setGear(int newValue) {
        this.gear = newValue;
    }

    @Override
    public void applyBrake(int decrement) {
        this.speed -= decrement;
    }

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
    }

     @Override
     public String getBikeName() {
         return bikeName;
     }
 }
