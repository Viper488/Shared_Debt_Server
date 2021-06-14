package com.company.dto;

public class PaymentDto {
    private float value;
    private int id_meeting;
    private  int id_person;

    public PaymentDto() {
    }

    /**
     * PaymentDto
     *
     * Dto used to insert payment via http request
     *
     * @param value
     * @param id_meeting
     * @param id_person
     */
    public PaymentDto(float value, int id_meeting, int id_person) {
        this.value = value;
        this.id_meeting = id_meeting;
        this.id_person = id_person;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getId_meeting() {
        return id_meeting;
    }

    public void setId_meeting(int id_meeting) {
        this.id_meeting = id_meeting;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
}
