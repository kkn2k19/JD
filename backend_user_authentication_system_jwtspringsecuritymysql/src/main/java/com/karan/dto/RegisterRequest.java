package com.karan.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String Uname;
    private String email;
    private String pass;
}
