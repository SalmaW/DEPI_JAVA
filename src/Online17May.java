import java.util.*;

/*public class Online17May {
    public static void main(String[] args) {
        String[] namesArr = {"salma","wael","ahmed","amal","laila"};
        List<String> namesList = Arrays.asList("hossam", "ramy", "omar");
        if(namesList.contains("ramy")){
            System.out.println(namesList.indexOf("ramy"));
        }

        ArrayList<String> namesAL = new ArrayList<>();
        namesAL.add("sultan");//expensive O(n)
        namesAL.add("said");
        namesAL.add("tamer");

        System.out.println(namesAL);// cheap O(1)

        LinkedList<String> lk = new LinkedList<>();
        lk.add("bassel");//cheap O(1)
        lk.add("kamel");
        lk.add("mohamed");

        System.out.println(namesAL);// expensive O(n)
    }
}*/


/*public class Online17May {
    public static void main(String[] args) {
        String[] namesArr = {"salma", "wael", "ahmed", "amal", "laila"};
        Arrays.sort(namesArr);//order alphabetically

        //O(log n) => fast, the data must be sorted in advanced. without the sort the result is unexpected
        //System.out.println(Arrays.binarySearch(namesArr, "laila"));

        String[] copy = new String[namesArr.length];
        copy = Arrays.copyOf(namesArr, 2);// copys the array faster

        Arrays.fill(copy, "");
        System.out.println(Arrays.toString(namesArr));
        System.out.println(Arrays.toString(copy));

    }
}*/

public class Online17May {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("hossam", "ramy", "omar");
        ArrayList<String> namesL = new ArrayList<>();
//        namesL.add("salma");
//        namesL.add("wael");

        Collections.addAll(namesL, "salma", "amal");
        Collections.sort(namesList);
        //individual

        System.out.println(Collections.binarySearch(namesList, "ramy"));


        System.out.println(namesList);

    }
}