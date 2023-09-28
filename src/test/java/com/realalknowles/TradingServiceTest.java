package com.realalknowles;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TradingServiceTest {

    private final TradingService tradingService = new TradingService();

    @ParameterizedTest
    @MethodSource("shouldNotTradeWhenThereAreNoPricesInputs")
    void shouldNotTradeWhenThereAreNoPrices(long[] prices) {
        // When
        long income = tradingService.tradeOptimally(prices);

        // Then
        assertThat(income).isEqualTo(0);
    }

    @MethodSource
    private static Stream<long[]> shouldNotTradeWhenThereAreNoPricesInputs() {
        return Stream.of(null, new long[]{});
    }

    @ParameterizedTest
    @MethodSource("shouldTradeOptimallyWhenThereArePrices")
    void shouldTradeOptimallyWhenThereArePrices(long[] prices, long earnings) {
        // When
        long income = tradingService.tradeOptimally(prices);

        // Then
        assertThat(income).isEqualTo(earnings);
    }

    private static Stream<Arguments> shouldTradeOptimallyWhenThereArePrices() {
        return Stream.of(
                Arguments.of(new long[]{1}, 1),
                Arguments.of(new long[]{2, 1}, 2),
                Arguments.of(new long[]{2, 2}, 2),
                Arguments.of(new long[]{1, 2}, 2),
                Arguments.of(new long[]{1, 2, 1}, 2),
                Arguments.of(new long[]{1, 2, 1, 2}, 3),
                Arguments.of(new long[]{1, 2, 1, 2, 1}, 3),
                Arguments.of(new long[]{1, 2, 1, 2, 2}, 3),
                Arguments.of(new long[]{1, 4, 2, 3, 5, 1, 1}, 7),
                Arguments.of(new long[]{1, 4, 2, 3, 5, 1, 2}, 8),
                Arguments.of(new long[]{5, 4, 2, 3, 5, 1, 2}, 9));
    }

}