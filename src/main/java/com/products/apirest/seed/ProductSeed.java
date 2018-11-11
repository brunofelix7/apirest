package com.products.apirest.seed;

import com.products.apirest.domain.Product;
import com.products.apirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProductSeed {

    @Autowired
    private ProductService service;

    public void seed() {
        this.service.save(new Product(null, "Playstation 4 Slim 1TB", 1, new BigDecimal("1899.90")));
        this.service.save(new Product(null, "GTX 1050 2GB", 1, new BigDecimal("799.90")));
        this.service.save(new Product(null, "Monitor Gamer Accer 24' 144hz", 1, new BigDecimal("1399.90")));
    }

}
