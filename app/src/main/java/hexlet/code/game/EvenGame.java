package hexlet.code.game;

import java.util.Random;

public final class EvenGame extends Game {

    public EvenGame(String playerName) {
        super(playerName);
        this.setRules("Answer 'yes' if number even otherwise answer 'no'.");
        this.setQuestion("Question: %s%n");
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        final int randomNumber = random.nextInt();

        this.setQuestionData(String.valueOf(randomNumber));

        this.setRightAnswer(randomNumber % 2 == 0 ? "yes" : "no");
    }
}
