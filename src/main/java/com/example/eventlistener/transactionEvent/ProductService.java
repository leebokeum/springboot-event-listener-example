package com.example.eventlistener.transactionEvent;

import com.example.eventlistener.entityEvent.Product;
import com.example.eventlistener.entityEvent.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;


    public void insert(){
        Product product = new Product("인서트 테스트");
        productRepository.save(product);
        eventPublisher.publishEvent(product);
    }

}
