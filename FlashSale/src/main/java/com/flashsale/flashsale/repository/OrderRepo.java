package com.flashsale.flashsale.repository;

import com.flashsale.flashsale.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
