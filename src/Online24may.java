import java.util.*;

public class Online24may {
    public static void main(String[] args) {
        //set data structure -> no duplicate, no order
        Scanner s = new Scanner(System.in);

//        List<String> list = new Arrays.asList("ahmed", "wael", "amal", "salma");

//        HashSet<String> data = new HashSet<>(list);
// HashSet good to perform => no duplication & no sorting

//        data.add("ahmed");
//        data.add("salma");
//        data.add("amal");
//        data.add("wael");

//        LinkedHashMap lindedSet = new LinkedHashMap(list);
// LinkedHashMap good to perform => no duplication & sorting | not strong type | useful when data is known and fixed

//        HashMap<String, String> data2 = new HashMap<>();
//        data2.put("egypt", "cairo");//entry
//        data2.put("usa", "ws");
//        data2.put("franc", "paris");
//        data2.put("uk", "london");
//
//        System.out.println(data2);
//
//        byte score = 0;
//
//        for (Map.Entry<String, String> entry : data2.entrySet()) {
//            System.out.println("what is the capital of " + data2.keySet());
//            String answer = s.next();
//            score++;
//        }
//
//        System.out.println(score);

        String name = "i love android and flutter";

        String[] words = name.split(" ");
        List<String> connectWordsLIST = Arrays.asList("and", "a", "an", "or", "in", "on", "at");
        LinkedHashSet<String> connectWordsHASH = new LinkedHashSet<>(connectWordsLIST);

//        for (String word : words) {
//            System.out.println(word + " " + word.length());
//        }

//        for (String word : words) {
//            if (!word.equals("and"))
//                System.out.println(word + " " + word.length());
//        }
//        for (String word : words) {
//            if (!connectWordsLIST.contains(word))
//                System.out.println(word + " " + word.length());
//        }
        for (String word : words) {
            if (!connectWordsHASH.contains(word))
                System.out.println(word + " " + word.length());
        }

    }

}
