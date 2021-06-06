package com.company.dto;

import java.util.List;

public class ProductListDto {
    private List<ProductDto> productDtoList;

    public ProductListDto() {
    }

    public ProductListDto(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
}
