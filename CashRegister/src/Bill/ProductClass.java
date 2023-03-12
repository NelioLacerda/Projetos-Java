package Bill;

/**
 * @author Nélio Lacerda
 */
 public class ProductClass implements Product{

    private String productName;
    private int productQuantity;
    private double productPrice;

    public ProductClass(String productName, double productPrice, int productQuantity){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public double getTotalPrice() {
        return this.getProductPrice() * this.productQuantity;
    }

     @Override
     public void setProductQuantity(int newProductQuantity) {
         this.productQuantity = newProductQuantity;
     }

     @Override
     public void setProductPrice(double newProductPrice) {
        this.productPrice = newProductPrice;
     }
 }
