package com.sinotrans.hd.service;

import java.util.Date;

public class test {

    private static String numberToLetter(int num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);
        return letter;
    }

    private static String sqrt(Integer number){
        String result = null;
        double ceil = Math.ceil(Math.sqrt(number.doubleValue()));
        System.out.println(ceil);
        return result;
    }

    public static void main(String[] args) {
//        sqrt(121);
        System.out.println(new Date());
    }
}
