package com.example.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER", schema = "public")
public class User extends BaseEntity{

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;

    @JsonIgnoreProperties("users")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subscriptions_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id")
    )
    private List<Subscription> subscriptions;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentDetails paymentDetails;
}
