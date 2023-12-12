package com.leverage.Purchaseinvoice.Service;

import com.leverage.Purchaseinvoice.Model.InvoiceData;
import com.leverage.Purchaseinvoice.repo.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepo repo;

    public InvoiceData getInvoice(Long id) {
        Optional<InvoiceData> data = repo.findByInvoiceNum(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;
    }

    public InvoiceData submitInvoice(InvoiceData invoiceData) {
        var invoice = InvoiceData
                .builder()
                .orderStatus("Created")
                .shippingAddress(invoiceData.getShippingAddress())
                .contactNumber(invoiceData.getContactNumber())
                .price(invoiceData.getPrice())
                .prodOrderNumber(new Random().nextLong(1000L, 9999L))
                .orderedDate(new Date(System.currentTimeMillis()))
                .build();
        repo.save(invoice);
        return invoice;
    }
}
