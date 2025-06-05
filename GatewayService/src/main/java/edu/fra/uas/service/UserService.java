package edu.fra.uas.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.fra.uas.model.ApiError;
import edu.fra.uas.model.User;

import org.slf4j.Logger;

@Service
public class UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

    @Value("${userservice.url}")
    String apiUrl;

    // Holt alle Benutzer aus dem UserService
    // GET /users
    public ResponseEntity<?> getAllUsers() {
        log.debug("forward request to " + apiUrl + "/users");
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    }

    // Holt einen bestimmten Benutzer anhand seiner ID aus dem UserService
    // GET /users/{id}
    public ResponseEntity<?> getUserById(Long id) {
        log.debug("forward request to " + apiUrl + "/users/" + id);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    }

    // Erstellt einen neuen Benutzer im UserService
    // POST /users
    public ResponseEntity<?> createUser(User user) {
        log.debug("forward request to " + apiUrl + "/users");
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    } 

    // Löscht einen Benutzer anhand seiner ID im UserService
    // DELETE /users/{id}
    public ResponseEntity<?> deleteUser(Long id) {
        log.debug("forward request to " + apiUrl + "/users/" + id);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    }

    // Aktualisiert einen Benutzer anhand seiner ID im UserService
    // PUT /users/{id}
    public ResponseEntity<?> updateUser(Long id, User user) {
        log.debug("forward request to " + apiUrl + "/users/" + id);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    }


}