package com.example.service;

import com.example.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    /**
     * @param pageable
     * @return
     */
    Page<AppUser> findAll(Pageable pageable);

    /**
     * @param appUser
     * @return
     */
    AppUser save(AppUser appUser);

    /**
     * @param userId
     * @return
     */
    Optional<AppUser> findById(Long userId);

}