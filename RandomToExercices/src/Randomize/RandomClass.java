package Randomize;

import java.util.Random;

public class RandomClass implements RandomInterface{
    private static final int DEFAULT = 5;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    char[] chosenOptions;
    int counter;

    public RandomClass() {
        this.chosenOptions = new char[DEFAULT];
        this.counter = 0;
    }

    @Override
    public void randomize(int bound, int quantityToShow) {
        Random random = new Random();
        int foundOptions = 0;
        do {
            int number = random.nextInt(bound);
            char chosen = ALPHABET.charAt(number);
            if (!alreadyChoice(chosen)) {
                foundOptions++;
                addToOptions(chosen);
            }
        }while (foundOptions < quantityToShow);

    }

    private void addToOptions(char chosen) {
        if (chosenOptions.length == counter){
            grow();
        }
        chosenOptions[counter++] = chosen;
    }

    private void grow() {
        char[] tmp = new char[2 * chosenOptions.length];
        for (int i = 0; i<chosenOptions.length; i++){
            tmp[i] = chosenOptions[i];
        }
        chosenOptions = tmp;
    }

    @Override
    public boolean alreadyChoice(char choice) {
        boolean hasFound = false;
        if (hasChars()){
            int i = 0;
            do{
                if (chosenOptions[i] == choice){
                    hasFound = true;
                }else{
                    i++;
                }
            }while (i<counter && !hasFound);
        }
        return hasFound;
    }

    @Override
    public RandomIterator it() {
        return new RandomIterator(chosenOptions, counter);
    }

    private boolean hasChars(){
        return counter > 0;
    }
}
