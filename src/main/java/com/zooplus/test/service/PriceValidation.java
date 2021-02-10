package com.zooplus.test.service;

import com.zooplus.test.domain.Order;

public interface PriceValidation {

    boolean isValid(Order order);
}
