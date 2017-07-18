package com.ttnd.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer TopicId;
    @Column(unique = true)
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
}
