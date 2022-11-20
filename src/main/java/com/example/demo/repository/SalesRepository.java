package com.example.demo.repository;

import com.example.demo.domain.Sales;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository  extends JpaRepository<Sales, Integer> {
    List<Sales> findByClientCpfOrderByCreatedAtDesc(String cpf, Pageable pageable);

    @Query(
            value = "SELECT * FROM sales s WHERE s.city = :city GROUP BY S.productId" +
                    "ORDER COUNT(*) LIMIT 1",
            nativeQuery = true)

    Sales findByMorePurchasedByCity(@Param("city") String clientCity);
}
