package com.s2e.lineproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LINEPRODUCT")
public class LineProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PRODUCTID")
    private int productId;

    @Column(name = "PRODUCTQUANTITY")
    private int productQuantity;

}
