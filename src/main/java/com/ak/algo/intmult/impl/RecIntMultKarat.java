package com.ak.algo.intmult.impl;

import java.math.BigInteger;

import static com.ak.algo.intmult.util.RecIntMultUtility.*;

public class RecIntMultKarat {


    public BigInteger intMult(BigInteger int1, BigInteger int2) {
        int int1_digitCount = getNbrOfDigits(int1);
        int int2_digitCount = getNbrOfDigits(int2);

        int nValue = splitValue(int1_digitCount,int2_digitCount);

        if ((int1_digitCount <= 1) || (int2_digitCount <= 1))  {
            return int1.multiply(int2);
        }
        else {
            BigInteger[] int1_a = splitNumber(int1, nValue);
            BigInteger[] int1_b = splitNumber(int2, nValue);

            BigInteger ac_a0b0 = intMult(int1_a[0],int1_b[0]);
            BigInteger aAddB = int1_a[0].add(int1_a[1]);   // immplement (a + b) (c + d)  // a + b
            BigInteger cAddD = int1_b[0].add(int1_b[1]); // c + d
            BigInteger aAddB_cAddD = intMult(int1_a[0].add(int1_a[1]), int1_b[0].add(int1_b[1]));
            BigInteger bd_a1b1 = intMult(int1_a[1],int1_b[1]);
            BigInteger ad_bc = aAddB_cAddD.subtract(ac_a0b0.add(bd_a1b1));

            BigInteger computedVal_step0 = ac_a0b0.multiply(BigInteger.TEN.pow(2* nValue)); // you had n/2 of larger value so multiple by 2 to get n back
            BigInteger computedVal_step1 = ad_bc.multiply(BigInteger.TEN.pow( nValue)); // nValue is already n/2 so use as is.
            BigInteger computedVal_step2 = bd_a1b1;

            BigInteger finalComputedVal = computedVal_step0.add(computedVal_step1).add(computedVal_step2);

            System.out.println("Final Computed Value\t" + finalComputedVal);
            return finalComputedVal;

        }
    }

}