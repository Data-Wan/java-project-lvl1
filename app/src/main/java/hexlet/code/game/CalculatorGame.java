package hexlet.code.game;

import java.util.Random;

public final class CalculatorGame extends Game {

    private static final String rules = "What is the result of the expression?";

    public CalculatorGame(final String playerName) {
        super(playerName, rules);
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        var number1 = random.nextInt(10);
        var number2 = random.nextInt(10);

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

    String[] operators = new String[]{"+", "-", "*"};
}
