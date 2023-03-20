import bicycle.BikeSystem;
import bicycle.BikeSystemClass;
import bicycle.Iterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BikeSystem bikeSystem = new BikeSystemClass();
        executeOptions(sc, bikeSystem);
        sc.close();
    }

    private static void executeOptions(Scanner sc, BikeSystem bikeSystem) {
        boolean hasFinish = false;
        do{
            String option = sc.nextLine();
            switch (option){
                case "ADD" -> addOption(sc, bikeSystem);
                case "REMOVE" -> removeOption(sc, bikeSystem);
                case "LIST" -> listOption(bikeSystem);
                case "EXIT" -> hasFinish = true;
                default -> System.out.println("ERRO!");
            }
        }while (!hasFinish);
        System.out.println("GoodBye!");
    }

    private static void addOption(Scanner sc, BikeSystem bikeSystem) {
        boolean done = false;
        do {
            System.out.println("1- mountain bike, 2- city bike");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    String name = sc.nextLine();
                    if (bikeSystem.existBike(name)) {
                        System.out.println("existe");
                    } else{
                        bikeSystem.addMountainBike(1, 1, 1, 1, name);
                        System.out.println("done");
                    }
                    done = true;
                }
                case 2 -> {
                    String name = sc.nextLine();
                    String cityName = sc.nextLine();
                    if (bikeSystem.existBike(name)){
                        System.out.println("existe");
                    }else {
                        bikeSystem.addCityBike(1, 2, 3, name, cityName);
                        System.out.println("done");
                    }
                    done = true;
                }
                default -> System.out.println("ERRO!");
            }
        }while (!done);
    }

    private static void removeOption(Scanner sc, BikeSystem bikeSystem) {
        if (bikeSystem.existsBikes()){
            String name = sc.nextLine();
            if (bikeSystem.existBike(name)){
                bikeSystem.removeBike(name);
            }else {
                System.out.println("nao existe");
            }
        }else{
            System.out.println("nada para remover");
        }
    }

    private static void listOption(BikeSystem bikeSystem) {
        if (bikeSystem.existsBikes()){
            Iterator it = bikeSystem.it();
            while (it.hasNext()){
                System.out.println(it.next().getBikeName());
            }
        }else{
            System.out.println("Nada para listar");
        }
    }
}
