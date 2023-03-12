package Bill;

import Iterators.BillIteratorClass;
import Iterators.ProductIteratorClass;

/**
 * @author Nélio Lacerda
 */
public class CashRegisterClass implements CashRegister{
    public static final int DEFAULT = 10;
    private Bill[] bills;
    private int ID, billsSize;

    public CashRegisterClass(){
        this.bills = new BillClass[DEFAULT];
        this.ID = 1;
        this.billsSize = 0;
    }
    @Override
    public int searchBillIndex(int billID) {
        int result = -1;
        int i = 0;
        boolean hasFound = false;
        while (i < billsSize && !hasFound){
            if (bills[i].getBillID() == billID){
                result = i;
                hasFound = true;
            }else {
                i++;
            }
        }
        return result;
    }

    @Override
    public ProductIteratorClass it(int billID) {
        return bills[searchBillIndex(billID)].it();
    }

    @Override
    public void addBill(String customerName) {
        if (bills.length == billsSize){
            grow();
        }
        bills[billsSize++] = new BillClass(customerName, ID++);
    }

    private void grow() {
        Bill[] tmp = new BillClass[2*bills.length];
        for (int i = 0; i <bills.length; i++) {
            tmp[i] = bills[i];
        }
        bills = tmp;
    }

    @Override
    public void removeBill(int billID) {
        for (int i = searchBillIndex(billID); i <billsSize; i++) {
            bills[i] = bills[i+1];
        }
        billsSize--;
    }

    @Override
    public boolean hasBill(int billID) {
        return searchBillIndex(billID) != -1;
    }

    @Override
    public int getLastBillID() {
        return bills[billsSize-1].getBillID();
    }

    @Override
    public void addProductToBill(int billID, String productName, double price, int quantity) {
        bills[searchBillIndex(billID)].addProducts(productName, price, quantity);
    }

    @Override
    public String getBillCustomerName(int billID) {
        return bills[searchBillIndex(billID)].getCustomerName();
    }

    @Override
    public double getTotalBillPrice(int billID) {
        return bills[searchBillIndex(billID)].getTotalBillPrice();
    }

    @Override
    public BillIteratorClass billIt() {
        return new BillIteratorClass(bills, billsSize);
    }
}
