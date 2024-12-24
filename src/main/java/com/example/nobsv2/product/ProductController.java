package com.example.nobsv2.product;

import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.service.CreateProductService;
import com.example.nobsv2.product.service.DeleteProductService;
import com.example.nobsv2.product.service.GetProductsService;
import com.example.nobsv2.product.service.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(){
        return createProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return getProductService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(){
        return updateProductService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMapping(){
        return deleteProductService.execute(null);
    }
}
