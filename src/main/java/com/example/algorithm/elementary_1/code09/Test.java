package com.example.algorithm.elementary_1.code09;

public class Test {
    public static void main(String[] args) {
        String str = "X....XX..X...XXXXX";
        char[] chars = str.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length()) {
            if (chars[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length()) {
                    break;
                } else {
                    if (chars[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        System.out.println(light);
    }
}
