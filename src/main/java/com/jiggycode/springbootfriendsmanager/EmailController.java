package com.jiggycode.springbootfriendsmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        String recipientEmail = emailRequest.getRecipientEmail();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();

        // Send the email using the EmailService
        emailService.sendEmail(recipientEmail, subject, body);
    }
}
