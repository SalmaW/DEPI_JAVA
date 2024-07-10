import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("what is ur name?");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        System.out.println("what time of day right now?");
        String day = s.next();
        String stat = "";
        if(day.equalsIgnoreCase("morning") || day.equalsIgnoreCase("evening")){
            stat = "good "+ day;
        } else {
            stat = "hi "+ name;
        }
        System.out.println("how old r u?");
        byte age = s.nextByte();
        System.out.println(stat);
        if(age<=0){
            stat = "wrong age "+name;
        } else if (age >= 20 && age <=30){
            stat = "ur young "+name;
        } else if (age >30){
            stat = "ur getting old "+name;
        }
        System.out.println(stat);
    }
//        public static void main(String[] args) {
//        System.out.println("what is ur name?");
//        Scanner s = new Scanner(System.in);
//        String name = s.next();
//        System.out.println("what time of day right now?");
//        String day = s.next();
//        String stat = "";
//        switch (day.toLowerCase()){
//            case "morning":
//            case "evening":
//                System.out.println("how old r u?");
//                byte age = s.nextByte();
//
//                    if(age<=0){
//                        stat = "wrong age "+name;
//                    } else if (age >= 20 && age <=30){
//                        stat = "ur young "+name;
//                    } else if (age >30){
//                        stat = "ur getting old "+name;
//                    }
//                System.out.println("good "+day+" "+name+" "+stat);
//                    break;
//            default:
//                System.out.println("how old r u?");
//                    if(age<=0){
//                        stat = "wrong age "+name;
//                    } else if (age >= 20 && age <=30){
//                        stat = "ur young "+name;
//                    } else if (age >30){
//                        stat = "ur getting old "+name;
//                    }
//                System.out.println("good "+day+" "+name+" "+stat);
//        }
//    }
}

/*_____Online Session____*/
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("what is ur name?");
//        Scanner s = new Scanner(System.in);
//        String name = s.next();
//        System.out.println("what time of day right now?");
//        String day = s.next();
//        String stat = "";
//        if(day.equalsIgnoreCase("morning") || day.equalsIgnoreCase("evening")){
//            stat = "good "+ day;
//        } else {
//            stat = "hi "+ name;
//        }
//        System.out.println("how old r u?");
//        byte age = s.nextByte();
//        System.out.println(stat);
//        if(age<=0){
//            stat = "wrong age "+name;
//        } else if (age >= 20 && age <=30){
//            stat = "ur young "+name;
//        } else if (age >30){
//            stat = "ur getting old "+name;
//        }
//        System.out.println(stat);
//
//        if(age>=20) {
//            System.out.println("r u married?");
//            String socialStates = s.next();
//            if(socialStates.equals("yes")){
//                System.out.println("how many boys do u have?");
//                byte noOfBoys = s.nextByte();
//                System.out.println("how many girls do u have?");
//                byte noOfGirls = s.nextByte();
//                int onOfChildren = noOfBoys + noOfGirls;
//                System.out.println("u have "+onOfChildren+" kids");
//            } else
//                System.out.println("thanks");
//        }
//    }
//}
