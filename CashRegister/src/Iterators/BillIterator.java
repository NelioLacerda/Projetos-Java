package Iterators;

import Bill.Bill;

public interface BillIterator {
    /**
     * returns if there is another bill in the array
     * @return true if there is another bill in the array, false otherwise
     */
    boolean hasNext();

    /**
     * returns the next bill in the array
     *
     * @return the next bill in the array
     */
    Bill next();
}
