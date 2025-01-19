package com.spotify.application;

import com.spotify.application.dto.PlaylistDTO;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@Configuration
public class Playlist implements PlaylistInterface {
    private Map<String, PlaylistDTO> playlists;
    public Playlist() {
        this.playlists = new HashMap<>();
    }
    @Override
    public PlaylistDTO getPlaylist() {
        if (playlists.isEmpty()) {
            return new PlaylistDTO("Default Playlist", new ArrayList<>());
        }
        return playlists.values().iterator().next();
    }

    @Override
    public void createPlaylist(List<List<String>> songData, String playlistName) {
        PlaylistDTO playlist = playlists.getOrDefault(playlistName, 
            new PlaylistDTO(playlistName, new ArrayList<>()));
        for (List<String> data : songData) {
            String title = data.get(0);
            String artistName = data.size() > 1 && !data.get(1).trim().isEmpty() 
                ? data.get(1) 
                : "Unknown Artist";
            Song song = new Song(title, artistName);
            playlist.getSongs().add(song);
        }
        playlists.put(playlistName, playlist);
    }
    public PlaylistDTO getPlaylistByName(String playlistName) {
        return playlists.get(playlistName);
    }
    public List<PlaylistDTO> getAllPlaylists() {
        return new ArrayList<>(playlists.values());
    }
}
