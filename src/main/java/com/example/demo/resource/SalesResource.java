package com.example.demo.resource;

import com.example.demo.dto.SaleDto;
import com.example.demo.dto.SaleReturnDto;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesResource {

    @Autowired
    private SaleService service;


    @PostMapping
    public ResponseEntity<Object> sale(@RequestBody SaleDto dto) {
        try {

        SaleReturnDto returnDto = service.sale(dto);

        return new ResponseEntity<>(returnDto, HttpStatus.OK);

        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> findLastPurchases(@PathVariable String cpf) {
        try {
            List<SaleDto> purchases = service.findLastPurchases(cpf);

            return new ResponseEntity<>(purchases, HttpStatus.OK);

        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
