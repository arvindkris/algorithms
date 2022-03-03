package com.test.algo;

import java.math.BigInteger;

public class RecIntMult_1_WC1 {
    public static void main(String[] args) {
        RecIntMult_1_WC1 mult  = new RecIntMult_1_WC1();
        String num1 = "156";
        String num2 = "9999";
        BigInteger int1 = new BigInteger(num1);
        BigInteger int2 = new BigInteger(num2);

        mult.intMult(int1,int2);

    }

    private BigInteger intMult(BigInteger int1, BigInteger int2) {
        /*int length = (int) (Math.log10(int1. + 1);
        alignLength(num1,num2);
        System.out.println(num1);

        BigInteger int1 = new BigInteger(num1);
        BigInteger int2 = new BigInteger(num2);*/
        getNbrOfDigits(int1);
        getNbrOfDigits(int2);
        /*int split_a = getNbrOfDigits(int1)/2 + getNbrOfDigits(int1)%2;

        int split_c = getNbrOfDigits(int2)/2 + getNbrOfDigits(int2)%2;
        //BigInteger int1_a = BigInteger.TEN.pow(split_a);*/

        //BigInteger int1_a = int1.divide(BigInteger.TEN.pow(split_a));
        //BigInteger [] int1_a = int1.divideAndRemainder(BigInteger.TEN.pow(split_a));
        //BigInteger [] int1_c = int2.divideAndRemainder(BigInteger.TEN.pow(split_c));

        BigInteger [] int1_a = splitNumber(int1,getNbrOfDigits(int1));
        BigInteger [] int1_b = splitNumber(int2,getNbrOfDigits(int2));

        //System.out.println(int1_a.toString() );
        System.out.println(int1_a[0].toString() + "\t" + int1_a[1].toString());

        System.out.println(int1_b[0].toString() + "\t" + int1_b[1].toString());



        return new BigInteger("1");
    }

    private BigInteger[] splitNumber( BigInteger val, int nbrOfDigits) {
        int split_val = getNbrOfDigits(val)/2 + getNbrOfDigits(val)%2;
        BigInteger [] valArray= val.divideAndRemainder(BigInteger.TEN.pow(split_val));
        return valArray;
    }

    private int getNbrOfDigits(BigInteger val) {
        double factor = Math.log(10)/Math.log(2); // # of bits required to make ten..
            // sometimes you can reverse the logs and make factor a multiplication to nbr of digits
        //if double factor = Math.log(2)/Math.log(10);
        /* EX :::: nbrOfDigits = (int) (val.bitLength() * factor) + 1;
        if (BigInteger.TEN.pow(nbrOfDigits - 1).compareTo(val) > 0) {
           --nbrOfDigits;
        }*/
        int nbrOfDigits = 0;
        System.out.println(factor + "\tbit length" + val.bitLength() );

        nbrOfDigits = (int) (val.bitLength() / factor) + 1;
        if (BigInteger.TEN.pow(nbrOfDigits - 1).compareTo(val) > 0) {
            //from 8193 to 10000+ bit length is 14 which comes as 5 digits but anything less than 10k is 4 digits
            // hence this accounts for that
            --nbrOfDigits;
        }
        System.out.println(nbrOfDigits);
        return nbrOfDigits;
    }

    private void alignLength(String num1, String num2) {
        int padZeroes = num1.length() - num2.length() ;
        if (padZeroes > 0) num2 = padStart(num2,padZeroes,"0") ;
        else num1 = padStart(num1,Math.abs(padZeroes),"0");
        System.out.println(num1);
    }

    private String padStart(String s, int padLength, String padChar) {

        StringBuffer strBuf = new StringBuffer(padLength);
        strBuf.replace(0,padLength,padChar);
        if (s != null)  strBuf.append(s);
        System.out.println(strBuf);
        return strBuf.toString();
    }

}
