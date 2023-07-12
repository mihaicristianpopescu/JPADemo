package com.example.jpademo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SUBSCRIPTION", schema = "public")
public class Subscription extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "subscriptions")
    private List<User> users;
}
