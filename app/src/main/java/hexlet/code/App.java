package hexlet.code;

public final class App {

    private static final String GREETING = "Welcome to the Brain Games!";

    public static void main(String[] args) {
        System.out.println(GREETING);

        var name = Cli.askNameOfPlayer();

        greetPlayer(name);
    }

    private static void greetPlayer(final String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    public String getGreeting() {
        return GREETING;
    }
}
