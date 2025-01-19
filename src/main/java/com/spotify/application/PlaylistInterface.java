package com.spotify.application;

import com.spotify.application.dto.PlaylistDTO;
import java.util.List;

public interface PlaylistInterface {
    public PlaylistDTO getPlaylist();
    public void createPlaylist(List<List<String>> songData, String playlistName);
    public PlaylistDTO getPlaylistByName(String playlistName);
    public List<PlaylistDTO> getAllPlaylists();
}
