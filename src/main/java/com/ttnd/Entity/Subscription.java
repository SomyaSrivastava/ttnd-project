package com.ttnd.Entity;

import javax.persistence.*;

@Entity
@Table
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subscriptionId;
}
