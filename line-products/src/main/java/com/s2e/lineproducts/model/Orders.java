package com.s2e.lineproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    private int id;
    private int userId;
    private int lineProductId;

}
