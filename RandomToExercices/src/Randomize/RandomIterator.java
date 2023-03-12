package Randomize;

public class RandomIterator implements RandomIteratorInterface{

    private char[] chars;
    private int size, nextIndex;

    public RandomIterator(char[] chars, int size){
        this.chars = chars;
        this.size = size;
        this.nextIndex = 0;
    }
    @Override
    public char next() {
        return chars[nextIndex++];
    }

    @Override
    public boolean hasNext() {
        return nextIndex < size;
    }
}
