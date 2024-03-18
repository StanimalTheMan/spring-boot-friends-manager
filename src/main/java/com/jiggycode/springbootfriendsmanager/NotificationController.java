package com.jiggycode.springbootfriendsmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final SnsService snsService;

    @Autowired
    public NotificationController(SnsService snsService) {
        this.snsService = snsService;
    }

    @PostMapping("/send-direct-sms")
    public void sendDirectSms(@RequestBody SmsRequest requestBody) {
        System.out.println("Received request body: " + requestBody);

        String phoneNumber = requestBody.getPhoneNumber();
        String message = requestBody.getMessage();

        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Message: " + message);

        // Call snsService.sendDirectSms with phoneNumber and message
        snsService.sendDirectSms(phoneNumber, message);

    }
}
