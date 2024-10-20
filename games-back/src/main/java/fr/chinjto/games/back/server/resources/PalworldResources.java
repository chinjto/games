package fr.chinjto.games.back.server.resources;

import fr.chinjto.games.back.business.services.PalworldServices;
import fr.chinjto.games.back.server.resources.annotations.ServerResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.chinjto.games.back.server.resources.Action.RESTART;
import static fr.chinjto.games.back.server.resources.Action.START;
import static fr.chinjto.games.back.server.resources.Action.STOP;
import static fr.chinjto.games.back.server.resources.Action.UPDATE;
import static fr.chinjto.games.back.server.resources.Server.PALWORLD;

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
    @ServerResource(server = PALWORLD, action = START)
    public ResponseEntity<Void> startPalworld() {
        this.services.start();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/run")
    @ServerResource(server = PALWORLD, action = RESTART)
    public ResponseEntity<Void> restartPalworld() {
        this.services.restart();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/run")
    @ServerResource(server = PALWORLD, action = STOP)
    public ResponseEntity<Void> stopPalworld() {
        this.services.stop();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update")
    @ServerResource(server = PALWORLD, action = UPDATE)
    public ResponseEntity<Void> updatePalworld() {
        this.services.update();
        return ResponseEntity.noContent().build();
    }

}
