import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class offline12may {
    public static void main(String[] args) {
        /*Scanner s = new Scanner(System.in);

        String[] names = {"cairo", "alex", "giza", "tanta", "banha"};
        String[] copy = {"cairo", "alex", "giza", "tanta", "banha"};

        byte[] scores = new byte[3];

        for (int j = 0; j < 3; j++) {//j for players
            byte score = 0;
            System.out.println("enter 3 cities in Egypt");
            System.out.println("player " + (j + 1));
            for (int k = 0; k < 3; k++) {//k for trials
                System.out.print("enter city no " + k + ": ");
                String answer = s.next();
                for (int i = 0; i < names.length; i++) { //k for scores
                    if (names[i].equalsIgnoreCase(answer)) {
                        score++;
                        names[i] = "";//erase duplication
                        break;
                    }
                }
            }
            System.arraycopy(copy, 0, names, 0, names.length);//it returns the main array to its original state
            /*
            for(int i =1; i<scores.length; i++){
                if(scores[i]>max){
                    max = scores[i];
                    index = i;
                }
            }


            System.out.println("player " + (j + 1) + " your score is: " + score);
        }
        //max
        byte max = scores[0];
        byte count = 0;
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                index = 1;
            }
        }

        //count max
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) count++;
        }
        if (count > 1) System.out.println("tie");
        else System.out.println("player " + (index + 1) + " with high score: " + max);

        //task - the game will counties only between the tie players the second tie the player will be chosen RANDOM(if possible) NOTE best performance

         */

        ArrayList<String> data = new ArrayList<>();
        data.add("salma");
        data.add("alaa");
        data.add("mai");
        data.add("wael");
        data.add("amal");

        data.add(3, "wael");

        data.remove("alaa");
        data.set(1, "ahmed");

        System.out.println(data.get(2));


        if (data.contains("salma")) System.out.println("found");
        else System.out.println("not found");

        if (data.contains("salma")) {
            int index = data.indexOf("salma");
            System.out.println("found in: " + index);
        } else System.out.println("not found");

        ArrayList<String> data2 = new ArrayList<>();
        data.addAll(data2);
//        data.removeAll(data2);
        System.out.println(data);

        System.out.println(data.subList(1, 2));

        List<String> list = List.of("saaied", "mo");

        List<String> list2 = List.of("tarek");

        //iterate with the element - inhanced for
        for (String name : list) {
            System.out.println(name);
        }

        //project in groups == metro --WITH no loop, 2 ways of the line--
        //collicions.reverse();
        /*
         * enter start station (one line) ->
         * enter arrival ->
         * output: count of stations
         * output: time
         * output: preferable tiket type
         * output: the route with stations
         * output: the route name
         *
         *
         *
         */


    }
}
