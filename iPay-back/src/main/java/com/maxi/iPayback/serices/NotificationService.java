package com.maxi.iPayback.serices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maxi.iPayback.entities.user.User;

@Service
public class NotificationService {

    // private final String url_Post_Email = "http://o4d9z.mocklab.io/notify";
    // @Autowired
    // private RestTemplate restTemplate;

    public void sentNotification(User user, String message) throws Exception {
        String email = user.getEmail();

        /*
         * NotificationDTO notificationRequest = new NotificationDTO(email, message);
         * ResponseEntity<String> notificationResponse =
         * restTemplate.postForEntity(url_Post_Email, notificationRequest,
         * String.class);
         * 
         * if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
         * System.out.println("Error sendding notification");
         * throw new Exception("Notification service not available");
         * }
         */
        System.out.println("Enviado com sucesso: " + email);
    }

}
