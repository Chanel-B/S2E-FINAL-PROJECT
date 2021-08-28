package com.s2e.lineproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineOrdersDetail {

    private LineProduct lineProduct;
    private Orders orders;
}
