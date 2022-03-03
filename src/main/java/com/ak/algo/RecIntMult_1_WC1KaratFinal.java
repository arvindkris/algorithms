package com.ak.algo;

import java.math.BigInteger;

public class RecIntMult_1_WC1KaratFinal {


    public BigInteger intMult(BigInteger int1, BigInteger int2) {
        int int1_digitCount = getNbrOfDigits(int1);
        int int2_digitCount = getNbrOfDigits(int2);

        int nValue = splitValue(int1_digitCount,int2_digitCount);

        /*System.out.println("int1_digitCount\t" + int1_digitCount);
        System.out.println("int2_digitCount\t" + int2_digitCount);*/
        System.out.println("Initial  nValue\t" + nValue );

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
            //System.out.println("ac_a0b0\t" + ac_a0b0);

            // immplement (a + b) (c + d)
            // a + b
            BigInteger aAddB = int1_a[0].add(int1_a[1]);
            System.out.println("aAddB\t" + aAddB);
            // c + d
            BigInteger cAddD = int1_b[0].add(int1_b[1]);
            System.out.println("cAddD\t" + cAddD);

            BigInteger aAddB_cAddD = intMult(int1_a[0].add(int1_a[1]), int1_b[0].add(int1_b[1]));
            System.out.println("aAddB_cAddD\t" + aAddB_cAddD);


            BigInteger bd_a1b1 = intMult(int1_a[1],int1_b[1]);
           //System.out.println("bd_a1b1\t" + bd_a1b1);



            BigInteger ad_bc = aAddB_cAddD.subtract(ac_a0b0.add(bd_a1b1));
            //System.out.println("ad_a0b1\t" + ad_a0b1);




            System.out.println("nValue before compute\t" + nValue );

            BigInteger computedVal_step0 = ac_a0b0.multiply(BigInteger.TEN.pow(2* nValue)); // you had n/2 of larger value so multiple by 2 to get n back
            BigInteger computedVal_step1 = ad_bc.multiply(BigInteger.TEN.pow( nValue)); // nValue is already n/2 so use as is.
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
        return Integer.max(int1_digitCount,int2_digitCount) / 2;
    }

    private BigInteger[] splitNumber( BigInteger val, int splitValue) {
        BigInteger divisor = BigInteger.TEN.pow(splitValue);
        BigInteger [] valArray= val.divideAndRemainder(divisor);
        return valArray;
    }

    private int getNbrOfDigits(BigInteger val) {
        double factor = Math.log(10)/Math.log(2); // # of bits required to make ten..
        int nbrOfDigits = 0;
        nbrOfDigits = (int) (val.bitLength() / factor) + 1;
        if (BigInteger.TEN.pow(nbrOfDigits - 1).compareTo(val) > 0) {
            --nbrOfDigits;
        }
        return nbrOfDigits;
    }

}
