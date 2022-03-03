package com.ak.algo.intmult.wc;

import com.ak.algo.intmult.impl.wc.RecIntMult_1_WC5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RecIntMult_1_WC5Test {

    private final RecIntMult_1_WC5 wc5_mult = new RecIntMult_1_WC5();

    @BeforeEach
    void setUp() {
    }



    @AfterEach
    void tearDown() {
    }
    static Stream<Arguments> nbrToMultiply() {
        return Stream.of(
                arguments(new BigInteger("156"), new BigInteger("9999"),new BigInteger("1559844")),
                arguments(new BigInteger("56"), new BigInteger("9999"),new BigInteger("559944")),
                arguments(new BigInteger("134"), new BigInteger("5678"),new BigInteger("760852")),
                arguments(new BigInteger("156"), new BigInteger("10000"),new BigInteger("1560000")),
                arguments(new BigInteger("156"), new BigInteger("12345"),new BigInteger("1925820")),
                arguments(new BigInteger("156"), new BigInteger("345"),new BigInteger("53820")),
                arguments(new BigInteger("56"), new BigInteger("25"),new BigInteger("1400")),
                arguments(new BigInteger("10000"), new BigInteger("10"),new BigInteger("100000")),
                arguments(new BigInteger("156"), new BigInteger("12345"),new BigInteger("1925820")),
                arguments(new BigInteger("1234098761234567"), new BigInteger("1234098761234567"),new BigInteger("1522999752480692809197995677489"))
        );
    }

    @ParameterizedTest

    @MethodSource("nbrToMultiply")
    void intMult( BigInteger int1, BigInteger int2 , BigInteger actualResult) {

        BigInteger computedResult = wc5_mult.intMult(int1,int2);
        assertThat(computedResult).isEqualByComparingTo(actualResult);

    }
}