package com.viso.reactive.rsocket.server;

import com.viso.reactive.dto.StockPrice;
import com.viso.reactive.model.Stock;
import com.viso.reactive.service.PriceQueryEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class RSocketController {
    @Autowired
    public PriceQueryEngine engine;

    @MessageMapping("currentStockPrice")
    public Mono<StockPrice> getStockPrice(Stock stock) {
        System.out.println("Receive symbol from client");
        return Mono.just(new StockPrice(stock.getSymbol(), engine.getPriceForSymbol(stock.getSymbol())));
    }
}
