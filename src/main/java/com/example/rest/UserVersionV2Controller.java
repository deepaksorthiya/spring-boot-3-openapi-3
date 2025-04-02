package com.example.rest;

import com.example.model.AppUser;
import com.example.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/users")
public class UserVersionV2Controller {

    private final UserService userService;

    public UserVersionV2Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> save(@RequestBody @Valid AppUser appUser, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.save(appUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AppUser> getUser(@PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.findById(userId).get(), HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Page<AppUser>> findAll(@NotNull @ParameterObject final Pageable pageable,
                                                 @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
