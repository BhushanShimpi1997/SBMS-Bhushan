package com.productapi.xml.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private String msg;

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
