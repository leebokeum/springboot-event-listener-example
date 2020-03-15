package com.example.eventlistener.entityEvent;

import javax.persistence.*;

@Entity
@Table(name = "product_item")
@EntityListeners(ProductListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    public Product(String content) {
        this.content = content;
    }

    public Product() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
