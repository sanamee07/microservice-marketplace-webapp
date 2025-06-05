package edu.fra.uas.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.fra.uas.model.Advertisement;
import edu.fra.uas.model.Post;
import edu.fra.uas.model.User;
import edu.fra.uas.service.AdvertisementService;
import edu.fra.uas.service.PostService;
import edu.fra.uas.service.UserService;

@RestController
@RequestMapping("/api")

public class GatewayController {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(GatewayController.class);
    
    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    // ####################################################################################################
    // UserService
    // ####################################################################################################

    // Lists all users
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> listUsers() {
        log.debug("listUsers() is called");
        ResponseEntity<?> response = userService.getAllUsers();
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
            return new ResponseEntity<>("no users", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // Finds a specific user by user ID
    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> findUser(@PathVariable("userId") Long userId) {
        log.debug("findUser() is called");
        ResponseEntity<?> response = userService.getUserById(userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // Creates a new user
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
        log.info("Create new user: ", user.getEmail());
        ResponseEntity<?> response = userService.createUser(user);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.CREATED)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/users"));
            return new ResponseEntity<>(response.getBody(), headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Deletes a user by user ID
    @DeleteMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
        log.info("deleteUser() is called");
        ResponseEntity<?> response = userService.deleteUser(userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // Updates a user's information by user ID
    @PutMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        log.info("updateUser() is called: ");
        ResponseEntity<?> response = userService.updateUser(userId, user);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
    // ####################################################################################################
    // AdvertisementService
    // ####################################################################################################
    
    // Fetches all advertisements for a specific user by user ID
    @GetMapping(value = "/users/{userId}/advertisements", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getAdvertisementsByUserId(@PathVariable("userId") Long userId) {
        log.debug("getAdvertisementsByUserId() is called");
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }
        ResponseEntity<?> response = advertisementService.getAllAdvertisementsByUserId(userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // Fetches a specific advertisement by user ID and advertisement ID
    @GetMapping(value = "/users/{userId}/advertisements/{advertisementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getAdvertisementByUserId(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId) {
        log.debug("getAdvertisementsByUserId() is called");
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }
        ResponseEntity<?> response = advertisementService.getAdvertisementByUserId(advertisementId, userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // Erstellt eine neue Anzeige für einen Benutzer, wenn dieser existiert
    @PostMapping(value = "/users/{userId}/advertisements", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createAdvertisement(@PathVariable("userId") Long userId,
            @RequestBody Advertisement advertisement) {
        log.debug("createToDo() is called for userId: " + userId);
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }
        ResponseEntity<?> response = advertisementService.createByAdvertisementUserId(userId, advertisement);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.CREATED)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/users/" + userId + "/advertisements"));
            return new ResponseEntity<>(response.getBody(), headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Aktualisiert eine bestehende Anzeige für einen Benutzer, wenn dieser existiert
    @PutMapping(value = "/users/{userId}/advertisements/{advertisementId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateAdvertisement(@PathVariable("userId") Long userId, Long advertisementId,
            @RequestBody Advertisement advertisement) {
        log.debug("update() is called for userId: " + userId);
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }
        ResponseEntity<?> response = advertisementService.updateAdvertisementByUserId(userId, advertisementId,
                advertisement);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.CREATED)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/users/" + userId + "/advertisements"));
            return new ResponseEntity<>(response.getBody(), headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Löscht eine bestimmte Anzeige eines Benutzers, wenn sowohl der Benutzer als auch die Anzeige existieren
    @DeleteMapping(value = "/users/{userId}/advertisements/{advertisementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> deleteAdd(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId) {
        log.debug("deleteadvertisement() is called for advertisementId: " + advertisementId);
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }
        ResponseEntity<?> response = advertisementService.deleteAdvertisementByUserId(userId, advertisementId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    // ####################################################################################################
    // PostService
    // ####################################################################################################

    // Creates a comment on a specific advertisement for a user
    @PostMapping(value = "/users/{userId}/advertisements/{advertisementId}/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createComment(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId,
            @RequestBody Post post) {
        log.debug("createPost() is called for userId: {}, advertisement: {}", userId, advertisementId);

        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }

        ResponseEntity<?> adResponse = advertisementService.getAdvertisementByUserId(advertisementId, userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return adResponse;
        }

        Post createdPost = postService.createPost(userId, advertisementId, post.getPlatform(), post.getLink());
        if (createdPost != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(
                    URI.create("/api/users/" + userId + "/advertisements/" + advertisementId + "/posts/"
                            + createdPost.getPostId()));
            return new ResponseEntity<>(createdPost, headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create comment", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Retrieves all comments associated with a specific advertisement and user
    @GetMapping(value = "/users/{userId}/advertisements/{advertisementId}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getCommentsByUserIdAndToDoId(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId) {
        log.debug("getPosts() is called for userId: {} and advertisementId: {}", userId, advertisementId);
        ResponseEntity<?> userResponse = userService.getUserById(userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return userResponse;
        }

        ResponseEntity<?> adResponse = advertisementService.getAdvertisementByUserId(advertisementId, userId);
        if (userResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return adResponse;
        }
        List<Post> posts = postService.getAllPostsByUserIdAndAdvertisementId(userId, advertisementId);
        if (posts != null && !posts.isEmpty()) {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No comments found for user and advertisement.", HttpStatus.NO_CONTENT);
        }
    }

}