package CaesarCipher;

/**
 * @author Nélio Lacerda
 */
public class Cipher implements CipherInterface{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private String inputStr;
    private int shiftKey;

    public Cipher(String inputStr, int shiftKey){
        setInputStr(inputStr);
        setShiftKey(shiftKey);
    }

    //os Override envolvem as interfaces ignora

    @Override
    public String encryptData(){
        setInputStr(getInputStr().toLowerCase());
        String encryptStr = "";

        for (int i = 0; i<getInputStr().length(); i++){
            int pos = ALPHABET.indexOf(getInputStr().charAt(i));
            int encryptPos = (getShiftKey() + pos) % 26;//formula que achas na net
            char encryptChar = ALPHABET.charAt(encryptPos);
            encryptStr += encryptChar;
        }
        return encryptStr;
    }

    @Override
    public String decryptData(){
        String inputStr = encryptData().toLowerCase();
        String decryptStr = "";

        for (int i = 0; i<inputStr.length();i++){
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            int decryptPos = (pos - getShiftKey())%26;//formula que achas na net

            if (decryptPos < 0){//se a posição for menor que 0 ele vai procurar de z ate a
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);
            decryptStr += decryptChar;
        }
        return decryptStr;
    }

    private String getInputStr() {
        return inputStr;
    }

    private void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    private int getShiftKey() {
        return shiftKey;
    }

    private void setShiftKey(int shiftKey) {
        this.shiftKey = shiftKey;
    }
}
