package com.maxi.iPayback.serices;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.iPayback.dtos.UserDTO;
import com.maxi.iPayback.entities.user.User;
import com.maxi.iPayback.enums.UserType;
import com.maxi.iPayback.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if (sender.getUserType().equals(UserType.MARCHANT)) {
            throw new Exception("MARCHANT uset cannot sen any value");
        }

        if (sender.getSold().compareTo(amount) < 0) {
            throw new Exception("You dont have right to send this value :" + amount);
        }
    }

    public User findUserById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new Exception(""));
    }

    private User findUserByPersonalId(String personalId) {
        User user = userRepository.findByPersonalId(personalId);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public User addNerUser(UserDTO obj) throws Exception {
        if (findUserByPersonalId(obj.getPersonalId()) != null) {
            throw new Exception("User exists");
        }

        User user = new User();
        user.setFirstName(obj.getFirstName());
        user.setLastName(obj.getLastName());
        user.setPersonalId(obj.getPersonalId());
        user.setFoneNumber(obj.getFoneNumber());
        user.setUserType(obj.getUserType());
        user.setEmail(obj.getEmail());

        if (obj.getSold().compareTo(new BigDecimal(0)) < 0) {
            user.setSold(new BigDecimal(0));
        }
        user.setSold(obj.getSold());

        userRepository.save(user);
        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
