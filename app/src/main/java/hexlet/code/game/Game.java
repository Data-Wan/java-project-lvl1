package hexlet.code.game;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type Game.
 */
public abstract class Game {

    private String rules;

    private String question;

    private String playerName;

    private String rightAnswer;

    private String userAnswer;

    private final int rightAnswersForWin = 3;

    private String questionData;

    /**
     * Instantiates a new Game.
     *
     * @param playerName the player name
     * @param rules the rules of Game.
     */
    public Game(final String playerName, final String rules) {
        this.playerName = playerName;
        this.question = "Question: %s%n";
        this.rules = rules;
    }

    /**
     * Print rules.
     */
    protected void printRules() {
        System.out.println(this.rules);
    }

    /**
     * Print question.
     */
    protected void printQuestion() {
        System.out.printf(this.question, questionData);
    }

    /**
     * Print lose message.
     */
    protected void printLoseMessage() {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", this.userAnswer, this.rightAnswer);
    }

    /**
     * Print win message.
     */
    protected void printWinMessage() {
        System.out.printf("Congratulations, %s!%n", this.playerName);
    }

    /**
     * Play.
     */
    public void play() {
        printRules();

        var rightAnswerCount = 0;

        while (rightAnswerCount < this.rightAnswersForWin) {

            generateRightAnswer();
            printQuestion();
            getUserAnswer();

            if (Objects.equals(this.rightAnswer, this.userAnswer)) {
                rightAnswerCount++;
                System.out.println("Correct!");
            } else {
                printLoseMessage();
                return;
            }
        }
        printWinMessage();
    }

    /**
     * Gets user answer.
     */
    protected void getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        this.userAnswer = scanner.nextLine().trim();
    }

    /**
     * Generate right answer.
     */
    protected abstract void generateRightAnswer();

    /**
     * Sets rules.
     *
     * @param rules the rules
     */
    protected void setRules(final String rules) {
        this.rules = rules;
    }

    /**
     * Sets right answer.
     *
     * @param rightAnswer the right answer
     */
    protected void setRightAnswer(final String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    /**
     * Sets question data.
     *
     * @param questionData the question data
     */
    protected void setQuestionData(final String questionData) {
        this.questionData = questionData;
    }
}
