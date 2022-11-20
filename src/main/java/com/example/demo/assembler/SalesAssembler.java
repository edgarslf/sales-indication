package com.example.demo.assembler;

import com.example.demo.domain.Client;
import com.example.demo.domain.Product;
import com.example.demo.domain.Sales;
import com.example.demo.dto.SaleDto;
import org.springframework.stereotype.Component;

@Component
public class SalesAssembler {
    public Sales tranformSale(SaleDto dto, Integer productId) {
        Sales sales = new Sales();

        sales.setProductId(productId);
        sales.setClientCpf(dto.getClientCpf());
        sales.setCity(dto.getClientCity());
        sales.setAmount(dto.getAmount());
        sales.setPrice(dto.getPrice());
        sales.setPayway(dto.getPayWay());

        return sales;
    }

    public SaleDto buildSaleDto(Sales sale, Product product, Client client) {
        SaleDto dto = new SaleDto();

        dto.setProduct(product.getName());
        dto.setClientCpf(client.getCpf());
        dto.setClientCity(client.getCity());
        dto.setClientUF(client.getUf());
        dto.setPrice(sale.getPrice());
        dto.setAmount(sale.getAmount());
        dto.setPayWay(sale.getPayway());

        return dto;
    }
}
