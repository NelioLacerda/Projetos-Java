package Randomize;

public interface RandomInterface {

    /**
     * Randomize the options listing as an array;
     * @param bound bound of options to randomize
     * @param quantityToShow number of options to show
     */
    void randomize(int bound, int quantityToShow);

    /**
     * Check if the choice one is already choice
     * @param choice char to compare
     * @return true if alreadyExist, false otherwise
     */
    boolean alreadyChoice(char choice);

    RandomIterator it();
}
