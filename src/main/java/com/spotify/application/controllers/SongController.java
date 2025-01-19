package com.spotify.application.controllers;

import com.spotify.application.SongInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    @PostMapping("/add-songs")
    public void addSong(@RequestBody SongInformation songinformation){
        SongInformation si=new SongInformation();
        System.out.println(si.getSongArtist());
        System.out.println("Song has been added succesfully!");
    }

    @GetMapping("/songs")
    public String getSongs(){
        return "song1 , song2 ,song3";
    }
}
