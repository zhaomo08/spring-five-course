package com.viso.lambda.p4;

import com.viso.mvc.model.Stock;

@FunctionalInterface
public interface StockCreator2 {
    Stock getStock(String symbol, String name);
}
