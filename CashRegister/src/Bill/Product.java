package Bill;

/**
 * Contains the information of one product
 * @author Nélio Lacerda
 */
public interface Product {

    /**
     * returns product name
     * @return product name
     */
    String getProductName();

    /**
     * returns the product quantity
     * @return the product quantity
     */
    int getProductQuantity();

    /**
     * returns product price
     * @return product price
     */
    double getProductPrice();

    /**
     * returns total price
     * @return total price
     */
    double getTotalPrice();

    /**
     * set new product quantity
     * @param newProductQuantity new product quantity
     */
    void setProductQuantity(int newProductQuantity);

    /**
     * set new product price
     * @param newProductPrice new product price
     */
    void setProductPrice(double newProductPrice);
}
