package Bill;

import Iterators.ProductIteratorClass;

/**
 * @author Nélio Lacerda
 */
public class BillClass implements Bill{
    public static final int DEFAULT = 10;
    private Customer customer;
    private Product[] products;
    private int billID, productsSize;

    public BillClass(String customerName, int billID){
        this.customer = new CustomerClass(customerName);
        this.products = new ProductClass[DEFAULT];
        this.billID = billID;
        this.productsSize = 0;
    }
    @Override
    public String getCustomerName() {
        return this.customer.getCustomerName();
    }

    @Override
    public int getNumberOfProducts() {
        return productsSize;
    }

    @Override
    public void addProducts(String productName, double price, int quantity) {
        if (hasProduct(productName)){
            int i = productIndex(productName);
            this.products[i].setProductPrice(price);
            this.products[i].setProductQuantity(quantity);
        }else {
            if (products.length == productsSize) {
                grow();
            }
            products[productsSize++] = new ProductClass(productName, price, quantity);
        }
    }

     @Override
     public boolean hasProduct(String productName) {
         return productIndex(productName) != -1;
     }

     @Override
     public int productIndex(String productName) {
         int i = 0;
         int result = -1;
         boolean hasFound = false;
         while (!hasFound && i < productsSize){
             if (products[i].getProductName().equals(productName)){
                 result = i;
                 hasFound = true;
             }else {
                 i++;
             }
         }
         return result;
     }

     @Override
     public int getBillID() {
         return this.billID;
     }

     private void grow() {
         Product[] tmp = new ProductClass[2*products.length];
         for (int i = 0; i < products.length; i++) {
             tmp[i] = products[i];
         }
         products = tmp;
     }

     @Override
    public ProductIteratorClass it(){
        return new ProductIteratorClass(products, productsSize);
     }

     @Override
     public double getTotalBillPrice() {
         double totalPrice = 0;
         for (int i = 0; i<getNumberOfProducts(); i++){
             totalPrice += products[i].getTotalPrice();
         }
         return totalPrice;
     }
 }
