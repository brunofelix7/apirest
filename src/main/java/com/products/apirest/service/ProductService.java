package com.products.apirest.service;

import com.products.apirest.domain.Product;
import com.products.apirest.exception.DataIntegrityException;
import com.products.apirest.exception.ObjectNotFoundException;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return this.repository.save(product);
    }

    public Product update(Product product) {
        return this.repository.save(product);
    }

    public void delete(Long id) {
        Product product = findOne(id);
        try {
            this.repository.delete(product);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque existem entidades relacionadas!");
        }
    }

    public Product findOne(Long id) {
        Product product = this.repository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName())
        );
        return product;
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

}
