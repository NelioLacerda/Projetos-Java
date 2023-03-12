package Bill;

import Iterators.BillIteratorClass;
import Iterators.ProductIteratorClass;

/**
 * Deals with all the bills
 * @author Nélio Lacerda
 */
public interface CashRegister {
    /**
     * returns the index of the bill in the array
     * @param billID bill id
     * @return -1 if there is no bill in the array, index in the array otherwise
     */
    int searchBillIndex(int billID);

    /**
     * returns the product iterator
     * @param billID bill id
     * @return the product iterator
     */
    ProductIteratorClass it(int billID);

    /**
     * add one bill to the cash register
     * @param customerName customer name
     */
    void addBill(String customerName);

    /**
     * removes one bill from the cash register
     * @param billID bill id
     */
    void removeBill(int billID);

    /**
     * returns if bill exists
     * @param billID bill id
     * @return true if bill exist, false otherwise
     */
    boolean hasBill(int billID);

    /**
     * returns last bill ID
     * @return last bill ID
     */
    int getLastBillID();

    /**
     * adds product to bill
     * @param billID bill ID
     * @param productName product name
     * @param price product price
     * @param quantity product quantity
     */
    void addProductToBill(int billID, String productName, double price, int quantity);

    /**
     * returns customer name of the bill
     * @param billID bill id
     * @return customer name of the bill
     */
    String getBillCustomerName(int billID);

    /**
     * returns total bill price
     * @param billID bill ID
     * @return total bill price
     */
    double getTotalBillPrice(int billID);

    /**
     * returns the bill iterator
     * @return the bill iterator
     */
    BillIteratorClass billIt();
}
