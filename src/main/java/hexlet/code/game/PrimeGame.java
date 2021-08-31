package hexlet.code.game;

import java.util.Random;

/**
 * The type Prime game.
 */
public final class PrimeGame extends Game {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    /**
     * Instantiates a new Prime game.
     *
     * @param playerName the player name
     */
    public PrimeGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        final int upperBoundExclusive = 100;
        var number = random.nextInt(upperBoundExclusive);

        this.setQuestionData(String.valueOf(number));

        this.setRightAnswer(isPrime(number) ? "yes" : "no");
    }

    private boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
