package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Code {
    Grade grade;
    int lengthOfSecretCode;
    int possibleSymbols;
    char[] secretCode;

    public Code(int lengthOfSecretCode, int possibleSymbols) {
        this.lengthOfSecretCode = lengthOfSecretCode;
        this.possibleSymbols = possibleSymbols;
        this.secretCode = createSecretCode(lengthOfSecretCode, possibleSymbols);
    }

    char[] createSecretCode(int lengthOfSecretCode, int possibleSymbols) {
        while (true) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";
            String str = symbols.substring(0, possibleSymbols);

            for (int i = 0; i < lengthOfSecretCode; i++) {
                sb.append(str.charAt(random.nextInt(possibleSymbols)));
            }

            for (int j = 0; j < sb.length(); j++) {
                for (int m = j + 1; m < sb.length(); m++) {
                    if (sb.charAt(m) == sb.charAt(j)) {
                        sb.deleteCharAt(m);
                        m--;
                    }
                }
            }

            if (lengthOfSecretCode == sb.length()) {
                System.out.print("The secret is prepared: ");
                for (int q = 0; q < sb.length(); q++) {
                    System.out.print("*");
                }
                System.out.print(" ");
                if (str.length() < 11) {
                    System.out.println("(0-" + str.charAt(possibleSymbols - 1) + ").");
                } else if (str.length() == 11) {
                    System.out.println("(0-9, a).");
                } else {
                    System.out.println("(0-9, a-" + str.charAt(possibleSymbols - 1) + ").");
                }
                return sb.toString().toCharArray();
            }
        }
    }

    public void result() {
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        boolean result = false;

        System.out.println("Okay, lets start a game!");
        while (!result) {
            System.out.println("Turn " + ++turn + ":");
            grade = new Grade(scanner.next().toCharArray());
            result = grade.checkGrade(this.secretCode);
        }
    }
}