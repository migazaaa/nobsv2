package com.example.nobsv2.product.service;

import org.springframework.http.ResponseEntity;

public interface IQuery<I, O>{
    ResponseEntity<O> execute(I input);
}
