package com.s2e.lineproducts.virtualobject;

import com.s2e.lineproducts.model.LineProduct;
import com.s2e.lineproducts.model.Orders;
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
