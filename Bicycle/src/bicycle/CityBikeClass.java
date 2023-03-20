package bicycle;

  class CityBikeClass extends BicycleClass implements CityBike{
    private String cityName;

     public CityBikeClass(int startSpeed, int startCadence, int startGear, String bikeName, String cityName) {
         super(startSpeed, startCadence, startGear, bikeName);
         this.cityName = cityName;
     }

     @Override
     public void setCityName(String cityName) {
        this.cityName = cityName;
     }
  }
