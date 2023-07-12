package com.example.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PAYMENT_DETAILS", schema = "public")
public class PaymentDetails extends BaseEntity{

    @Column(name = "BANK_NAME", nullable = false)
    private String bankName;

    @Column(name = "NUMBER", nullable = false)
    private int number;

    @JsonBackReference
    @OneToOne(mappedBy = "paymentDetails")
    private User user;
}
