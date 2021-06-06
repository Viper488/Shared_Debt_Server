package com.company.dto;

import java.util.List;

public class PaymentListDto {
    private List<PaymentGetDto> paymentListDto;

    public PaymentListDto() {
    }

    public PaymentListDto(List<PaymentGetDto> paymentDtoList) {
        this.paymentListDto = paymentDtoList;
    }

    public List<PaymentGetDto> getPaymentListDto() {
        return paymentListDto;
    }

    public void setPaymentListDto(List<PaymentGetDto> paymentListDto) {
        this.paymentListDto = paymentListDto;
    }
}
