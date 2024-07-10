package Metro;

import java.util.*;

public class metrooo {
    static ArrayList<String> routeStations = new ArrayList<>();
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
            if (startLine == -1) {
                System.out.println("PLEASE ENTER AGAIN\n ");
            }
        }

        while (endLine == -1) {
            System.out.println("Enter end station:");
            endStation = scanner.nextLine().trim().toLowerCase();
            endLine = findLine(endStation);
            if (endLine == -1) {
                System.out.println("PLEASE ENTER AGAIN\n ");
            }
        }

        List<List<String>> allPaths = findAllPaths(startStation, endStation);
        System.out.println("All possible paths from " + startStation.toUpperCase() + " to " + endStation.toUpperCase() + ":");

        for (List<String> path : allPaths) {
            System.out.println(path);
        }

        if (!allPaths.isEmpty()) {
            List<String> shortestPath = allPaths.get(0);
            System.out.println("\nShortest Path: " + shortestPath);
            System.out.println("Number of Stations: " + (shortestPath.size() - 1));
            int price = getPrice(shortestPath.size() - 1);
            System.out.println("Price: " + price + " EGP");
            calculateEstimatedTime(shortestPath.size() - 1);
        } else {
            System.out.println("No path found.");
        }
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

    public static List<List<String>> findAllPaths(String start, String end) {
        List<List<String>> paths = new ArrayList<>();
        List<List<String>> queue = new ArrayList<>();

        queue.add(Collections.singletonList(start));
        System.out.println(queue);

        while (!queue.isEmpty()) {
            List<String> path = queue.remove(0);
            String lastStation = path.get(path.size() - 1);

            if (lastStation.equals(end)) {
                paths.add(new ArrayList<>(path));
            } else {
                List<String> neighbors = getNeighbors(lastStation);
                for (String neighbor : neighbors) {
                    if (!path.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        return paths;
    }

    public static List<String> getNeighbors(String station) {
        List<String> neighbors = new ArrayList<>();
        List<String> lines = getLinesContainingStation(station);
        for (String line : lines) {
            List<String> lineStations = getLineStations(line);
            int index = lineStations.indexOf(station);
            if (index > 0) {
                neighbors.add(lineStations.get(index - 1));
            }
            if (index < lineStations.size() - 1) {
                neighbors.add(lineStations.get(index + 1));
            }
        }
        return neighbors;
    }

    public static List<String> getLinesContainingStation(String station) {
        List<String> lines = new ArrayList<>();
        if (line1.contains(station)) lines.add("line1");
        if (line2.contains(station)) lines.add("line2");
        if (line3.contains(station)) lines.add("line3");
        return lines;
    }

    public static List<String> getLineStations(String line) {
        switch (line) {
            case "line1":
                return line1;
            case "line2":
                return line2;
            case "line3":
                return line3;
            default:
                return Collections.emptyList();
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
        } else {
            System.out.println("Time: " + time + " minutes.");
        }
    }
}
