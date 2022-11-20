package com.example.demo.dto;

import lombok.Data;

@Data
public class SaleDto {

    private String clientCpf;

    private String product;

    private Integer amount;

    private Integer price;

    private String clientCity;

    private String clientUF;

    private String payWay;

}
