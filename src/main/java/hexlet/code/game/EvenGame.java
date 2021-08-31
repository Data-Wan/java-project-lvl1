package hexlet.code.game;

import java.util.Random;

/**
 * The type Even game.
 */
public final class EvenGame extends Game {

    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    /**
     * Instantiates a new Even game.
     *
     * @param playerName the player name
     */
    public EvenGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        final Random random = new Random();

        final int randomNumber = random.nextInt();

        this.setQuestionData(String.valueOf(randomNumber));

        this.setRightAnswer(randomNumber % 2 == 0 ? "yes" : "no");
    }
}
