package com.flashsale.flashsale.service;

import com.flashsale.flashsale.model.FlashSale;
import com.flashsale.flashsale.model.Order;
import com.flashsale.flashsale.repository.FlashSaleRepo;
import com.flashsale.flashsale.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashSaleService {
    @Autowired
    private FlashSaleRepo flashRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Scheduled(fixedRate = 1000)
    @Transactional
    public void processQueue() {
        List<FlashSale> top10 = flashRepo.findTop10ForProcessing();
        for (FlashSale person : top10) {
            Order order = new Order();
            order.setUserId(person.getUserId());
            orderRepo.save(order);
            flashRepo.delete(person);
        }
    }
}
