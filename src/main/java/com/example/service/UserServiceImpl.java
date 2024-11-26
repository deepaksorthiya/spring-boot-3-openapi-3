package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.AppUser;
import com.example.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        Page<AppUser> users = userRepository.findAll(pageable);
        return users;
    }

    /**
     * @param appUser
     * @return
     */
    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Optional<AppUser> findById(Long userId) {
        Optional<AppUser> user = userRepository.findById(userId);
        user.orElseThrow(() -> {
            throw new ResourceNotFoundException("Entity dooes not exists on server.");
        });
        return user;
    }

}
