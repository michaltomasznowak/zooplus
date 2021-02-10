package com.zooplus.test.service;

import com.zooplus.test.domain.Article;
import com.zooplus.test.domain.Order;
import com.zooplus.test.domain.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceValidationImplTest {
    private static final int PRICE_1 = 100_000;
    private PriceValidation priceValidation;

    @BeforeEach
    public void setUp() {
        priceValidation = new PriceValidationImpl();
    }


    @Test
    void isValid() {
        Order order = prepareMockDataGreaterThanExpected();
        Assertions.assertFalse(priceValidation.isValid(order));
    }

    public Order prepareMockDataGreaterThanExpected(){
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        OrderItem orderItem1 = new OrderItem();
        orderItems.add(orderItem);
        orderItems.add(orderItem1);

        Article article = new Article();
        article.setUnitPrice(new BigDecimal(PRICE_1));
        Article article1 = new Article();
        article1.setUnitPrice(new BigDecimal(PRICE_1));

        orderItem1.setArticle(article1);
        orderItem.setArticle(article);

        order.setOrderItems(orderItems);

        return order;
    }
}