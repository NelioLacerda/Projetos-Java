package bicycle;

public interface Iterator {

    boolean hasNext();
    Bicycle next();

    void init();

}
