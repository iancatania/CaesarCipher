import java.util.*;

public class Main {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter plaintext message:");
        String plainText = scan.nextLine();
        System.out.println("Enter key:");
        int key = scan.nextInt();

        String encrypted = CaesarCipher(plainText, key);
        String decrypted = DecodeCipher(encrypted, key);

        System.out.println("Key: " + key);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }

    public static String CaesarCipher(String str, int key) {

        String newStr = "";

        for (int i = 0; i < str.length(); i++) {

            if (Character.isLowerCase(str.charAt(i))) {
                newStr += lowerEncode(str.charAt(i), key);
            }
            if (Character.isUpperCase(str.charAt(i))) {
                newStr += upperEncode(str.charAt(i), key);
            }
            if (str.charAt(i) == ' ') {
                newStr += ' ';
            }
        }
        return newStr;
    }

    public static String DecodeCipher(String str, int key) {

        String newStr = "";

        for (int i = 0; i < str.length(); i++) {

            if (Character.isLowerCase(str.charAt(i))) {
                newStr += lowerDecode(str.charAt(i), key);
            }
            if (Character.isUpperCase(str.charAt(i))) {
                newStr += upperDecode(str.charAt(i), key);
            }
            if (str.charAt(i) == ' ') {
                newStr += ' ';
            }
        }
        return newStr;
    }

    public static Character lowerEncode(char c, int key) {
        int val = (c + key) - 'a';

        if ((c + key) > 'a') {
            return (char) ((val % 26) + 'a');
        } else if ((c + key) < 'a') {
            return (char) ((val % 26) + 'z');
        }
        return (char) (c - key);
    }

    public static Character upperEncode(char c, int key) {
        int val = (c + key) - 'A';

        if ((c + key) > 'A') {
            return (char) ((val % 26) + 'A');
        } else if ((c + key) < 'A') {
            return (char) ((val % 26) + 'Z');
        }
        return (char) (c - key);
    }

    public static Character lowerDecode(char c, int key) {
        int val = (c - key) - 'a';

        if ((c + key) > 'a') {
            return (char) ((val % 26) + 'a');
        } else if ((c + key) < 'a') {
            return (char) ((val % 26) + 'z');
        }
        return (char) (c + key);
    }

    public static Character upperDecode(char c, int key) {
        int val = (c - key) - 'A';

        if ((c - key) > 'A') {
            return (char) ((val % 26) + 'A');
        } else if ((c - key) < 'A') {
            return (char) ((val % 26) + 'Z');
        }
        return (char) (c + key);
    }
}
