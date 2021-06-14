package com.company.dto;

public class ProductDto {
    private Integer id_product;
    private String name;
    private Double price;
    private String nick;
    private String date;
    private String time;
    private Integer id_meeting;

    public ProductDto() {
    }

    /**
     * ProductDto
     *
     * Dto holding data of products added to meetings
     *
     * @param id_product
     * @param name
     * @param price
     * @param nick
     * @param date
     * @param time
     * @param id_meeting
     */
    public ProductDto(Integer id_product, String name, Double price, String nick, String date,  String time, Integer id_meeting) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.nick = nick;
        this.id_meeting = id_meeting;
        this.date = date;
        this.time = time;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId_meeting() {
        return id_meeting;
    }

    public void setId_meeting(Integer id_meeting) {
        this.id_meeting = id_meeting;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
}
