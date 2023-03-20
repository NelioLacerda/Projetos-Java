package bicycle;

public interface Bicycle {
    void setCadence(int newValue);

    void setGear(int newValue);

    void applyBrake(int decrement);

    void speedUp(int increment);

    String getBikeName();
}
