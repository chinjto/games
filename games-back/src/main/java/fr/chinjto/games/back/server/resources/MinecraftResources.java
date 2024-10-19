package fr.chinjto.games.back.server.resources;

import fr.chinjto.games.back.business.services.MinecraftServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/games/minecraft")
@RequiredArgsConstructor
public class MinecraftResources {

    private final MinecraftServices services;

    @PostMapping("/run")
    public ResponseEntity<Void> startMinecraft() {
        log.info("Starting Minecraft Server");
        this.services.start();
        log.info("Started Minecraft Server");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/run")
    public ResponseEntity<Void> restartMinecraft() {
        log.info("Restarting Minecraft Server");
        this.services.restart();
        log.info("Restarted Minecraft Server");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/run")
    public ResponseEntity<Void> stopMinecraft() {
        log.info("Stopping Minecraft Server");
        this.services.stop();
        log.info("Stopped Minecraft Server");
        return ResponseEntity.noContent().build();
    }

}
