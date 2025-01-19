package com.spotify.application.controllers;

import com.spotify.application.CsvReader;
import com.spotify.application.Playlist;
import com.spotify.application.dto.PlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class PlaylistController {
    @Autowired
    private CsvReader csvreader;
    @Autowired
    private Playlist p;
    @PostMapping("/add-songs/{filename}/{playlistname}")
    public ResponseEntity<String> addSong(@PathVariable("filename") String filename,
                        @PathVariable("playlistname") String playlistname) {
        try {
            List<List<String>> songData = csvreader.readCSV(filename);
            p.createPlaylist(songData, playlistname);
            PlaylistDTO playlist = p.getPlaylist();
            return ResponseEntity.ok("Playlist created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error creating playlist: " + e.getMessage());
        }
    }

    @GetMapping({"/getplaylist", "/getplaylist/{playlistName}"})
    public ResponseEntity<?> getPlayList(@PathVariable(required = false) String playlistName) {
        try {
            if (playlistName != null) {
                PlaylistDTO playlist = p.getPlaylistByName(playlistName);
                return ResponseEntity.ok(playlist);
            } else {
                List<PlaylistDTO> allPlaylists = p.getAllPlaylists();
                return ResponseEntity.ok(allPlaylists);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error retrieving playlist(s): " + e.getMessage());
        }
    }
}
