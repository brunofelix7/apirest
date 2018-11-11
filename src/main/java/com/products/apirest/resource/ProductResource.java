package com.products.apirest.resource;

import com.products.apirest.domain.Product;
import com.products.apirest.route.Route;
import com.products.apirest.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = Route.URI_PRODUCTS)
@Api(value = "API REST de Produtos.")
@CrossOrigin(origins = "*")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping
    @ApiOperation(value = "Cria um novo produto.")
    public ResponseEntity<?> create(@Valid @RequestBody Product product) {
        Product obj = this.service.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Atualiza um produto.")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Product product) {
        Product obj = this.service.update(product);
        return ResponseEntity.accepted().body(obj);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Remove um produto.")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retorna um produto.")
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.service.findOne(id));
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de produtos.")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

}
