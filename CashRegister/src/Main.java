import Bill.*;
import Iterators.BillIterator;
import Iterators.ProductIterator;

import java.util.Scanner;

/**
 * Main program class
 * @author Nélio Lacerda
 */
public class Main {
    private static final String ADD_BILL = "AB", REMOVE_BILL = "RB", ADD_PRODUCT = "AP", REMOVE_PRODUCT = "RP",
                            LIST_BILL = "LB", LIST_ALL_BILLS = "LA", HELP = "HELP", EXIT = "EXIT";
    public static final String BILL_DOESNT_EXISTS = "Bill doesnt exists.";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CashRegisterClass cashRegister = new CashRegisterClass();
        executeOptions(sc, cashRegister);
        sc.close();
    }

    private static void executeOptions(Scanner sc, CashRegisterClass cashRegister) {
        Main.showOptions();
        boolean hasFinish = false;
        do{
            String option = sc.nextLine();
            switch (option){
                case Main.ADD_BILL -> addBillOption(sc, cashRegister);
                case Main.REMOVE_BILL -> removeBillOption(sc, cashRegister);
                case Main.ADD_PRODUCT -> addProductOption(sc, cashRegister);
                case Main.REMOVE_PRODUCT -> removeProductOption(sc, cashRegister);
                case Main.LIST_BILL -> listBillOption(sc, cashRegister);
                case Main.LIST_ALL_BILLS -> listAllBillsOption(cashRegister);
                case Main.HELP -> Main.showOptions();
                case Main.EXIT -> hasFinish = exitOption();
                default -> defaultOption();
            }
        }while (!hasFinish);
    }

    private static void addBillOption(Scanner sc, CashRegisterClass cashRegister){
        System.out.println("Customer Name: ");
        String customerName = sc.nextLine();
        cashRegister.addBill(customerName);
        System.out.println("Bill added: \n" + "Customer Name: " + customerName +"; Bill ID: " + cashRegister.getLastBillID());
    }

    private static void removeBillOption(Scanner sc, CashRegisterClass cashRegister){
        System.out.println("Bill ID:");
        int billID = sc.nextInt();
        sc.nextLine();
        if (cashRegister.hasBill(billID)){
            cashRegister.removeBill(billID);
            System.out.println("Bill remove");
        }else{
            System.out.println(BILL_DOESNT_EXISTS);
        }
    }

    private static void addProductOption(Scanner sc, CashRegisterClass cashRegister){
        System.out.println("Bill ID:");
        int billID = sc.nextInt();
        sc.nextLine();
        if (cashRegister.hasBill(billID)){
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.println("Product quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();
            cashRegister.addProductToBill(billID, productName, productPrice, productQuantity);
            System.out.println(productName + " added.");
        }else{
            System.out.println(BILL_DOESNT_EXISTS);
        }
    }

    private static void removeProductOption(Scanner sc, CashRegisterClass cashRegister){
        System.out.println("Bill ID:");
        int billID = sc.nextInt();
        sc.nextLine();
        if (cashRegister.hasBill(billID)){
            cashRegister.removeBill(billID);
            System.out.println("Bill removed");
        }else{
            System.out.println(Main.BILL_DOESNT_EXISTS);
        }
    }

    private static void listBillOption(Scanner sc, CashRegisterClass cashRegister){
        System.out.println("Bill ID:");
        int billID = sc.nextInt();
        sc.nextLine();
        if (cashRegister.hasBill(billID)){
            ProductIterator it = cashRegister.it(billID);
            System.out.println("Customer name: " + cashRegister.getBillCustomerName(billID));
            System.out.println("Bill ID: " + billID);
            while (it.hasNext()){
                Product product = it.next();
                System.out.println("Product Name: " + product.getProductName() + "; Product Price: " + product.getProductPrice() +
                        "; Product Quantity: " + product.getProductQuantity());
            }
            System.out.println("Total Price: " + cashRegister.getTotalBillPrice(billID));
        }else{
            System.out.println(Main.BILL_DOESNT_EXISTS);
        }
    }

    private static void listAllBillsOption(CashRegisterClass cashRegister){
        BillIterator BillIt = cashRegister.billIt();
        while (BillIt.hasNext()){
            Bill bill = BillIt.next();
            ProductIterator productIt = bill.it();
            System.out.println("Customer name: " + bill.getCustomerName());
            System.out.println("Bill ID: " + bill.getBillID());
            while (productIt.hasNext()){
                Product product = productIt.next();
                System.out.println("Product Name: " + product.getProductName() + "; Product Price: " + product.getProductPrice() +
                        "; Product Quantity: " + product.getProductQuantity());
            }
            System.out.println("Total Price: " + bill.getTotalBillPrice());
            System.out.println("----------------------------");
        }
    }
    private static void showOptions(){
        System.out.println("""
                AB-add bill
                RB-remove bill
                AP-add product to bill
                RP-remove product from bill
                LB-list bill
                LA-lst all bills
                HELP-show commands
                EXIT- exit
                """);
    }

    private static boolean exitOption(){
        System.out.println("Goodbye");
        return true;
    }

    private static void defaultOption(){
        System.out.println("Unknown Command");

        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}