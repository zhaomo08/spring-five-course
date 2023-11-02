package com.viso.mvc.service;

import com.viso.jpa.dao.StockDao;
import com.viso.jpa.dao.StockSubscriptionDao;
import com.viso.jpa.entity.StockDO;
import com.viso.jpa.entity.StockSubscriptionDO;
import com.viso.mvc.model.StockSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements  SubscriptionService{
    @Autowired
    private StockDao stockDao;

    @Autowired
    private StockSubscriptionDao subscriptionDao;

    public List<StockSubscription> findByEmail(String email) {
        List<StockSubscriptionDO> subscriptions = subscriptionDao.findByEmail(email);
        return subscriptions.stream().map(stockSubscriptionDO ->
                StockSubscription.builder()
                        .symbol(stockSubscriptionDO.getSymbol())
                        .email(stockSubscriptionDO.getEmail())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void addSubscription(String email, String symbol) {
        checkValidStock(symbol);
        checkSubscriptionExists(email, symbol);
        StockSubscriptionDO subscriptionDO = new StockSubscriptionDO();
        subscriptionDO.setEmail(email);
        subscriptionDO.setSymbol(symbol);
        subscriptionDao.save(subscriptionDO);
    }

    private void checkSubscriptionExists(String email, String symbol) {
        List<StockSubscriptionDO> matched = subscriptionDao.findByEmailAndSymbol(email, symbol);
        if (!CollectionUtils.isEmpty(matched)) {
            throw new RuntimeException("subscription already exists for this user");
        }
    }

    private void checkValidStock(String symbol) {
        Optional<StockDO> matched = stockDao.findAll()
                .stream()
                .filter(stockDO -> stockDO.getSymbol().equalsIgnoreCase(symbol))
                .findAny();
        if (!matched.isPresent()) {
            throw new RuntimeException("stock symbol not valid");
        }
    }
}
