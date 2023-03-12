import Randomize.RandomClass;
import Randomize.RandomIterator;

import java.util.Scanner;

public class Main {
    private static final String EXIT = "EXIT";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        executeOptions(sc);

        sc.close();
    }

    private static void executeOptions(Scanner sc) {
        boolean hasFinish = false;
        do{
            System.out.println("Choice number of options to select [1-23]:");
            int bound = sc.nextInt();
            sc.nextLine();
            if (bound>1 && bound<=23){
                System.out.println("Choice number of options to show:");
                int quantityToShow = sc.nextInt();
                sc.nextLine();
                if (quantityToShow >=1 && quantityToShow<bound){
                    System.out.println("Choice number of times to randomize:");
                    int numberTimes = sc.nextInt();
                    sc.nextLine();
                    if (numberTimes>0){
                        for(int i = 0; i<numberTimes; i++){
                            startRandomize(bound, quantityToShow);
                        }
                    }else{
                        System.out.println("Cant be zero ot less");
                    }
                }else{
                    System.out.println("Cant be negative numbers, zero or more/equal to number of options to select");
                }
            }else{
                System.out.println("Must be more than one and less then 24");
            }


            String option = choiceOption(sc);
            if (option.equals(EXIT)){
                hasFinish = true;
            }
        }while (!hasFinish);
    }

    private static String choiceOption(Scanner sc) {
        System.out.println("Print EXIT to exit");
        return sc.nextLine();
    }

    private static void startRandomize(int bound, int quantityToShow) {
        RandomClass randomClass = new RandomClass();
        randomClass.randomize(bound, quantityToShow);
        printOptions(randomClass);
    }

    private static void printOptions(RandomClass randomClass) {
        RandomIterator it = randomClass.it();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------------------------------");
    }

}
