import java.util.Scanner;

public class quizCity {
    public static void main(String[] args) {
        //what is the capital of egypt
        //what is the capital of usa
        //what is the capital of france
        //what is the capital of uk
        //final score is:

        Scanner s = new Scanner(System.in);
        byte score = 0;
        String[] countries = {"egypt", "usa", "france", "uk"};
        String[] cities = {"cairo", "ws", "paris", "london"};

        for (int i = 0; i < countries.length; i++) {
            System.out.println("What is the capital of " + countries[i] + " ?");
            String answer = s.next();

            if (answer.equalsIgnoreCase(cities[i])) {
                if (i == 0) score += 2;
                else score++;
            } else {
                i = i - 1;
                score--;
            }
        }

        if (score < 0) System.out.println("\nyou have failed the quiz, ur score is: " + score);
        else System.out.println("final score is: " + score);

    }
}
