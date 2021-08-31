package hexlet.code.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The type Progression game.
 */
public final class ProgressionGame extends Game {

    private static final String RULES = "What number is missing in the progression?";

    /**
     * Instantiates a new Progression game.
     *
     * @param playerName the player name
     */
    public ProgressionGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        final Random random = new Random();

        final int lowerBoundInclusive = 5;
        final int upperBoundExclusive = 11;
        final var progressionLength = random.nextInt(upperBoundExclusive) + lowerBoundInclusive;

        final List<String> numberSequence = new ArrayList<>();

        final int upperBoundExclusiveForFirstNumber = 10;
        final var firstNumberInSequence = random.nextInt(upperBoundExclusiveForFirstNumber);

        final int upperBoundExclusiveForProgressionStep = 10;
        final var progressionStep = random.nextInt(upperBoundExclusiveForProgressionStep);

        for (int i = 0; i < progressionLength; i++) {
            numberSequence.add(String.valueOf(firstNumberInSequence + progressionStep * i));
        }

        final var indexOfDeletedNumber = random.nextInt(numberSequence.size());
        final var deletedNumber = numberSequence.get(indexOfDeletedNumber);
        numberSequence.set(indexOfDeletedNumber, "..");
        this.setRightAnswer(deletedNumber);

        final var numberSequenceToStringWithoutDeletedNumber = String.join(" ", numberSequence);

        this.setQuestionData(numberSequenceToStringWithoutDeletedNumber);
    }
}
