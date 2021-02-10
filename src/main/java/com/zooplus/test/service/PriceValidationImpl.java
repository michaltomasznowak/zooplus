package com.zooplus.test.service;

import com.zooplus.test.domain.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * michal.nowak created on 10/02/2021
 */
@Service
public class PriceValidationImpl implements PriceValidation {
    private static final BigDecimal MAX_PRICE = new BigDecimal(100_000);


    @Override
    public boolean isValid(Order order) {

        List<BigDecimal> allPrices = order.getOrderItems().stream().map(value -> value.getArticle().getUnitPrice().
                multiply(BigDecimal.valueOf(value.getQuantity()))).collect(Collectors.toList());
        BigDecimal sumPrices = allPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        if(sumPrices.compareTo(MAX_PRICE) == 1 || sumPrices.compareTo(MAX_PRICE) == 0)
            return false;
        return true;
    }
}
