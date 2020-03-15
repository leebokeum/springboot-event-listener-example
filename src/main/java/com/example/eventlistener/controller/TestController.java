package com.example.eventlistener.controller;

import com.example.eventlistener.entityEvent.Product;
import com.example.eventlistener.entityEvent.ProductRepository;
import com.example.eventlistener.transactionEvent.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/entity")
    ResponseEntity entity() {
        Product product = productRepository.save(new Product("인서트 테스트"));
        product.setContent("업데이트 테스트");
        product = productRepository.save(product);
        product.setContent("딜리트 테스트");
        productRepository.delete(product);
        return new ResponseEntity<>("entity 이벤트 리스너 테스트 완료", HttpStatus.OK);
    }

    @GetMapping("/transaction")
    ResponseEntity transaction() {
        productService.insert();
        return new ResponseEntity<>("transaction 이벤트 리스너 테스트 완료", HttpStatus.OK);
    }


}
