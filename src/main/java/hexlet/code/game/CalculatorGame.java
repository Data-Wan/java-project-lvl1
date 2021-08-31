package hexlet.code.game;

import java.util.Random;

/**
 * The type Calculator game.
 */
public final class CalculatorGame extends Game {

    private static final String RULES = "What is the result of the expression?";

    private final String[] operators = new String[]{"+", "-", "*"};

    /**
     * Instantiates a new Calculator game.
     *
     * @param playerName the player name
     */
    public CalculatorGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        final Random random = new Random();

        final int upperBoundExclusive = 10;

        final var number1 = random.nextInt(upperBoundExclusive);
        final var number2 = random.nextInt(upperBoundExclusive);

        final var indexOfOperator = random.nextInt(operators.length);

        final var operator = operators[indexOfOperator];

        switch (operator) {
            case "+" -> this.setRightAnswer(String.valueOf(number1 + number2));
            case "-" -> this.setRightAnswer(String.valueOf(number1 - number2));
            case "*" -> this.setRightAnswer(String.valueOf(number1 * number2));
            default -> throw new RuntimeException("Incorrect operator");
        }

        this.setQuestionData(String.format("%d %s %d", number1, operator, number2));
    }
}
