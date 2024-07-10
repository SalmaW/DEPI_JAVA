//public class test {
//    public static void main(String[] args) {
//        int x = 10;
//        int y = x++ * 2 + --x - x-- % 2;
//        int z = ++x + (x-- % 3) * y;
//        int result = x + y + z;
//        System.out.println(result);
//    }
//}

import java.util.*;

public class test {

    public static String numberofBills(Integer[] billCount, String[] billValue, Integer withdrawAmount) {
        List<Pair> bills = new ArrayList<>();
        for (int i = 0; i < billValue.length; i++) {
            bills.add(new Pair(Integer.parseInt(billValue[i]), billCount[i]));
        }

        Collections.sort(bills, (a, b) -> Integer.compare(b.key, a.key));

        List<Pair> result = new ArrayList<>();
        int amountLeft = withdrawAmount;

        for (Pair bill : bills) {
            int value = bill.key;
            int count = bill.value;
            if (amountLeft == 0) {
                break;
            }
            if (value <= amountLeft && count > 0) {
                int numBills = Math.min(amountLeft / value, count);
                if (numBills > 0) {
                    result.add(new Pair(value, numBills));
                    amountLeft -= value * numBills;
                }
            }
        }

        if (amountLeft > 0) {
            return "-1";
        }

        StringBuilder resultStr = new StringBuilder();
        for (Pair bill : result) {
            resultStr.append(bill.key).append("x").append(bill.value).append(",");
        }
        // Remove the last comma
        if (resultStr.length() > 0) {
            resultStr.deleteCharAt(resultStr.length() - 1);
        }

        return resultStr.toString();
    }

    public static void main(String[] args) {
        Integer[] billCount = {0, 3, 1, 1, 1};
        String[] billValue = {"5", "10", "20", "50", "100"};
        Integer withdrawAmount = 70;

        System.out.println(numberofBills(billCount, billValue, withdrawAmount));  // Output: 50x1,20x1,10x2,2x2,1x1
    }

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
