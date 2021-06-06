package com.company.dto;

import java.util.Calendar;

public class PaymentGetDto {
    Integer id_payment;
    String date;
    String time;
    Double value;
    String nick;
    Integer id_meeting;

    public PaymentGetDto() {
    }

    public PaymentGetDto(Integer id_payment, String date, String time, Double value, String nick, Integer id_meeting) {
        this.id_payment = id_payment;
        this.date = date;
        this.time = time;
        this.value = value;
        this.nick = nick;
        this.id_meeting = id_meeting;
    }

    public Integer getId_payment() {
        return id_payment;
    }

    public void setId_payment(Integer id_payment) {
        this.id_payment = id_payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getId_meeting() {
        return id_meeting;
    }

    public void setId_meeting(Integer id_meeting) {
        this.id_meeting = id_meeting;
    }
}
