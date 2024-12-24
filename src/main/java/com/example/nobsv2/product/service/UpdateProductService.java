package com.example.nobsv2.product.service;

import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.repository.ProductRepository;
import com.example.nobsv2.product.util.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements ICommand<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        // In the future put exception handling
        return null;
    }
}
