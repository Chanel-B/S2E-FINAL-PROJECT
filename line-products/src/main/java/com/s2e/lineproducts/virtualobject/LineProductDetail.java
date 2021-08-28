package com.s2e.lineproducts.virtualobject;

import com.s2e.lineproducts.model.LineProduct;
import com.s2e.lineproducts.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineProductDetail {

    private LineProduct lineProduct;
    private Product product;

}
