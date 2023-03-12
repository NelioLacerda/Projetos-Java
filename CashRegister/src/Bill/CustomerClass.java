package Bill;

/**
 * @author Nélio Lacerda
 */
 class CustomerClass implements Customer{
    private String customerName;

    public CustomerClass(String customerName){
        this.customerName = customerName;
    }
    @Override
    public String getCustomerName() {
        return this.customerName;
    }
}
