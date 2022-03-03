package com.ak.algo.intmult.impl.wc;

public class RecIntMult {

    private int intMult( int num1, int num2,String step) {
        int len1 = String.valueOf(num1).length();
        int len2 = String.valueOf(num2).length();
        if (len1 ==1 || len2 == 1) {
            return num1* num2;
        }
        int b = num1 % fastPow(10, (len1/2),1);
        int a = (num1 - b) / fastPow(10, (len1/2),1);


        int d = num2 % fastPow(10, (len1/2),1);
        int c = (num2 - d) / fastPow(10, (len1/2),1);


        System.out.println(step + "\t"+"first Num\t" + a + "second half\t" + b);
        System.out.println(step + "\t"+"Second Num\t" + c + "second half\t" + d);

        int step1 = intMult(a,c,"first");
        int step2 = intMult(a,d,"second");
        int step3 = intMult(b,c,"third");
        int step4 = intMult(b,d,"fourth");

        System.out.println("step1\t"+step1);
        System.out.println("step2\t"+step2);
        System.out.println("step3\t"+step3);
        System.out.println("step4\t"+step4);
        System.out.println("len is\t" + len1);
        int rslt = fastPow(10,len1,1) * step1 +
                fastPow(10,len1/2,1) * (step2 + step3) +
                step4;
        System.out.println(step + rslt);
        return rslt ;

        //ac 56 * 12 --- ad 56 * 34
        // bc bd
    }

    private int intMultK( int num1, int num2,String step) {
        System.out.println(step + "\t"+"first Num\t" + num1 + "second Num\t" + num2);
        int len1 = String.valueOf(num1).length();
        int len2 = String.valueOf(num2).length();
        if (len1 ==1 || len2 == 1) {
            return num1* num2;
        }
        int b = num1 % fastPow(10, (len1/2),1);
        int a = (num1 - b) / fastPow(10, (len1/2),1);


        int d = num2 % fastPow(10, (len1/2),1);
        int c = (num2 - d) / fastPow(10, (len1/2),1);


        System.out.println(step + "\t"+"first Num\t" + a + "second half\t" + b);
        System.out.println(step + "\t"+"Second Num\t" + c + "second half\t" + d);

        int step1 = intMultK(a,c,"first");
        //System.out.println("step1\t"+step1);
        int step2 = intMultK(a+b,c+d,"second");
        int step3 = intMultK(b,d,"third");


        /*System.out.println("step2\t"+step2);
        System.out.println("step3\t"+step3);*/

        step2 = step2 - step1 - step3;

        System.out.println("step1\t"+step1);
        System.out.println("step2\t"+step2);
        System.out.println("step3\t"+step3);

        int len = len1<len2?len2:len1;
        len = (len %2 ==0)?len : len-1;
        System.out.println("len is\t" + len);
        int rslt = fastPow(10,len,1) * step1 +
                fastPow(10,len/2,1) * step2 +
                step3;
        System.out.println(step + rslt);
        return rslt ;

        //ac 56 * 12 --- ad 56 * 34
        // bc bd
    }

    public static void main(String[] args) {
        RecIntMult x = new RecIntMult();

        /*System.out.println(x.intMult(5678,12345,""));

        System.out.println(x.intMultK(134,168,""));
        System.out.println(x.intMultK(5678,12345,""));

        System.out.println(x.intMultK(56782,1234,""));
        System.out.println(x.fastPow(2,10,1));*/
        System.out.println(x.intMultK(1000,999,""));
        //System.out.println(x.intMult(1158,999,""));
        //System.out.println(x.intMultK(1158,999,""));

        //System.out.println(x.intMultK(5670,567,""));

    }

    private int fastPow(int number, int power, int accum) {
        if (power == 0) {
            return accum;
        } else if (power % 2 == 1) {
            return fastPow(number, power - 1, accum*number) ;
        } else {
            return fastPow(number * number, power / 2,  accum);
        }
    }

}
