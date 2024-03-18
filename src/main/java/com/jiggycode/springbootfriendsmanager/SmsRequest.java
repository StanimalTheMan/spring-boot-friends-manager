package com.jiggycode.springbootfriendsmanager;

import lombok.Data;

@Data
public class SmsRequest {
    private String phoneNumber;
    private String message;
}
