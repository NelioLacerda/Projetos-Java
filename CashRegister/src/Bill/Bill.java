package Bill;

import Iterators.ProductIteratorClass;

/**
 * Contains a customer and an array of products
 * @author Nélio Lacerda
 */
public interface Bill {

    /**
     * returns bill customer name
     * @return bill customer name
     */
    String getCustomerName();

    /**
     * returns the number of products that the bill contains
     * @return the number of products that the bill contains
     */
    int getNumberOfProducts();

    /**
     * add product to bill
     * @param productName product name
     * @param price product price
     * @param quantity product quantity
     */
    void addProducts(String productName, double price, int quantity);

    /**
     * returns if the bill has the product
     * @param productName product name
     * @return true, if it was, false otherwise
     */
    boolean hasProduct(String productName);

    /**
     * returns product index in the array
     * @param productName product name
     * @return -1, if the product doesn't exist, index in the array otherwise
     */
    int productIndex(String productName);

    /**
     * returns the bill id
     * @return the bill id
     */
    int getBillID();

    /**
     * returns iterator to pass trow all products
     * @return iterator to pass trow all products
     */
    ProductIteratorClass it();

    /**
     * returns total bill price
     * @return total bill price
     */
    double getTotalBillPrice();
}
