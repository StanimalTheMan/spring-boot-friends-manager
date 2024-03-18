package com.jiggycode.springbootfriendsmanager;

import lombok.Data;

@Data
public class EmailRequest {
    private String recipientEmail;
    private String subject;
    private String body;

    // Getters and setters (or lombok annotations) for recipientEmail, subject, and body
}

