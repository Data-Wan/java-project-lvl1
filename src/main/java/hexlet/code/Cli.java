package hexlet.code;

import java.util.Scanner;

/**
 * The type Cli.
 */
public final class Cli {

    private Cli() {
    }

    /**
     * Ask name of player string.
     *
     * @return the string
     */
    public static String askNameOfPlayer() {
        System.out.print("May I have your name? ");
        final Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }
}
