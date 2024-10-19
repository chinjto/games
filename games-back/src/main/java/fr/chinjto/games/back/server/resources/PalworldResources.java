package fr.chinjto.games.back.server.resources;

import fr.chinjto.games.back.business.services.PalworldServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@RestController
@RequestMapping("/api/games/palworld")
@RequiredArgsConstructor
public class PalworldResources {

    private final PalworldServices services;

    @PostMapping("/run")
    public ResponseEntity<Void> startPalworld() {
        log.info("Starting Palworld Server");
        this.services.start();
        log.info("Started Palworld Server");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/run")
    public ResponseEntity<Void> restartPalworld() {
        log.info("Restarting Palworld Server");
        this.services.restart();
        log.info("Restarted Palworld Server");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/run")
    public ResponseEntity<Void> stopPalworld() {
        log.info("Stopping Palworld Server");
        this.services.stop();
        log.info("Stopped Palworld Server");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update")
    public ResponseEntity<Void> updatePalworld() {
        log.info("Updating Palworld Server");
        this.services.update();
        log.info("Updated Palworld Server");
        return ResponseEntity.noContent().build();
    }

}
