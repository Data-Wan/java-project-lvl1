package hexlet.code;

import hexlet.code.game.EvenGame;
import hexlet.code.game.Game;

import java.util.Scanner;

public final class App {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";

    private static String playerName;

    public static void main(String[] args) {

        final int optionFromMenu = chooseOptionFromMenu();

        Game game;

        switch (optionFromMenu) {
            case 0:
                return;
            case 1:
                startApp();
                break;
            case 2:
                startApp();
                game = new EvenGame(playerName);
                game.play();
                break;
            default:
                System.out.println("Incorrect option, restart application");
        }
    }

    private static void startApp() {
        printWelcomeMessage();
        playerName = Cli.askNameOfPlayer();
        greetPlayer(playerName);
    }

    private static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static void greetPlayer(final String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public static int chooseOptionFromMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(Options.GREET);
        System.out.println(Options.EXIT);
        System.out.println(Options.EVEN_GAME);

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}

final class Options {

    public static final String EXIT = "0 - Exit";

    public static final String GREET = "1 - Greet";

    public static final String EVEN_GAME = "2 - EVEN";
}
