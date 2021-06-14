package com.company.dto;

import java.util.List;

public class PaymentListDto {
    private List<PaymentGetDto> paymentListDto;

    public PaymentListDto() {
    }

    /**
     * PaymentListDto
     *
     * Dto used to show list of payments to user via http request
     *
     * @param paymentDtoList
     */
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
