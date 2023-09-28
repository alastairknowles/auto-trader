package com.realalknowles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TradingServiceTest {

    private final TradingService tradingService = new TradingService();

    @Test
    void shouldReturnZeroWhenPricesAreNull() {
        // Given
        long[] marketPrices = null;

        // When
        long income = tradingService.tradeOptimallyFollowingMarketPrice(marketPrices);

        // Then
        assertThat(income).isEqualTo(0);
    }

    @Test
    void shouldReturnZeroWhenPricesAreEmpty() {
        // Given
        long[] marketPrices = new long[]{};

        // When
        long income = tradingService.tradeOptimallyFollowingMarketPrice(marketPrices);

        // Then
        assertThat(income).isEqualTo(0);
    }

}