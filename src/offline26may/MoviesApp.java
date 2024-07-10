package offline26may;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class MoviesApp {

    private static final HashMap<String, ArrayList<String>> movieCategoriesMap = new HashMap<>();

    private static final HashMap<String, Integer> searchCountMap = new HashMap<>();

    public static void main(String[] args) {
        // Initialize some movies and their categories
        addMovie("Inception", "Sci-Fi", "Thriller");
        addMovie("The Godfather", "Crime", "Drama");
        addMovie("Toy Story", "Animation", "Family");
        addMovie("The Dark Knight", "Action", "Crime", "Drama");
        addMovie("Pulp Fiction", "Crime", "Drama");


        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Get categories from movie name");
            System.out.println("2. Get all movies in a specific category");
            System.out.println("3. Get most searched movies");
            System.out.println("4. Exit");

            //System.out.println(movieCategoriesMap);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter movie name:");
                    String movieName = scanner.nextLine();
                    ArrayList<String> categories = getCategoriesFromMovieName(movieName);
                    if (categories != null) {
                        System.out.println("Categories for " + movieName + ":");
                        for (String category : categories) {
                            System.out.println(category);
                        }
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter category name:");
                    String categoryName = scanner.nextLine();
                    ArrayList<String> movies = getMoviesInCategory(categoryName);
                    if (!movies.isEmpty()) {
                        System.out.println("Movies in " + categoryName + " category:");
                        for (String movie : movies) {
                            System.out.println(movie);
                        }
                    } else {
                        System.out.println("No movies found in this category.");
                    }
                    break;
                case 3:
                    System.out.println("Most searched movies:");
                    ArrayList<String> mostSearchedMovies = getMostSearchedMovies();
                    for (String movie : mostSearchedMovies) {
                        System.out.println(movie);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addMovie(String movieName, String... categories) {
        ArrayList<String> categoryList = new ArrayList<>();
        Collections.addAll(categoryList, categories);
        movieCategoriesMap.put(movieName, categoryList);
    }

    private static ArrayList<String> getCategoriesFromMovieName(String movieName) {
        return movieCategoriesMap.get(movieName);
    }

    private static ArrayList<String> getMoviesInCategory(String category) {
        ArrayList<String> moviesInCategory = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : movieCategoriesMap.entrySet()) {
            if (entry.getValue().contains(category)) {
                moviesInCategory.add(entry.getKey());
            }
        }
        return moviesInCategory;
    }

    private static ArrayList<String> getMostSearchedMovies() {
        ArrayList<String> mostSearchedMovies = new ArrayList<>(searchCountMap.keySet());
        Collections.sort(mostSearchedMovies, (movie1, movie2) -> searchCountMap.get(movie2) - searchCountMap.get(movie1));
        return mostSearchedMovies;
    }
}
