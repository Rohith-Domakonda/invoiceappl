package com.leverage.Purchaseinvoice.repo;

import com.leverage.Purchaseinvoice.Model.InvoiceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InvoiceRepo extends JpaRepository<InvoiceData, Long> {
Optional<InvoiceData> findByInvoiceNum(Long id);
}
