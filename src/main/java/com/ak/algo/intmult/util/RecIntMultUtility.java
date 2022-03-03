package com.ak.algo.intmult.util;

import java.math.BigInteger;

public final class RecIntMultUtility {

    private RecIntMultUtility() {
        throw new AssertionError();
    }
    public static int splitValue( int int1_digitCount, int int2_digitCount ) {
        return Integer.max(int1_digitCount,int2_digitCount) / 2;
    }

    public static BigInteger[] splitNumber(BigInteger val, int splitValue) {
        BigInteger divisor = BigInteger.TEN.pow(splitValue);
        BigInteger [] valArray= val.divideAndRemainder(divisor);
        return valArray;
    }

    public static int getNbrOfDigits(BigInteger val) {
        double factor = Math.log(10)/Math.log(2); // # of bits required to make ten..
        int nbrOfDigits = 0;
        nbrOfDigits = (int) (val.bitLength() / factor) + 1;
        if (BigInteger.TEN.pow(nbrOfDigits - 1).compareTo(val) > 0) {
            --nbrOfDigits;
        }
        return nbrOfDigits;
    }
}
