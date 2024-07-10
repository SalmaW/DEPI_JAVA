package Metro;

import java.time.Duration;
import java.util.*;

public class MetroLinev2 {
    // List of stations on Egyptian Metro Lines 1, 2, 3
    private static final List<String> Line1 = Arrays.asList(
            "helwan", "ain helwan", "helwan university", "wadi hof", "hadayek helwan",
            "el-maasara", "tora el-balad", "kozzika", "tora el-asmant", "el-maadi",
            "hadayeq el-maadi", "thakanat el-maadi", "dar el-salam", "el-zahraa",
            "mar girgis", "el-malek el-saleh", "al-sayeda zeinab", "saad zaghloul",
            "sadat", "nasser", "orabi", "al-shohadaa", "ghamra", "el-demerdash",
            "manshiet el-sadr", "kobri el-qobba", "hammamat el-qobba", "saray el-qobba",
            "hadayeq el-zaitoun", "helmeyet el-zaitoun", "el-matareyya", "ain shams",
            "ezbet el-nakhl", "el-marg", "new el-marg"
    );
    private static final List<String> Line2 = Arrays.asList(
            "el mounib", "sakiat mekki", "omm el misryeen", "giza", "faisal",
            "cairo university", "bohooth", "dokki", "opera", "sadat", "naguib",
            "ataba", "al shohadaa", "massara", "road el-farag", "sainte teresa",
            "khalafawy", "mezallat", "koliet el-zeraa", "shobra el kheima"
    );
    private static final List<String> Line3 = Arrays.asList(
            "adly mansour", "hikestep", "omar ibn al khattab", "kebaa", "hisham barakat",
            "el nozha", "el shames club", "alf maskan", "heliopolis", "haroun",
            "al ahram", "koleyet el banat", "cairo stadium", "fair zone", "abbassiya",
            "abdou pasha", "el geish", "bab el shaaria", "ataba", "nasser",
            "maspero", "zamalek", "kit kat", "sudan st.", "imbaba",
            "el bohy", "el qawmia", "ring road", "rod el farag"
    );

    private static final List<String> JumpPoint1to2 = Arrays.asList("sadat", "al-shohadaa");
    private static final List<String> JumpPoint2to3 = List.of("ataba");
    private static final List<String> JumpPoint1to3 = List.of("nasser");

    static String lineNameAtStart;
    static String lineNameAtEnd;
    static boolean isLineAtStart = true;
    static int stationCount = 0;
    static String bridgeStation13 = JumpPoint1to3.get(0);
    static List<Integer> bridgeIndex13 = List.of(Line1.indexOf(bridgeStation13), Line3.indexOf(bridgeStation13));// line 1, line3
    static List<Integer> bridgeIndex12 = List.of(Line1.indexOf(JumpPoint1to2.get(0)), Line1.indexOf(JumpPoint1to2.get(1)), Line2.indexOf(JumpPoint1to2.get(0)), Line2.indexOf(JumpPoint1to2.get(1)));// line 1, line2

    static String bridgeStation23 = JumpPoint2to3.get(0);
    static List<Integer> bridgeIndex23 = List.of(Line2.indexOf(bridgeStation23), Line3.indexOf(bridgeStation23));// line 2, line3
    static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input current station
        System.out.print("Enter the current station: ");
        String currentStation = scanner.nextLine();

        // Input end destination
        System.out.print("Enter the end destination: ");
        String endStation = scanner.nextLine();


        isLineAtStart = true;
        int startIndex = findStationIndex(currentStation, isLineAtStart);
        String startLine = lineNameAtStart;
        isLineAtStart = false;
        int endIndex = findStationIndex(endStation, isLineAtStart);
        String endLine = lineNameAtEnd;

//        System.out.println(Line3.contains(currentStation));
//        System.out.println(Line3.contains(endStation));


        // Ensure both stations are valid
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("One or both of the stations are invalid.");
            return;
        }

//        bridgeStation = JumpPoint1to3.get(0);
//        bridgeIndex = Line1.indexOf(bridgeStation);


        System.out.println("From " + lineNameAtStart + " to " + lineNameAtEnd + " :");
        printRoute(startIndex, endIndex, currentStation, endStation);
//        System.out.println(startLine + " " + startIndex + " " + endLine + " " + endIndex + " " + bridgeStation13 + " " + bridgeIndex13.get(1) + " " + bridgeIndex13.get(0));

//        int stationCount = Math.abs(endIndex - startIndex) + 1;
        String estimatedTime = convertMinutesToHours(stationCount * 4); // Assuming 2 minutes between each station
        int ticketPrice = calculateTicketPrice(stationCount);

        System.out.println("\nNO. of stations: " + stationCount + " \nEstimated time: " + estimatedTime + " (Assuming 4 minutes between each station) \nTicket Price: " + ticketPrice + " EG");


    }

//    private static int getStationCount(int startIndex,int endIndex){
//        if (!lineNameAtStart.equals("Line2") && !lineNameAtEnd.equals("Line2")){
//            // Line 1 + 3
//            stationCount = Math.abs(endIndex - startIndex) + 1;
//            return stationCount;
//        }
//    }

    private static void printRoute(int currentIndex, int endIndex, String startLineStation, String endLineStation) {
        if (!lineNameAtStart.equals("Line2") && !lineNameAtEnd.equals("Line2")) {
            // Line 1 + 3
            if (lineNameAtStart.equals("Line1") && lineNameAtEnd.equals("Line3")) {// line1 -> line3
                if (!data.contains(bridgeStation13)) {
                    data.add(Line1.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line1.get(currentIndex));
                        return;
                    }
                    System.out.print(Line1.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex13.get(0)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line3.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line3.get(currentIndex));
                        return;
                    }
                    System.out.print(Line3.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            } else if (lineNameAtStart.equals("Line3") && lineNameAtEnd.equals("Line1")) {// line3 -> line1
                if (!data.contains(bridgeStation13)) {
                    data.add(Line3.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line3.get(currentIndex));
                        return;
                    }
                    System.out.print(Line3.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex13.get(1)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line1.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line1.get(currentIndex));
                        return;
                    }
                    System.out.print(Line1.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            }
//            return;
        }

        if (!lineNameAtStart.equals("Line3") && !lineNameAtEnd.equals("Line3")) {
            // Line 1 + 2
            if (lineNameAtStart.equals("Line1") && lineNameAtEnd.equals("Line2")) {// line1 -> line2
                if (!data.contains(JumpPoint1to2.get(0)) && !data.contains(JumpPoint1to2.get(1))) {
                    data.add(Line1.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line1.get(currentIndex));
                        return;
                    }
                    System.out.print(Line1.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex12.get(0) || currentIndex < bridgeIndex12.get(1)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else if (currentIndex > bridgeIndex12.get(1) || currentIndex > bridgeIndex12.get(0)) {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line2.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line2.get(currentIndex));
                        return;
                    }
                    System.out.print(Line2.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            } else if (lineNameAtStart.equals("Line2") && lineNameAtEnd.equals("Line1")) {// line2 -> line1
                if (!data.contains(JumpPoint1to2.get(0)) && !data.contains(JumpPoint1to2.get(1))) {
                    data.add(Line2.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line2.get(currentIndex));
                        return;
                    }
                    System.out.print(Line2.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex12.get(2) || currentIndex < bridgeIndex12.get(3)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else if (currentIndex > bridgeIndex12.get(3) || currentIndex > bridgeIndex12.get(2)) {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line1.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line1.get(currentIndex));
                        return;
                    }
                    System.out.print(Line1.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            }
//            return;
        }

        if (!lineNameAtStart.equals("Line1") && !lineNameAtEnd.equals("Line1")) {
            // Line 2 + 3
            if (lineNameAtStart.equals("Line2") && lineNameAtEnd.equals("Line3")) { // line2 => line3
                if (!data.contains(bridgeStation23)) {
                    data.add(Line2.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line2.get(currentIndex));
                        return;
                    }
                    System.out.print(Line2.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex23.get(0)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line3.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line3.get(currentIndex));
                        return;
                    }
                    System.out.print(Line3.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            } else if (lineNameAtStart.equals("Line3") && lineNameAtEnd.equals("Line2")) {// line3 => line2
                if (!data.contains(bridgeStation23)) {
                    data.add(Line3.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line3.get(currentIndex));
                        return;
                    }
                    System.out.print(Line3.get(currentIndex) + " -> ");
                    if (currentIndex < bridgeIndex23.get(1)) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                } else if (!data.contains(endLineStation)) {
                    data.add(Line2.get(currentIndex));
                    if (currentIndex == endIndex) {
                        System.out.println(Line2.get(currentIndex));
                        return;
                    }
                    System.out.print(Line2.get(currentIndex) + " -> ");
                    if (currentIndex < endIndex) {
                        stationCount++;
                        printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
                    } else {
                        stationCount++;
                        printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
                    }
                }
            }
//            return;
        }


        if (lineNameAtStart.equalsIgnoreCase(lineNameAtEnd) && lineNameAtStart.equalsIgnoreCase("Line1")) {
            if (currentIndex == endIndex) {
                System.out.println(Line1.get(currentIndex));
                return;
            }
            System.out.print(Line1.get(currentIndex) + " -> ");
            if (currentIndex < endIndex) {
                stationCount++;
                printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
            } else {
                stationCount++;
                printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
            }

        } else if (lineNameAtStart.equalsIgnoreCase(lineNameAtEnd) && lineNameAtStart.equalsIgnoreCase("Line2")) {
            if (currentIndex == endIndex) {
                System.out.println(Line2.get(currentIndex));
                return;
            }
            System.out.print(Line2.get(currentIndex) + " -> ");
            if (currentIndex < endIndex) {
                stationCount++;
                printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
            } else {
                stationCount++;
                printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
            }

        } else if (lineNameAtStart.equalsIgnoreCase(lineNameAtEnd) && lineNameAtStart.equalsIgnoreCase("Line3")) {
            if (currentIndex == endIndex) {
                System.out.println(Line3.get(currentIndex));
                return;
            }
            System.out.print(Line3.get(currentIndex) + " -> ");
            if (currentIndex < endIndex) {
                stationCount++;
                printRoute(currentIndex + 1, endIndex, startLineStation, endLineStation);
            } else {
                stationCount++;
                printRoute(currentIndex - 1, endIndex, startLineStation, endLineStation);
            }
        } else {
            System.out.println("ERROR in printRoute method");
        }


    }

    // Method to find the index of a station (case-insensitive)
    private static int findStationIndex(String stationName, boolean checker) {
        // IN CASE one line
        if (Line1.contains(stationName)) {// search in Line1
            if (checker) {
                lineNameAtStart = "Line1";
            } else {
                lineNameAtEnd = "Line1";
            }
            return Line1.indexOf(stationName);
        } else if (Line2.contains(stationName)) {// search in Line2
            if (checker) {
                lineNameAtStart = "Line2";
            } else {
                lineNameAtEnd = "Line2";
            }
            return Line2.indexOf(stationName);
        } else if (Line3.contains(stationName)) {// search in Line3
            if (checker) {
                lineNameAtStart = "Line3";
            } else {
                lineNameAtEnd = "Line3";
            }
            return Line3.indexOf(stationName);
        }
        return -1;
    }

    // Method converts minutes to hours in Java.
    public static String convertMinutesToHours(int minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        long hours = duration.toHours();
        long remainingMinutes = duration.minusHours(hours).toMinutes();

        return minutes + " minutes is " + hours + " hours and " + remainingMinutes + " minutes.";
    }

    // Method to calculate the ticket price based on the number of stations
    private static int calculateTicketPrice(int stationCount) {
        if (stationCount >= 9 && stationCount != 0) {
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
