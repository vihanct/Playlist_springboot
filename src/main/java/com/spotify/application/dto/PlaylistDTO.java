package com.spotify.application.dto;

import com.spotify.application.Song;
import java.util.List;

public class PlaylistDTO {
    private String name;
    private List<Song> songs;

    public PlaylistDTO(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
