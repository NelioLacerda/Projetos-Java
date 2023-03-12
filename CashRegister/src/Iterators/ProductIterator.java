package Iterators;

import Bill.Product;

/**
 * List all products in one bill
 * @author Nélio Lacerda
 */
public interface ProductIterator {
    /**
     * returns if there is another product in the array
     * @return true if there is another product in the array, false otherwise
     */
    boolean hasNext();

    /**
     * returns the next product in the array
     *
     * @return the next product in the array
     */
    Product next();
}
