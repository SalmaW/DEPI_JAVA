package offline26may;

import java.util.*;

public class movie {
    //    movie and the category - map + while + most searched movies
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String exite = "";
        do {
            System.out.println("if you wish to NOT continue write -exit-");
            System.out.print("please enter a movie/category: ");
            String userInput = s.nextLine();

            HashMap<String, List<String>> movies = new HashMap();
            movies.put("horror", Collections.singletonList("it, A Quiet Place, scream, anabela"));//entry
            movies.put("comedy", Collections.singletonList("grown ups, The Idea of You, A Simple Favor, Hit Man"));
            movies.put("romance", Collections.singletonList("titanic, notebook, The Idea of You, challengers"));
            movies.put("drama", Collections.singletonList("notebook, A Quiet Place, godfather, forest jump, The Idea of You"));

//            for (Map.Entry<String, List<String>> entry : movies.entrySet()) {
//                System.out.println(movies.get(userInput));
//                System.out.println(Collections.singletonList(movies));
//
//                String answer = s.next();
//            }
            String key = null;
            for (Map.Entry<String, List<String>> entry : movies.entrySet()) {
                if (entry.getKey().equals(userInput)) {
                    List<String> vl = Collections.singletonList(entry.getKey());
                    System.out.println(vl);
                    key = entry.getKey();
                    break;
                }
            }
//            String method = getCategoryFromValue(movies, userInput);

            System.out.println(key);

        } while (!exite.isEmpty());

    }

//    public static String getCategoryFromValue(HashMap<String, List<String>> hashMap, List<String> targetValue) {
//        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
//            if (entry.getKey().equals(targetValue)) {
//                return entry.getKey();
//            }
//        }
//        return null; // If no matching key is found
//    }
}