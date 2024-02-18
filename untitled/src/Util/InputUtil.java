package Util;

import java.util.Scanner;

public class InputUtil {

    Scanner sc;

    public InputUtil() {
        sc = new Scanner(System.in);
    }

    public String getValue(String label) {
        System.out.print(label +": ");

        String input = sc.nextLine();
        input = input.trim();

        return input;
    }
}
