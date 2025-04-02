package com.example.rest;

import com.example.model.AppUser;
import com.example.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/users")
public class UserVersionV2Controller {

    private final UserService userService;

    public UserVersionV2Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AppUser> save(@RequestBody @Valid AppUser appUser) {
        return new ResponseEntity<>(userService.save(appUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "{userId}", produces = "application/json")
    public ResponseEntity<AppUser> getUser(@PathVariable long userId) {
        return new ResponseEntity<>(userService.findById(userId).get(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<AppUser>> findAll(@NotNull final Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
