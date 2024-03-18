package com.jiggycode.springbootfriendsmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsService {

    private final SnsClient snsClient;

    @Autowired
    public SnsService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public void sendDirectSms(String phoneNumber, String message) {
        System.out.println("In service");

        // Build the PublishRequest with message and message attributes
        PublishRequest request = PublishRequest.builder()
                .message(message)
                .phoneNumber(phoneNumber)
                .build();

        System.out.println(request);

        PublishResponse result = snsClient.publish(request);
        System.out
                .println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());
    }
}

