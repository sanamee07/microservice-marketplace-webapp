package edu.fra.uas.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.model.User;
import edu.fra.uas.repository.UserRepository;


 // Diese Klasse stellt den Service für Benutzer bereit.
 
@Service
public class UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

    // Repository zur Verwaltung der Benutzer
    @Autowired
    private UserRepository userRepository;

    private long nextUserId = 1;

    
     // Erstellt einen neuen Benutzer und weist ihm eine eindeutige ID zu.
     
    public User createUser(User user) {
        user.setId(nextUserId++);
        log.debug("createUser: " + user);
        userRepository.put(user.getId(), user);
        return userRepository.get(user.getId());
    }

    
     // Gibt alle Benutzer zurück, die im Repository gespeichert sind.
  
    public Iterable<User> getAllUsers() {
        log.debug("getAllUsers");
        return userRepository.values();
    }

    
     // Ruft einen Benutzer anhand seiner ID ab.
    
    public User getUserById(long id) {
        log.debug("getUser: " + id);
        return userRepository.get(id);
    }

    
     // Aktualisiert die Informationen eines Benutzers im Repository.
    
    public User updateUser(User user) {
        log.debug("updateUser: " + user);
        userRepository.put(user.getId(), user);
        return userRepository.get(user.getId());
    }

    
     // Löscht einen Benutzer aus dem Repository anhand seiner ID.
     
    public User deleteUser(long id) {
        log.debug("deleteUser: " + id);
        return userRepository.remove(id);
    }

}