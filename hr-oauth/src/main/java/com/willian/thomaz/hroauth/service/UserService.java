package com.willian.thomaz.hroauth.service;

import com.willian.thomaz.hroauth.entities.User;
import com.willian.thomaz.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger Logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            Logger.error("User not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        Logger.info("Email found: " + email);
        return user;
    }
}
