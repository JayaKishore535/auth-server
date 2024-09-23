package com.fintech.authservice.dto;

import lombok.Data;

@Data
public class ContactUsDto {

    private String txnDate;
    private String name;
    private String email;
    private String phone;
    private String category;
    private String remarks;

}