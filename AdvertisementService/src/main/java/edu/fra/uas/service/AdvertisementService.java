package edu.fra.uas.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.fra.uas.model.Advertisement;
import edu.fra.uas.repository.AdvertisementRepository;

@Service
public class AdvertisementService {

    // Logger für Debugging und Fehlersuche
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdvertisementService.class);

    // Repository für die Speicherung und den Zugriff auf Anzeigen
    @Autowired
    private AdvertisementRepository advertisementRepository;;

    private long nextAdvertisementId = 1;

     // Holt alle Anzeigen eines bestimmten Benutzers.
    public Iterable<Advertisement> getAllAdvertisementsByUserId(long userId) {
        log.debug("getAllAdvertisementsByUserId" + userId);
        Iterable<Advertisement> advertisementIter = advertisementRepository.values();
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement advertisement : advertisementIter) {
            if (advertisement.getUserId() == userId) {
                advertisements.add(advertisement);
            }
        }

        return advertisements;
    }
    // Holt eine bestimmte Anzeige eines Benutzers anhand der Anzeige-ID. 
    public Advertisement getAdvertisementByUserId(long userId, long advertisementId) {
        log.debug("get Advertisement : " + advertisementId + " for User: " + userId);
        for (Advertisement advertisement : advertisementRepository.values()) {
            if (advertisement.getUserId() == userId && advertisement.getAdvertisementId() == advertisementId) {
                return advertisement;
            }
        }
        return null;
    }

     // Erstellt eine neue Anzeige für einen bestimmten Benutzer
    public Advertisement createAdvertisementByUserId(long userId, Advertisement advertisement) {
        advertisement.setAdvertisementId(nextAdvertisementId++);
        advertisement.setUserId(userId);
        log.debug("createAdvertisement: " + advertisement.getUserId());
        advertisementRepository.put(advertisement.getAdvertisementId(), advertisement);
        return advertisementRepository.get(advertisement.getAdvertisementId());
    }

    // Aktualisiert eine bestehende Anzeige eines bestimmten Benutzers
    public Advertisement updateAdvertisementForUserId(long userId, long advertisementId,
            Advertisement newAdvertisement) {
        log.debug("update Advertisement: " + advertisementId + " for User: " + userId);
        Advertisement advertisement = getAdvertisementByUserId(userId, advertisementId);
        advertisement.setDescription(newAdvertisement.getDescription());
        advertisement.setPricePerUnit(newAdvertisement.getPricePerUnit());
        advertisement.setTitle(newAdvertisement.getTitle());
        advertisementRepository.put(advertisementId, advertisement);
        return advertisementRepository.get(advertisement.getAdvertisementId());
    }
    // Löscht eine Anzeige eines bestimmten Benutzers
    public Advertisement deleteAdvertisementByUserId(long userId, long advertisementId) {
        log.debug("delete Advertisement: " + advertisementId + " for User: " + userId);
        Advertisement advertisement = getAdvertisementByUserId(userId, advertisementId);
        return advertisementRepository.remove(advertisement.getAdvertisementId());
    }


    
    
    
}
