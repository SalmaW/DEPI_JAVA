package Metro;

import java.util.ArrayList;
import java.util.Arrays;

public class newBranch {
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
            "maspero", "zamalek", "kit kat", "sudan st.",
            "imbaba", "el bohy", "el qawmia", "ring road", "rod el farag corr"
    ));

    public static void main(String[] args) {
        printStations("adly mansour", "cairo university", line3);
    }

    static void printStations(String start, String end, ArrayList<String> line) {
        int startIndex = line.indexOf(start);
        int endIndex = line.indexOf(end);

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Start or end station not found on this line.");
            return;
        }

        int kitKatIndex = line.indexOf("kit kat");
        int tawfikiaIndex = line.indexOf("tawfikia");

        if (kitKatIndex != -1 && tawfikiaIndex != -1 && kitKatIndex < endIndex && tawfikiaIndex > startIndex) {
            for (int i = startIndex; i <= kitKatIndex; i++) {
                System.out.println(line.get(i));
            }
            for (int i = tawfikiaIndex; i <= endIndex; i++) {
                System.out.println(line.get(i));
            }
        } else {
            if (startIndex < endIndex) {
                for (int i = startIndex; i <= endIndex; i++) {
                    System.out.println(line.get(i));
                }
            } else {
                for (int i = startIndex; i >= endIndex; i--) {
                    System.out.println(line.get(i));
                }
            }
        }
    }


}



