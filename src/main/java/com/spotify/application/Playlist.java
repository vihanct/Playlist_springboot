package com.spotify.application;

import com.spotify.application.dto.PlaylistDTO;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;

import com.spotify.application.Song;

@Configuration
public class Playlist implements PlaylistInterface {
    private static final Logger logger = Logger.getLogger(Playlist.class.getName());
    private Map<String, PlaylistDTO> playlists;
    
    public Playlist() {
        // Initialize with an empty map of playlists
        this.playlists = new HashMap<>();
    }
    
    @Override
    public PlaylistDTO getPlaylist() {
        // Return the first playlist or a default one if none exists
        if (playlists.isEmpty()) {
            return new PlaylistDTO("Default Playlist", new ArrayList<>());
        }
        return playlists.values().iterator().next();
    }

    @Override
    public void createPlaylist(List<List<String>> songData, String playlistName) {
        // Get existing playlist or create new one
        PlaylistDTO playlist = playlists.getOrDefault(playlistName, 
            new PlaylistDTO(playlistName, new ArrayList<>()));
        
        logger.info("Adding songs to playlist: " + playlistName);
        
        for (List<String> data : songData) {
            String title = data.get(0);
            String artistName = data.size() > 1 && !data.get(1).trim().isEmpty() 
                ? data.get(1) 
                : "Unknown Artist";
            
            Song song = new Song(title, artistName);
            playlist.getSongs().add(song);
            logger.info(String.format("Added song: '%s' by '%s'", title, artistName));
        }

        // Store or update the playlist in the map
        playlists.put(playlistName, playlist);
        logger.info("Playlist '" + playlistName + "' now has " + playlist.getSongs().size() + " songs");
    }

    // New method to get a specific playlist
    public PlaylistDTO getPlaylistByName(String playlistName) {
        return playlists.get(playlistName);
    }

    // New method to get all playlists
    public List<PlaylistDTO> getAllPlaylists() {
        return new ArrayList<>(playlists.values());
    }
}
