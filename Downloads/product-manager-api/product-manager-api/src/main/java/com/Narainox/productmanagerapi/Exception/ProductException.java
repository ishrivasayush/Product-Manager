package com.Narainox.productmanagerapi.Exception;

public class ProductException extends RuntimeException{
    private String resource;
    private Object value;
    private String type;

    public ProductException(String resource,String type,Object value ) {
        super(String.format("%s Is Not Found With %s = %s ", resource,type,value));
        this.resource = resource;
        this.value = value;
        this.type = type;
    }



}
