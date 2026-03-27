package com.flashsale.flashsale.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "flash_sale")
@Data
public class FlashSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_priority_member")
    private boolean isPriorityMember;

    @Column(name = "request_time")
    private LocalDateTime requestTime;
}
