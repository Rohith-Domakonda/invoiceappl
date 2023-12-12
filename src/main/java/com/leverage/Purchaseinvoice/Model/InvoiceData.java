package com.leverage.Purchaseinvoice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@Table(name = "invoice")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceNum;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long prodOrderNumber;
    private String shippingAddress;
    private String contactNumber;
    private float price;
    private Date orderedDate;
    private String orderStatus;

}
