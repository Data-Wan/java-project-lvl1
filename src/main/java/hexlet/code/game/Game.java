package hexlet.code.game;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type Game.
 */
public abstract class Game {

    private final int rightAnswersForWin = 3;

    private final String question;

    private final String playerName;

    private String gameRules;

    private String rightAnswer;

    private String userAnswer;

    private String questionData;

    /**
     * Instantiates a new Game.
     *
     * @param name the player name
     * @param rules the rules of Game.
     */
    protected Game(final String name, final String rules) {
        this.playerName = name;
        this.question = "Question: %s%n";
        this.gameRules = rules;
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
                printLetsTryAgainMessage(this.playerName);
                return;
            }
        }
        printWinMessage();
    }

    /**
     * Print rules.
     */
    protected void printRules() {
        System.out.println(this.gameRules);
    }

    /**
     * Generate right answer.
     */
    protected abstract void generateRightAnswer();

    /**
     * Print question.
     */
    protected void printQuestion() {
        System.out.printf(this.question, questionData);
    }

    /**
     * Gets user answer.
     */
    protected void getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        this.userAnswer = scanner.nextLine().trim();
    }

    /**
     * Print lose message.
     */
    protected void printLoseMessage() {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", this.userAnswer, this.rightAnswer);
    }

    /**
     *
     * @param name the player name
     */
    private void printLetsTryAgainMessage(final String name) {
        System.out.printf("Let's try again, %s!%n", name);
    }

    /**
     * Print win message.
     */
    protected void printWinMessage() {
        System.out.printf("Congratulations, %s!%n", this.playerName);
    }

    /**
     * Sets rules.
     *
     * @param rules the rules
     */
    protected void setGameRules(final String rules) {
        this.gameRules = rules;
    }

    /**
     * Sets right answer.
     *
     * @param answer the right answer
     */
    protected void setRightAnswer(final String answer) {
        this.rightAnswer = answer;
    }

    /**
     * Sets question data.
     *
     * @param data the question data
     */
    protected void setQuestionData(final String data) {
        this.questionData = data;
    }
}
