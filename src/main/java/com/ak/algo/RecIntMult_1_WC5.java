package com.ak.algo;

import java.math.BigInteger;

public class RecIntMult_1_WC5 {


    public BigInteger intMult(BigInteger int1, BigInteger int2) {

        int int1_digitCount = getNbrOfDigits(int1);
        int int2_digitCount = getNbrOfDigits(int2);

        int nValue = splitValue(int1_digitCount,int2_digitCount);



        System.out.println("int1_digitCount\t" + int1_digitCount);
        System.out.println("int2_digitCount\t" + int2_digitCount);
        System.out.println("split Value\t" + nValue );

        if ((int1_digitCount <= 1) || (int2_digitCount <= 1))  {
            System.out.println("either number has one digit" + int1 + "\t" + int2 );
            return int1.multiply(int2);
        }
        else {
            BigInteger[] int1_a = splitNumber(int1, nValue);
            BigInteger[] int1_b = splitNumber(int2, nValue);

            System.out.println(int1_a[0].toString() + "\t" + int1_a[1].toString());
            System.out.println(int1_b[0].toString() + "\t" + int1_b[1].toString());

            BigInteger ac_a0b0 = intMult(int1_a[0],int1_b[0]);
            System.out.println("ac_a0b0\t" + ac_a0b0);

            BigInteger ad_a0b1 = intMult(int1_a[0],int1_b[1]);
            System.out.println("ad_a0b1\t" + ad_a0b1);

            BigInteger bc_a1b0 = intMult(int1_a[1],int1_b[0]);
            System.out.println("bc_a1b0\t" + bc_a1b0);

           BigInteger bd_a1b1 = intMult(int1_a[1],int1_b[1]);
           System.out.println("bd_a1b1\t" + bd_a1b1);


            System.out.println("nValue before compute\t" + nValue );

            BigInteger computedVal_step0 = ac_a0b0.multiply(BigInteger.TEN.pow(2* nValue));
            BigInteger computedVal_step1 = (ad_a0b1.add(bc_a1b0)).multiply(BigInteger.TEN.pow( nValue)); // how to calculate exponent
            BigInteger computedVal_step2 = bd_a1b1;

            System.out.println("computedVal_step0" + computedVal_step0);
            System.out.println("computedVal_step1" + computedVal_step1);
            System.out.println("computedVal_step2" + computedVal_step2);


            BigInteger finalComputedVal = computedVal_step0.add(computedVal_step1).add(computedVal_step2);



            System.out.println("Final Computed Value\t" + finalComputedVal);
            return finalComputedVal;

        }
    }

    private int splitValue( int int1_digitCount, int int2_digitCount ) {
        int split_val = 0;
        if(int1_digitCount > int2_digitCount) split_val = int1_digitCount/2;
        else split_val = int2_digitCount/2;
        return split_val;
    }

    private int calculateExponent(int int1_digitCount, int int2_digitCount) {
        return int1_digitCount > int2_digitCount ? int1_digitCount : int2_digitCount;
    }

    private BigInteger[] splitNumber( BigInteger val, int splitValue) {
        BigInteger divisor = BigInteger.TEN.pow(splitValue);
        BigInteger [] valArray= val.divideAndRemainder(divisor);
        /*System.out.println("val\t" + val);
        System.out.println("divisor\t" + divisor);
        System.out.println("valArray[0]\t" + valArray[0]);
        if(val.compareTo(divisor) > 0 && valArray[0].compareTo(BigInteger.ZERO) == 0) {
            valArray[0] = divisor;
        }*/
        return valArray;
    }

    private int getNbrOfDigits(BigInteger val) {
        double factor = Math.log(10)/Math.log(2); // # of bits required to make ten..
        int nbrOfDigits = 0;
        nbrOfDigits = (int) (val.bitLength() / factor) + 1;
        if (BigInteger.TEN.pow(nbrOfDigits - 1).compareTo(val) > 0) {
            --nbrOfDigits;
        }
        //System.out.println(nbrOfDigits);
        return nbrOfDigits;
    }

}