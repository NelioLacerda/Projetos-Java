package CaesarCipher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Nélio Lacerda
 * a Caesar Cipher é um metodo de encryption onde a cada letra da mensagem andas x posiçoes para a frente o chamado (shift)
 * ex:
 * Msg:LEI
 * shift:2
 * Result: ngk
 *
 * ex:
 * Msg:LEEC
 * shift:-2
 * Result:jcca
 *
 * ex:
 * Msg:ZOO
 * shift:3
 * Result:crr
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Cipher cipher = readInput();
        makeOutput(cipher);
    }

    private static Cipher readInput() throws FileNotFoundException {
        Scanner consoleScanner = new Scanner(System.in); //scanner da consola que le o nome do ficheiro
        System.out.println("File: ");
        String fileName = consoleScanner.nextLine();//le ficheiro da consola
        /*
        Input de ficheiro:
        Mensagem
        Shift
         */
        Scanner inputScanner = new Scanner(new FileReader(fileName));//scanner que le conteudos do ficheiro
        String inputStr = inputScanner.nextLine();//primeira linha do ficheiro
        int shiftKey = inputScanner.nextInt();//segunda linha do ficheiro

        consoleScanner.close();
        inputScanner.close();

        return new Cipher(inputStr, shiftKey);//returna objeto Cipher
    }

    private static void makeOutput(Cipher cipher) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("output.txt");//escreve no ficheiro output.txt(se este não existir cria o ficheiro e dps escreve)
        out.println("Encrypted Data: " + cipher.encryptData());//escreve no ficheiro e dps passa para a proxima linha
        out.println("Decrypted Data: " + cipher.decryptData());//escreve no ficheiro e dps passa para a proxima linha
        out.close();//deixa de escrever no ficheiro
    }
}

