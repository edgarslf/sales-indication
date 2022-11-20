package com.example.demo.service;

import com.example.demo.assembler.SalesAssembler;
import com.example.demo.domain.Client;
import com.example.demo.domain.Product;
import com.example.demo.domain.Sales;
import com.example.demo.dto.SaleDto;
import com.example.demo.dto.SaleReturnDto;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesAssembler assembler;

    public SaleReturnDto sale(SaleDto dto) {
        Optional<Client> client = clientRepository.findByCpf(dto.getClientCpf());
        if (!client.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Client not found");
        }

        Optional<Product> product = productRepository.findByName(dto.getProduct());
        if (!client.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product not found");
        }

        salesRepository.save(assembler.tranformSale(dto, product.get().getId()));

        return findProductsIndication(dto);
    }

    public List<SaleDto> findLastPurchases(String cpf) {
        List<SaleDto> dtos = new ArrayList<>();

        List<Sales> salesList = salesRepository.findByClientCpfOrderByCreatedAtDesc(cpf, PageRequest.of(0, 5));

        for (Sales sale: salesList) {
            Optional<Product> product = productRepository.findById(sale.getProductId());
            Optional<Client> client = clientRepository.findByCpf(sale.getClientCpf());

            SaleDto dto = assembler.buildSaleDto(sale, product.get(), client.get());

            dtos.add(dto);
        }

        return dtos;
    }

    private SaleReturnDto findProductsIndication(SaleDto dto) {

        Sales sale = salesRepository.findByMorePurchasedByCity(dto.getClientCity());

        Optional<Product> product = productRepository.findById(sale.getProductId());

        return new SaleReturnDto(product.get().getName());
    }
}
