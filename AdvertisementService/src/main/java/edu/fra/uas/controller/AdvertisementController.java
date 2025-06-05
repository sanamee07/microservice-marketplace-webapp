package edu.fra.uas.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.model.Advertisement;
import edu.fra.uas.service.AdvertisementService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

@RestController

public class AdvertisementController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(AdvertisementController.class);

    @Autowired
    AdvertisementService advertisementService;

    // Gibt alle Anzeigen eines bestimmten Benutzers zurück (GET-Anfrage)
    @GetMapping(value = "/users/{userId}/advertisements", produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseBody
    public ResponseEntity<List<Advertisement>> getAllAdvertismentsByUserId(@PathVariable("userId") Long userId) {
        log.info("getAllTodosByUserId() is called");
        
        // Holt alle Anzeigen für den angegebenen Benutzer
        Iterable<Advertisement> advertisementIter = advertisementService.getAllAdvertisementsByUserId(userId);
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement advertisement : advertisementIter) {
            advertisements.add(advertisement);
        }

         // Falls keine Anzeigen vorhanden sind, wird "204 No Content" zurückgegeben
        if (advertisements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Gibt die Liste der Anzeigen mit Status "200 OK" zurück
        return new ResponseEntity<List<Advertisement>>(advertisements, HttpStatus.OK);
    }

    
    // Gibt eine bestimmte Anzeige eines Benutzers basierend auf der Anzeige-ID zurück (GET-Anfrage)
    @GetMapping(value = "/users/{userId}/advertisements/{advertisementId}", produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseBody
    public ResponseEntity<Advertisement> getAdvertisementByUserId(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId) {
        log.info("getAdvertisementByUserId() is called");
       
       // Holt die Anzeige mit der angegebenen ID für den Benutzer
        Advertisement advertisement = advertisementService.getAdvertisementByUserId(userId, advertisementId);

          // Falls keine Anzeige gefunden wird, wird "204 No Content" zurückgegeben
        if (advertisement == null) {
            return ResponseEntity.noContent().build();
        }

        // Gibt die gefundene Anzeige mit Status "200 OK" zurück
        return new ResponseEntity<Advertisement>(advertisement, HttpStatus.OK);
    }

    // Erstellt eine neue Anzeige für einen bestimmten Benutzer (POST-Anfrage)
    @PostMapping(value = "/users/{userId}/advertisements", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createAdvertisement(@PathVariable("userId") Long userId,
            @RequestBody Advertisement advertisement) {
        log.info("Create new advertisemtent for user:" + userId);

        String detail = null;
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail);

        if (advertisement.getDescription() == null || advertisement.getDescription().isEmpty()) {
            detail = "discription cannot be empty or null";
            return ResponseEntity.unprocessableEntity().body(pd);
        }

        Advertisement newAdvertisement = new Advertisement();

        newAdvertisement = advertisementService.createAdvertisementByUserId(userId, advertisement);
        return new ResponseEntity<Advertisement>(newAdvertisement, HttpStatus.CREATED);
    }

    // Aktualisiert eine bestehende Anzeige für einen Benutzer (PUT-Anfrage)
    @PutMapping(value = "/users/{userId}/advertisements/{advertisementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> update(
            @PathVariable("userId") Long userId, @PathVariable("advertisementId") Long advertisementId,
            @RequestBody Advertisement advertisement) {
        log.info("update advertisementId:" + advertisementId + "for User: " + userId);

        Advertisement newAdvertisement = advertisementService.updateAdvertisementForUserId(userId, advertisementId,
                advertisement);
        return new ResponseEntity<Advertisement>(newAdvertisement, HttpStatus.OK);
    }

    // Löscht eine bestimmte Anzeige für einen Benutzer (DELETE-Anfrage)
    @DeleteMapping(value = "/users/{userId}/advertisements/{advertisementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("userId") Long userId,
            @PathVariable("advertisementId") Long advertisementId) {
        log.debug("delete() is called");
        Advertisement advertisement = advertisementService.getAdvertisementByUserId(userId, advertisementId);
        if (advertisement == null) {
            return ResponseEntity.notFound().build();
        }
        advertisementService.deleteAdvertisementByUserId(userId, advertisementId);
        return new ResponseEntity<Advertisement>(advertisement, HttpStatus.OK);
    }

}
