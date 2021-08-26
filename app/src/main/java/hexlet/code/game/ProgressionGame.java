package hexlet.code.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ProgressionGame extends Game {

    private static final String RULES = "What number is missing in the progression?";

    public ProgressionGame(final String playerName) {
        super(playerName, RULES);
    }

    @Override
    protected void generateRightAnswer() {
        Random random = new Random();

        final int lowerBoundInclusive = 5;
        final int upperBoundExclusive = 11;
        var progressionLength = random.nextInt(upperBoundExclusive) + lowerBoundInclusive;

        List<String> numberSequence = new ArrayList<>();

        final int upperBoundExclusiveForFirstNumber = 10;
        var firstNumberInSequence = random.nextInt(upperBoundExclusiveForFirstNumber);

        final int upperBoundExclusiveForProgressionStep = 10;
        var progressionStep = random.nextInt(upperBoundExclusiveForProgressionStep);

        for (int i = 0; i < progressionLength; i++) {
            numberSequence.add(String.valueOf(firstNumberInSequence + progressionStep * i));
        }

        var indexOfDeletedNumber = random.nextInt(numberSequence.size());
        var deletedNumber = numberSequence.get(indexOfDeletedNumber);
        numberSequence.set(indexOfDeletedNumber, "..");
        this.setRightAnswer(deletedNumber);

        var numberSequenceToStringWithoutDeletedNumber = String.join(" ", numberSequence);

        this.setQuestionData(numberSequenceToStringWithoutDeletedNumber);
    }
}
