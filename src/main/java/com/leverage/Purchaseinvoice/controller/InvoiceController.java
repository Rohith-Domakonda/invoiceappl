package com.leverage.Purchaseinvoice.controller;

import com.leverage.Purchaseinvoice.Model.InvoiceData;
import com.leverage.Purchaseinvoice.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")

public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @GetMapping("/{id}")
    public InvoiceData getInvoice(@PathVariable(name = "id") Long id){
        InvoiceData data = invoiceService.getInvoice(id);
        return data;
    }

    @PostMapping
    public InvoiceData submitInvoice(@RequestBody InvoiceData invoiceData){
        return invoiceService.submitInvoice(invoiceData);
    }
}
