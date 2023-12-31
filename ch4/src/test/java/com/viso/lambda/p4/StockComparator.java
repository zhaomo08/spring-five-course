package com.viso.lambda.p4;

import com.viso.mvc.model.Stock;

import java.util.Comparator;

public class StockComparator implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.getSymbol().compareTo(o2.getSymbol());
    }
}
