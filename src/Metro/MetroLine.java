package Metro;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MetroLine {
    // List of stations on Egyptian Metro Line 1
    private static final List<String> STATIONS = Arrays.asList(
            "Helwan", "Ain Helwan", "Helwan University", "Wadi Hof", "Hadayek Helwan",
            "El-Maasara", "Tora El-Balad", "Kozzika", "Tora El-Asmant", "El-Maadi",
            "Hadayeq El-Maadi", "Thakanat El-Maadi", "Dar El-Salam", "El-Zahraa",
            "Mar Girgis", "El-Malek El-Saleh", "Al-Sayeda Zeinab", "Saad Zaghloul",
            "Sadat", "Nasser", "Orabi", "Al-Shohadaa", "Ghamra", "El-Demerdash",
            "Manshiet El-Sadr", "Kobri El-Qobba", "Hammamat El-Qobba", "Saray El-Qobba",
            "Hadayeq El-Zaitoun", "Helmeyet El-Zaitoun", "El-Matareyya", "Ain Shams",
            "Ezbet El-Nakhl", "El-Marg", "New El-Marg"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input current station
        System.out.print("Enter the current station: ");
        String currentStation = scanner.nextLine().trim();

        // Input end destination
        System.out.print("Enter the end destination: ");
        String endStation = scanner.nextLine().trim();

        // Convert input to lowercase for case-insensitive comparison
        currentStation = currentStation.toLowerCase();
        endStation = endStation.toLowerCase();

        // Find the indices of the stations (case-insensitive)
        int startIndex = findStationIndex(currentStation);
        int endIndex = findStationIndex(endStation);

        // Ensure both stations are valid
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("One or both of the stations are invalid.");
            return;
        }

        // Calculate the details
        int stationCount = Math.abs(endIndex - startIndex);
        int estimatedTime = stationCount * 2; // Assuming 2 minutes between each station

        // Calculate the ticket price
        int ticketPrice = calculateTicketPrice(stationCount);

        // Print the results
        System.out.println("Stations Count: " + stationCount);
        System.out.println("Estimated Time: " + estimatedTime + " minutes");
        System.out.println("Ticket Price: " + ticketPrice + " EP");
        System.out.print("Route: ");

        // Recursive method to print the route
        printRoute(startIndex, endIndex);
    }

    // Method to find the index of a station (case-insensitive)
    private static int findStationIndex(String stationName) {
        for (int i = 0; i < STATIONS.size(); i++) {
            if (STATIONS.get(i).equalsIgnoreCase(stationName)) {
                return i;
            }
        }
        return -1;
    }

    private static void printRoute(int currentIndex, int endIndex) {
        if (currentIndex == endIndex) {
            System.out.println(STATIONS.get(currentIndex));
            return;
        }
        System.out.print(STATIONS.get(currentIndex) + " -> ");
        if (currentIndex < endIndex) {
            printRoute(currentIndex + 1, endIndex);
        } else {
            printRoute(currentIndex - 1, endIndex);
        }
    }

    // Method to calculate the ticket price based on the number of stations
    private static int calculateTicketPrice(int stationCount) {
        if (stationCount <= 9) {
            return 6;
        } else if (stationCount <= 16) {
            return 8;
        } else if (stationCount <= 23) {
            return 12;
        } else {
            return 15;
        }
    }
}
