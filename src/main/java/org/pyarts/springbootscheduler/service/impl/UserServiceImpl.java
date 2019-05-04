package org.pyarts.springbootscheduler.service.impl;

import org.pyarts.springbootscheduler.model.User;
import org.pyarts.springbootscheduler.repository.UserRepository;
import org.pyarts.springbootscheduler.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void add2DBJob() {

        User user = new User();
        user.setName("user" + new Random().nextInt(374483));
        userRepository.save(user);
        System.err.println("Add service cell in : " + LocalDateTime.now().toString());

    }

    @Scheduled(cron = "0/15 * * * * *")
    @Override
    public void fetchDBJob() {
        List<User> users = userRepository.findAll();
        System.err.println("Fetch Service Called in : " + LocalDateTime.now().toString());
        System.err.println("Number of Records : " + users.size());
        logger.info("Users : {} ", users);
    }
}


















