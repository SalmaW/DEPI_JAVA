package Book;

import java.util.Scanner;

public class book {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("please enter the 1 value: ");
        int value1 = input.nextByte();
        System.out.print("please enter the 2 value: ");
        int value2 = input.nextByte();

        int sum = value1 + value2;

        System.out.printf("Sum is: %d%n", sum);

    }
}
