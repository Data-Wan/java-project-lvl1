package hexlet.code.game;

import java.util.Random;

/**
 * The type Gcd game.
 */
public final class GCDGame extends Game {

    private static final String RULES = "Find the greatest common divisor of given numbers.";

    /**
     * Instantiates a new Gcd game.
     *
     * @param playerName the player name
     */
    public GCDGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        final Random random = new Random();

        final int upperBoundExclusive = 20;
        final var number1 = random.nextInt(upperBoundExclusive);
        final var number2 = random.nextInt(upperBoundExclusive);

        this.setRightAnswer(String.valueOf(gcdByEuclidsAlgorithm(number1, number2)));

        this.setQuestionData(String.format("%d %d", number1, number2));
    }

    private int gcdByEuclidsAlgorithm(final int n1, final int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
