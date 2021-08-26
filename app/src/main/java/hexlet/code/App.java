package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GCDGame;
import hexlet.code.game.Game;
import hexlet.code.game.ProgressionGame;

import java.util.Scanner;

public final class App {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";

    private static String playerName;

    public static void main(String[] args) {

        final Options optionFromMenu = Options.values()[chooseOptionFromMenu()];

        Game game;

        switch (optionFromMenu) {
            case EXIT:
                return;
            case GREET:
                startApp();
                break;
            case EVEN_GAME:
                startApp();
                game = new EvenGame(playerName);
                game.play();
                break;
            case CALCULATOR_GAME:
                startApp();
                game = new CalculatorGame(playerName);
                game.play();
                break;
            case GCD_GAME:
                startApp();
                game = new GCDGame(playerName);
                game.play();
                break;
            case PROGRESSION_GAME:
                startApp();
                game = new ProgressionGame(playerName);
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

        System.out.println(Options.EVEN_GAME);
        System.out.println(Options.CALCULATOR_GAME);
        System.out.println(Options.GCD_GAME);
        System.out.println(Options.PROGRESSION_GAME);

        System.out.println(Options.EXIT);

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}

enum Options {
    EXIT("0 - Exit"),
    GREET("1 - Greet"),
    EVEN_GAME("2 - Even"),
    CALCULATOR_GAME("3 - Calc"),
    GCD_GAME("4 - GCD"),
    PROGRESSION_GAME("5 - Progression");

    private final String stringRepresentation;

    Options(final String string) {
        this.stringRepresentation = string;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
