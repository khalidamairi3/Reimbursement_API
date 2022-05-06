package com.demo.utls;

import com.demo.dto.EmailRequest;
import org.springframework.web.client.RestTemplate;

public class EmailClient {
    private static final String POST_EMAIL_API ="http://localhost:8081/email";
    private RestTemplate restTemplate = new RestTemplate();


    public void callPostEmail(String toEmail,String subject,String body){
        EmailRequest emailRequest = new EmailRequest(toEmail,subject,body);
        restTemplate.postForEntity(POST_EMAIL_API,emailRequest,null);

    }
}
