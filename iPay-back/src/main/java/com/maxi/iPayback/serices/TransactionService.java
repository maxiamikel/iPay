package com.maxi.iPayback.serices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maxi.iPayback.dtos.TransactionDTO;
import com.maxi.iPayback.dtos.UserDTO;
import com.maxi.iPayback.entities.transaction.Transaction;
import com.maxi.iPayback.entities.user.User;
import com.maxi.iPayback.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionService {

    private final String urlService = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6";

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO obj) throws Exception {

        User sender = this.userService.findUserById(obj.getSenderId());
        User receiver = this.userService.findUserById(obj.getReseiverId());

        this.userService.validateTransaction(sender, obj.getAmount());

        if (validateTransaction(sender, obj.getAmount())) {
            Transaction transaction = new Transaction();
            transaction.setSender(sender);
            transaction.setReceiver(receiver);
            transaction.setAmount(obj.getAmount());
            transaction.setTimestemp(LocalDate.now());

            sender.setSold(sender.getSold().subtract(obj.getAmount()));
            receiver.setSold(receiver.getSold().add(obj.getAmount()));

            UserDTO receiverDTO = new UserDTO(receiver);
            UserDTO senderDTO = new UserDTO(sender);

            this.userService.addNerUser(senderDTO);
            this.userService.addNerUser(receiverDTO);
            transactionRepository.save(transaction);
            notificationService.sentNotification(sender, "Transaction finalize sucessfully");
            notificationService.sentNotification(receiver, "Transfer received sucessfully");

            return transaction;
        } else {
            throw new Exception("Transaction not authorized");
        }

    }

    public boolean validateTransaction(User sender, BigDecimal amount) {
        ResponseEntity<Map> authResponse = restTemplate.getForEntity(urlService, Map.class);
        if (authResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authResponse.getBody().get("message");
            return "Autorizado".equals(message);
        } else {
            return false;
        }
    }

}
