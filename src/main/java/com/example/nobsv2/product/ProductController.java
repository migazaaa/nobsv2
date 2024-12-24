package com.example.nobsv2.product;

import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.service.*;
import com.example.nobsv2.product.util.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             GetProductService getProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getProductsService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Integer id){
        return deleteProductService.execute(id);
    }
}
