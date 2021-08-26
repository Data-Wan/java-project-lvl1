package hexlet.code.game;

import java.util.Random;

public final class CalculatorGame extends Game {

    private static final String RULES = "What is the result of the expression?";

    public CalculatorGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        final int upperBoundExclusive = 10;

        var number1 = random.nextInt(upperBoundExclusive);
        var number2 = random.nextInt(upperBoundExclusive);

        var indexOfOperator = random.nextInt(operators.length);

        var operator = operators[indexOfOperator];

        switch (operator) {
            case "+" -> this.setRightAnswer(String.valueOf(number1 + number2));
            case "-" -> this.setRightAnswer(String.valueOf(number1 - number2));
            case "*" -> this.setRightAnswer(String.valueOf(number1 * number2));
            default -> throw new RuntimeException("Incorrect operator");
        }

        this.setQuestionData(String.format("%d %s %d", number1, operator, number2));
    }

    private final String[] operators = new String[]{"+", "-", "*"};
}
