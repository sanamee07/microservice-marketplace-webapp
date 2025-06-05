package edu.fra.uas.service;
import org.slf4j.Logger;
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

import edu.fra.uas.model.Advertisement;
import edu.fra.uas.model.ApiError;

@Service
public class AdvertisementService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdvertisementService.class);

    @Value("${advertisementservice.url}")
    String apiUrl;

    // Ruft alle Anzeigen eines bestimmten Benutzers ab.
    // Die Anfrage wird vom Gateway an den AdvertisementService weitergeleitet.
    
    public ResponseEntity<?> getAllAdvertisementsByUserId(long userId) {
        log.debug("forward request to " + apiUrl + "/users/" + userId + "/advertisements");
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + userId + "/advertisements";
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

    // Ruft eine bestimmte Anzeige eines Benutzers ab.
    // Die Anfrage wird vom Gateway an den AdvertisementService weitergeleitet.

    public ResponseEntity<?> getAdvertisementByUserId(long advertisementId, long userId) {
        log.debug("forward request to " + apiUrl + "/users/" + userId + "/advertisements/" + advertisementId);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + userId + "/advertisements/" + advertisementId;
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

    // Erstellt eine neue Anzeige für einen bestimmten Benutzer im AdvertisementService
    public ResponseEntity<?> createByAdvertisementUserId(long userId, Advertisement advertisement) {
        log.debug("forward request to " + apiUrl + "/users/" + userId + "/advertisements");
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + userId + "/advertisements";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Advertisement> request = new HttpEntity<>(advertisement, headers);

        ResponseEntity<?> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return response;
    }

    // Löscht eine bestimmte Anzeige eines Benutzers im AdvertisementService
    public ResponseEntity<?> deleteAdvertisementByUserId(Long userId, long advertisementId) {
        log.debug("forward request to " + apiUrl + "/users/" + userId + "/advertisements/" + advertisementId);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + userId + "/advertisements/" + advertisementId;
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

    // Aktualisiert eine bestimmte Anzeige eines Benutzers im AdvertisementService
    public ResponseEntity<?> updateAdvertisementByUserId(Long userId, long advertisementId,
            Advertisement advertisement) {
        log.debug("forward request to " + apiUrl + "/users/" + userId + "/advertisements/" + advertisementId);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/users/" + userId + "/advertisements/" + advertisementId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Advertisement> request = new HttpEntity<>(advertisement, headers);

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
