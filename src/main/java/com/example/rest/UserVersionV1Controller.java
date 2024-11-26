package com.example.rest;

import com.example.model.AppUser;
import com.example.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserVersionV1Controller {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AppUser> save(@RequestBody @Valid AppUser appUser, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.save(appUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "{userId}", produces = "application/json")
    public ResponseEntity<AppUser> getUser(@PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.findById(userId).get(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<AppUser>> findAll(@NotNull final Pageable pageable,
                                                 @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
