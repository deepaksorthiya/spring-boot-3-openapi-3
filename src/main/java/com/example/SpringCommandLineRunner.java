package com.example;

import com.example.model.AppUser;
import com.example.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public SpringCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<AppUser> users = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 97);
            AppUser appUser = new AppUser(c + "user@gmail.com", c + "firstName", c + "lastName");
            users.add(appUser);
        }
        userRepository.saveAll(users);
    }
}
