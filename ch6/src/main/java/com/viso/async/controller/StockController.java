package com.viso.async.controller;

import com.viso.async.service.RStockService;
import com.viso.mvc.model.Stock;
import com.viso.mvc.model.StockSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private RStockService rStockService;

    @GetMapping
    private WebAsyncTask<String> getStocks(Model model) {
        Callable<String> callable = () -> {
            List<Stock> stocks;
            stocks = rStockService.getAllStocksAsync().get();
            model.addAttribute("stocks", stocks);
            model.addAttribute("stockSymbol", new StockSymbol());
            return "stocks";
        };
        return new WebAsyncTask<>(callable);
    }
}
