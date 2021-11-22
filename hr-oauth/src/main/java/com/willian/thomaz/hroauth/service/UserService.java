package com.willian.thomaz.hroauth.service;

import com.willian.thomaz.hroauth.entities.User;
import com.willian.thomaz.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger Logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    /*Teria que ser apagado e so usado o loadUserByUsername, mais para didatica vai ser deixado no codigo */
    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            Logger.error("User not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        Logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            Logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        Logger.info("Email found: " + username);
        return user;
    }
}
