package com.s2e.lineproducts.repository;

import com.s2e.lineproducts.model.LineProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineProductRepository extends JpaRepository<LineProduct, Integer> {
}
