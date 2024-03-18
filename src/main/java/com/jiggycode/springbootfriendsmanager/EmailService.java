package com.jiggycode.springbootfriendsmanager;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private AmazonSimpleEmailService amazonSESClient;

    public void sendEmail(String recipientEmail, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(recipientEmail))
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(body)))
                        .withSubject(new Content().withCharset("UTF-8").withData(subject)))
                .withSource("choi.j.stan@gmail.com");

        amazonSESClient.sendEmail(request);
    }
}
