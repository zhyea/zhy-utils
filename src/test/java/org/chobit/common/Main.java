package org.chobit.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());

        List<String> result = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            int len = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();

            String r = compute(len, s);
            result.add(r);
        }

        result.forEach(System.out::println);
    }


    private static String compute(int len, String biStr) {
        while (true) {
            if (!hasOneMoreZero(biStr)) {
                break;
            }
            String[] arr = takeStartOne(biStr);
            biStr = arr[1];
            if (biStr.contains("10")) {
                biStr = biStr.replaceAll("10", "01");
            }
            if (biStr.contains("00")) {
                biStr = biStr.replaceAll("00", "10");
            }
            biStr = arr[0] + biStr;
        }
        return biStr;
    }


    private static String[] takeStartOne(String s) {
        if (!s.startsWith("1")) {
            return new String[]{"", s};
        }
        String b = "1";
        s = s.substring(1);
        while (s.startsWith("1") && s.length() > 1) {
            b += "1";
            s = s.substring(1);
        }
        return new String[]{b, s};
    }

    private static boolean hasOneMoreZero(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == '0') {
                if (++count > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}