import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int userChoice = getUserChoice(scanner, options.size());
            if (userChoice == question.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectOptionIndex() + 1) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }

    private int getUserChoice(Scanner scanner, int maxOption) {
        int userChoice = -1;
        while (userChoice < 1 || userChoice > maxOption) {
            System.out.print("Enter your choice (1-" + maxOption + "): ");
            try {
                userChoice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return userChoice;
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new Question("Which programming language is used to develop this application?",
                Arrays.asList("Java", "Python", "C++", "JavaScript"), 1));
        // Add more questions as needed

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}

