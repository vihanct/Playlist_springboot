package com.spotify.application;

import lombok.*;
import lombok.Data;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode

@Data //we use this annotation got all it adds all the annotation
public class SongInformation {
    private  String songname;
    private String songArtist;
//    public SongInformation(String songname,String songArtist){
//        this.songname=songname;
//        this.songArtist=songArtist;
//    }


    public String getSongArtist() {
        return songArtist;
    }
}
