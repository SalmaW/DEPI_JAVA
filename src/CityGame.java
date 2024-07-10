import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CityGame {
    public static void main(String[] args) {
        String[] names = {"cairo", "alex", "giza", "tanta", "banha"};
        String[] copy = {"cairo", "alex", "giza", "tanta", "banha"};

        Scanner s = new Scanner(System.in);
        Random rand = new Random();

        // Ask for the number of players
        System.out.print("Enter the number of players: ");
        int numPlayers = s.nextInt();
        s.nextLine(); // consume the newline

        byte[] scores = new byte[numPlayers];

        boolean tie;
        do {
            tie = false;
            for (int j = 0; j < scores.length; j++) {
                byte score = 0;
                System.out.println("Player " + (j + 1) + ", enter 3 cities in Egypt:");

                for (int k = 0; k < 3; k++) {
                    System.out.print("Enter city no " + (k + 1) + ": ");
                    String answer = s.nextLine().trim();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equalsIgnoreCase(answer)) {
                            score++;
                            names[i] = "";
                            break;
                        }
                    }
                }
                scores[j] = score;
                System.arraycopy(copy, 0, names, 0, names.length);
                System.out.println("Player " + (j + 1) + ", your score is: " + score);
            }

            byte maxScore = scores[0];
            int maxIndex = 0;
            byte maxCount = 1;

            // Find max score and count how many players have the max score
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] > maxScore) {
                    maxScore = scores[i];
                    maxIndex = i;
                    maxCount = 1;
                } else if (scores[i] == maxScore) {
                    maxCount++;
                }
            }

            // If there is a tie, continue the game only for tied players
            if (maxCount > 1) {
                tie = true;
                System.out.println("There is a tie between players with the highest score of " + maxScore);

                byte[] newScores = new byte[maxCount];
                int[] tiedPlayers = new int[maxCount];
                int index = 0;

                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] == maxScore) {
                        tiedPlayers[index] = i;
                        index++;
                    }
                }

                System.out.println("Tie players will play again...");
                for (int i = 0; i < newScores.length; i++) {
                    int playerIndex = tiedPlayers[i];
                    byte score = 0;
                    System.out.println("Player " + (playerIndex + 1) + ", enter 3 cities in Egypt:");

                    for (int k = 0; k < 3; k++) {
                        System.out.print("Enter city no " + (k + 1) + ": ");
                        String answer = s.nextLine().trim();
                        for (int j = 0; j < names.length; j++) {
                            if (names[j].equalsIgnoreCase(answer)) {
                                score++;
                                names[j] = "";
                                break;
                            }
                        }
                    }
                    newScores[i] = score;
                    System.arraycopy(copy, 0, names, 0, names.length);
                    System.out.println("Player " + (playerIndex + 1) + ", your score is: " + score);
                }

                // Determine the winner from the tie players
                maxScore = newScores[0];
                maxIndex = tiedPlayers[0];
                maxCount = 1;

                for (int i = 1; i < newScores.length; i++) {
                    if (newScores[i] > maxScore) {
                        maxScore = newScores[i];
                        maxIndex = tiedPlayers[i];
                        maxCount = 1;
                    } else if (newScores[i] == maxScore) {
                        maxCount++;
                    }
                }

                if (maxCount > 1) {
                    maxIndex = tiedPlayers[rand.nextInt(maxCount)];
                    tie = false;
                    System.out.println("Randomly selecting the winner from the tied players.");
                } else {
                    tie = false;
                }
                scores[maxIndex] = maxScore;
            }
        } while (tie);

        // Print the final winner
        byte max = scores[0];
        int winnerIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                winnerIndex = i;
            }
        }
        System.out.println("Player " + (winnerIndex + 1) + " wins with the highest score of " + max);
    }
}
