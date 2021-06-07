package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: " + scanner.nextLine() + " is not a valid number.");
            return;
        }
        int lengthOfSecretCode = scanner.nextInt();
        if (lengthOfSecretCode > 36 || lengthOfSecretCode < 1) {
            System.out.println("Error: incorrect length");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: " + scanner.nextLine() + " is not a valid number.");
            return;
        }
        int possibleSymbols = scanner.nextInt();
        if (possibleSymbols > 36 || possibleSymbols < 1) {
            System.out.println("Error: incorrect length");
            return;
        }
        if (possibleSymbols < lengthOfSecretCode) {
            System.out.println("Error: number of possible symbols should not be less than the length of secret code.");
            return;
        }

        Code code = new Code(lengthOfSecretCode, possibleSymbols);
        code.result();
    }
}