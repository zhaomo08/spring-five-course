package java.com.viso.reactive.service;

import reactor.core.publisher.Flux;

import java.com.viso.reactive.model.Stock;

public interface RStockService {
    Flux<Stock> getAllStocks();
}
