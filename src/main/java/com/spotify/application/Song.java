package com.spotify.application;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Song {
    private String title;
    private String artistName;
    private int playCount;

    public Song(String name, String artistName) {
        this.title = name;
        this.artistName = artistName;
        this.playCount = 0;
    }

    // Explicit getters and setters for serialization
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
}
