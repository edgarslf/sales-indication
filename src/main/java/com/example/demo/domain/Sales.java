package com.example.demo.domain;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "sales")
@Data
public class Sales {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private String clientCpf;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String payway;

    @Column(nullable = false)
    private String city;

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

}
