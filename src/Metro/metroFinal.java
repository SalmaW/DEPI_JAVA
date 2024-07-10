package Metro;

import java.util.*;

public class metroFinal {

    public static ArrayList<String> routeStations = new ArrayList<>(); //TODO: change type to LinkedHashSet
    static ArrayList<String> line1 = new ArrayList<>(Arrays.asList(
            "helwan", "ain helwan", "helwan university", "wadi hof", "hadayek helwan",
            "el-maasara", "tora el-balad", "kozzika", "tora el-asmant", "el-maadi",
            "hadayeq el-maadi", "thakanat el-maadi", "dar el-salam", "el-zahraa",
            "mar girgis", "el-malek el-saleh", "al-sayeda zeinab", "saad zaghloul",
            "sadat", "nasser", "orabi", "al shohadaa", "ghamra", "el-demerdash",
            "manshiet el-sadr", "kobri el-qobba", "hammamat el-qobba", "saray el-qobba",
            "hadayeq el-zaitoun", "helmeyet el-zaitoun", "el-matareyya", "ain shams",
            "ezbet el-nakhl", "el-marg", "new el-marg"
    ));
    static ArrayList<String> line2 = new ArrayList<>(Arrays.asList(
            "el mounib", "sakiat mekki", "omm el misryeen", "giza", "faisal",
            "cairo university", "bohooth", "dokki", "opera", "sadat", "naguib",
            "ataba", "al shohadaa", "massara", "road el-farag", "sainte teresa",
            "khalafawy", "mezallat", "koliet el-zeraa", "shobra el kheima"
    ));
    static ArrayList<String> line3 = new ArrayList<>(Arrays.asList(
            "adly mansour", "hikestep", "omar ibn al khattab", "kebaa", "hisham barakat",
            "el nozha", "el shames club", "alf maskan", "heliopolis", "haroun",
            "al ahram", "koleyet el banat", "cairo stadium", "fair zone", "abbassiya",
            "abdou pasha", "el geish", "bab el shaaria", "ataba", "nasser",
            "maspero", "nasser", "zamalek", "kit kat", "sudan st.", "imbaba",
            "el bohy", "el qawmia", "ring road", "rod el farag corr"
    ));

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int startLine = -1;
        int endLine = -1;
        String startStation = "";
        String endStation = "";

        while (startLine == -1) {
            System.out.println("Enter start station:");
            startStation = scanner.nextLine().trim().toLowerCase();
            startLine = findLine(startStation);
//            System.out.println(startLine);
            if (startLine == -1) {
                System.out.println("PLEASE ENTER AGAIN\n ");
            }
        }

        while (endLine == -1) {
            System.out.println("Enter end station:");
            endStation = scanner.nextLine().trim().toLowerCase();
            endLine = findLine(endStation);
//            System.out.println(endLine);
            if (endLine == -1) {
                System.out.println("PLEASE ENTER AGAIN\n ");
            }
        }

        ArrayList<String> startLineName = getLineName(startLine);
        ArrayList<String> endLineName = getLineName(endLine);


        String interchangeStation = getInterchangeStation(startLine, endLine, startStation, startLineName);
        int interchangeLine = findLine(interchangeStation);
        ArrayList<String> interchangeLineName = getLineName(interchangeLine);

        if (startLine == endLine) {
            System.out.println("Take Line " + startLine + " from " + startStation.toUpperCase() + " to " + endStation.toUpperCase()
                    + " Direction:  " + getDirection(startStation, endStation, startLineName, endLineName).toUpperCase()
            );
            printStations(startStation, endStation, startLine);

        } else {
            System.out.println("Take Line " + startLine + " from -" + startStation.toUpperCase() + "- to -" + interchangeStation.toUpperCase() + "- :" +
                    " Direction:  " + getDirection(startStation, interchangeStation, startLineName, interchangeLineName).toUpperCase());
            printStations(startStation, interchangeStation, startLine);
            System.out.println(" ");
            System.out.println("\nChange to Line " + endLine + " and from -" + interchangeStation.toUpperCase() + "- to -" + endStation.toUpperCase() + "- :" +
                    " Direction:  " + getDirection(interchangeStation, endStation, interchangeLineName, endLineName).toUpperCase());

            printStations(interchangeStation, endStation, endLine);
            System.out.println(" ");
        }
//        int count = countStations(startStation, endStation, interchangeStation, startLine, endLine);
        int count = routeStations.size() - 1;
        System.out.println("\nNumber Of Stations: " + count);
        int price = getPrice(count);
        System.out.println("Price: " + price + " EGP");
        calculateEstimatedTime(count);
    }


    public static int findLine(String station) {
        if (line1.contains(station)) {
            return 1;
        } else if (line2.contains(station)) {
            return 2;
        } else if (line3.contains(station)) {
            return 3;
        }
        return -1; // Station not found
    }

    public static String shortestPath(int startLine, int endLine, String startStation, ArrayList<String> startLineName) {
        String interchangeStation = "sadat";

        if ((startLine == 1 && endLine == 2) || (startLine == 2 && endLine == 1)) {
            int startStationIndex = startLineName.indexOf(startStation);
            int shohadaIndex = startLineName.indexOf("al shohadaa");

            int interchangeStation1 = Math.abs(startStationIndex - shohadaIndex);
            int sadatIndex = startLineName.indexOf("sadat");
            int interchangeStation2 = Math.abs(startStationIndex - sadatIndex);

            if (interchangeStation1 < interchangeStation2) {
                interchangeStation = "al shohadaa";
            }
        }
        return interchangeStation;
    }

    public static String getDirection(String startStation, String endStation, ArrayList<String> startLine, ArrayList<String> endLine) {
        String direction = "";
        // int startIndex = startLine.indexOf(startStation);
        int endIndex = endLine.indexOf(endStation);

        int numOfStationsBetweenEndStationAndFirstElement = Math.abs(endIndex - endLine.indexOf(0));
        int numOfStationsBetweenEndStationAndLastElement = Math.abs(endIndex - endLine.size() - 1);

        if (numOfStationsBetweenEndStationAndFirstElement < numOfStationsBetweenEndStationAndLastElement) {
            direction = endLine.get(0);
        } else {
            direction = startLine.get(endLine.size() - 1);
        }
//        System.out.println(numOfStationsBetweenEndStationAndFirstElement);
//        System.out.println(numOfStationsBetweenEndStationAndLastElement);
        return direction;
    }

    public static String getInterchangeStation(int startLine, int endLine, String startStation, ArrayList<String> startLineName) {
        // Interchange stations for each line
        String interchangeStations = "";
        if ((startLine == 1 || endLine == 1) && (startLine == 2 || endLine == 2))
            interchangeStations = shortestPath(startLine, endLine, startStation, startLineName);//1&2
        else if ((startLine == 2 || endLine == 2) && (startLine == 3 || endLine == 3))
            interchangeStations = "ataba";//2&3
        else if ((startLine == 1 || endLine == 1) && (startLine == 3 || endLine == 3))
            interchangeStations = "nasser";//1&3

        return interchangeStations;
    }

    public static ArrayList<String> getLineName(int line) {//TODO: change to if Condition + see the ((Collictions.reverse))
        switch (line) {
            case 1:
                return line1;
            case 2:
                return line2;
            case 3:
                return line3;
            default:
                return null;
        }
    }

    public static void printStations(String startStation, String endStation, int line) {
        ArrayList<String> lineStations = getLineName(line);
        int startIndex = lineStations.indexOf(startStation);
        int endIndex = lineStations.indexOf(endStation);
        if (startIndex <= endIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(lineStations.get(i));
                routeStations.add(lineStations.get(i));
                if (i < endIndex) {
                    System.out.print(" -> ");
                }
            }
        } else {
            for (int i = startIndex; i >= endIndex; i--) {
                System.out.print(lineStations.get(i));
                routeStations.add(lineStations.get(i));
                if (i > endIndex) {
                    System.out.print(" -> ");
                }
            }
        }

    }

    public static int getPrice(int numberOfStations) {
        if (numberOfStations <= 9) {
            return 6;
        } else if (numberOfStations <= 16) {
            return 8;
        } else if (numberOfStations <= 23) {
            return 12;
        } else {
            return 15;
        }
    }

    public static void calculateEstimatedTime(int numberOfStations) {
        int time = numberOfStations * 3;
        if (time > 60) {
            int hours = time / 60;
            int minutes = time % 60;
            System.out.println("Time: " + hours + " Hours and " + minutes + " minutes.");
        } else
            System.out.println("Time: " + time + " minutes.");

    }
}
