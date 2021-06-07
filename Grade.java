package bullscows;

public class Grade {
    int bulls;
    int cows;
    char[] input;

    public Grade(char[] input) {
        this.bulls = 0;
        this.cows = 0;
        this.input = input;
    }

    boolean checkGrade(char[] code) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (input[i] == code[j]) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        return printGrade(code);
    }

    boolean printGrade(char[] code) {
        System.out.print("Grade: ");
        if (bulls == code.length) {
            System.out.println(bulls + " bulls");
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        }else if (bulls == 1 && cows == 1) {
            System.out.println(bulls + " bull and " + cows + " cow");
        } else if (bulls == 1) {
            System.out.println(bulls + " bull and " + cows + " cows");
        } else if (cows == 1) {
            System.out.println(bulls + " bulls " + cows + " cow");
        } else {
            System.out.println(bulls + " bulls and " + cows + " cows");
        }
        return false;
    }
}