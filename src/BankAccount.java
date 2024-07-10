import java.util.Scanner;

public class BankAccount {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print("please enter the current money u have: ");
//        double money = s.nextDouble();
//        double moneyCal = money;
//        System.out.print("what is the percent of interest [enter the number in decimal form]: ");
//        double factor = s.nextDouble();
//        byte year = 1;
//        while (moneyCal < 5000) {
//            if (year != 5) {
//                double increase = moneyCal * factor;
//                moneyCal += increase;
//                System.out.println("year " + year + " u have " + moneyCal);
//                ++year;
//            } else if (year >= 5) { // money=>5 +10% of the original balance
//                double increaseProfit = moneyCal * 0.1;
//                moneyCal += increaseProfit;
//                System.out.println("the special year " + year + " u have " + moneyCal);
//                break;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print("enter money: ");
//        double money = s.nextDouble();
//        System.out.print("enter limit: ");
//        double limit = s.nextDouble();
//
//        if (money < limit) {
//            System.out.print("enter percent: ");
//            float percent = s.nextFloat();
//
//            if (percent >= 10 && percent <= 30) {
//                byte year = 0;
//                double initMoney = money;
//                while (money < limit) {
//                    year++;
//                    double increase = money * percent / 100;
//                    money += increase;
//                }
//                System.out.println(year);
//                System.out.println(money);
//
//                if (year >= 5) {
//                    double increase = initMoney * 10 / 100;
//                    money += increase;
//                }
//                System.out.println("Gold customer " + money);
//            } else {
//                System.out.println("Wrong percent");
//            }
//
//        } else {
//            System.out.println("Wrong inputs");
//        }
//
//    }

    public static void main(String[] args) {//much more clean code
        Scanner s = new Scanner(System.in);
        System.out.print("enter money: ");
        double money = s.nextDouble();
        System.out.print("enter limit: ");
        double limit = s.nextDouble();

        if (money > limit) {//it acts as a block to the bad input
            System.out.println("wrong inputs");
            return;
        }

        System.out.print("enter percent: ");
        float percent = s.nextFloat();

        if (percent > 30 || percent < 10) {//it acts as a block to the bad percent
            System.out.println("wrong percent");
            return;
        }

        byte year = 0;
        double initMoney = money;
        while (money < limit) {
            year++;
            double increase = money * percent / 100;
            money += increase;
        }
        System.out.println(year);
        System.out.println(money);

        if (year >= 5) {
            double increase = initMoney * 10 / 100;
            money += increase;
        }
        System.out.println("Gold customer " + money);
    }
}
