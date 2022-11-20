package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private  String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String uf;


}
