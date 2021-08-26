package hexlet.code.game;

import java.util.Random;

public final class GCDGame extends Game {

    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public GCDGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        var number1 = random.nextInt();
        var number2 = random.nextInt();

        this.setRightAnswer(String.valueOf(gcdByEuclidsAlgorithm(number1, number2)));

        this.setQuestionData(String.format("%d %d", number1, number2));
    }

    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
