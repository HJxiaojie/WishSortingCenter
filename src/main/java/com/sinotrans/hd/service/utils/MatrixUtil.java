package com.sinotrans.hd.service.utils;

public class MatrixUtil {

    private String numberToLetter(int num) {
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

    public Double makeSqrt(Integer number){
        return Math.ceil(Math.sqrt(number.doubleValue()));
    }

    public String toMatrix(Integer number){
        Double a=Math.ceil(Math.sqrt(number.doubleValue()));
        String first= numberToLetter(a.intValue());
        Double a2 = number-Math.pow((a-1),2);
        Integer b=a2.intValue();
        return first+b.toString();
    }

    public String toXMatrix(Integer number){
        Double a=Math.ceil(Math.sqrt(number.doubleValue()));
        return numberToLetter(a.intValue());
    }

    public Integer toXMatrixInt(Integer number){
        Double a=Math.ceil(Math.sqrt(number.doubleValue()));
        return a.intValue();
    }

    public String toYMatrix(Integer number){
        Double a=Math.ceil(Math.sqrt(number.doubleValue()));
        Double a2 = number-Math.pow((a-1),2);
        Integer b=a2.intValue();
        return b.toString();
    }

    public Integer toYMatrixInt(Integer number){
        Double a=Math.ceil(Math.sqrt(number.doubleValue()));
        Double a2 = number-(a*(a-1));
        Integer b=a2.intValue();
        return b;
    }

}
