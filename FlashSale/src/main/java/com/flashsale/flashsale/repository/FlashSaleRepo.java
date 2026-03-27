package com.flashsale.flashsale.repository;

import com.flashsale.flashsale.model.FlashSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlashSaleRepo extends JpaRepository<FlashSale, Long> {
    @Query(value = "select * from flash_sale order by is_priority_member desc, request_time asc LIMIT 10", nativeQuery = true)
    List<FlashSale> findTop10ForProcessing();
}
