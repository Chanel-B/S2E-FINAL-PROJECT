package com.s2e.product.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * use of lombok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    private Product product;
    private Category category;

}
