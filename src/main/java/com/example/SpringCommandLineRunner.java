package com.example;

import com.example.model.AppUser;
import com.example.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public SpringCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new AppUser(0, "a3@gmail.com", "a3", "a3"));
        userRepository.save(new AppUser(0, "a1@gmail.com", "a1", "a1"));
        userRepository.save(new AppUser(0, "a4@gmail.com", "a4", "a4"));
        userRepository.save(new AppUser(0, "a2@gmail.com", "a2", "a2"));
        userRepository.save(new AppUser(0, "a6@gmail.com", "a6", "a6"));
        userRepository.save(new AppUser(0, "a5@gmail.com", "a5", "a5"));
        userRepository.save(new AppUser(0, "a7@gmail.com", "a7", "a7"));
        userRepository.save(new AppUser(0, "a8@gmail.com", "a8", "a8"));
        userRepository.save(new AppUser(0, "a10@gmail.com", "a10", "a10"));
        userRepository.save(new AppUser(0, "a9@gmail.com", "a9", "a9"));
        userRepository.save(new AppUser(0, "a11@gmail.com", "a11", "a11"));
    }

}
