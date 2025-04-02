package com.example.rest;

import com.example.AbstractApplicationTests;
import com.example.model.AppUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
public class AppUserVersionV1ControllerIntegrationIT extends AbstractApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(AppUserVersionV1ControllerIntegrationIT.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("before all called for UserVersionV1ControllerIntegrationTest.");
    }

    @Test
    public void save_api_v1_return201() {
        ResponseEntity<AppUser> response = getResponse("v1");
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    public void save_api_v2_return201() {
        ResponseEntity<AppUser> response = getResponse("v2");
        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
    }

    private ResponseEntity<AppUser> getResponse(String version) {
        String rootUri = testRestTemplate.getRootUri();
        AppUser appUser = new AppUser("fff@gmail.com" + version, "sfsdfs" + version, "fsdfsdfs0" + version);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AppUser> entity = new HttpEntity<>(appUser, headers);
        ResponseEntity<AppUser> response = testRestTemplate.postForEntity(rootUri + "/api/" + version + "/users", entity, AppUser.class);
        return response;
    }
}
