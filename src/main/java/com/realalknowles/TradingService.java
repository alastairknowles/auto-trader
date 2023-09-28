package com.realalknowles;

public class TradingService {

    public long tradeOptimally(long[] prices) {
        long income = 0;
        boolean selling = true;
        for (int i = 0; i < getNumberOfPrices(prices); i++) {
            long price = getPrice(prices, i);
            long nextPrice = getNextPrice(prices, i);

            if (selling && price > nextPrice) {
                income = income + price;
                selling = false;
            } else if (!selling && price > 0 && price < nextPrice) {
                income = income - price;
                selling = true;
            }
        }

        return income;
    }

    private int getNumberOfPrices(long[] prices) {
        return prices == null ? 0 : prices.length;
    }

    private long getPrice(long[] prices, int index) {
        if (index > prices.length - 1) {
            return 0;
        }

        return prices[index];
    }

    private long getNextPrice(long[] prices, int index) {
        if (index > prices.length - 2) {
            return -1;
        }

        return prices[index + 1];
    }

}