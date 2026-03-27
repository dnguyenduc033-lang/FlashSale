package com.flashsale.flashsale.controller;

import com.flashsale.flashsale.model.FlashSale;
import com.flashsale.flashsale.repository.FlashSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/flash-sale")
public class FlashSaleControl {
    @Autowired
    private FlashSaleRepo flashRepo;

    @PostMapping("/join")
    public String joinQueue(@RequestBody Map<String, Object> payload) {
        FlashSale entry = new FlashSale();
        entry.setUserId(Long.parseLong(payload.get("userId").toString()));
        entry.setPriorityMember((Boolean) payload.get("isPriority"));
        entry.setRequestTime(LocalDateTime.now());
        flashRepo.save(entry);
        return "Đã vào hàng chờ!";
    }
}
