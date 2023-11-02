package com.viso;

import com.viso.reactive.model.Stock;
import com.viso.reactive.model.StockSubscription;
import com.viso.reactive.model.StockSymbol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeAccess;
import org.springframework.nativex.hint.TypeHint;

@SpringBootApplication
@TypeHint(types = {Stock.class, StockSymbol.class, StockSubscription.class}, access = TypeAccess.DECLARED_FIELDS)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}