//package com.spotify.application;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//
//public class MusicPlayer{
//    Dates date=new Dates();
//    HashMap<Song,Integer> top10songs=new HashMap<>();//wrt total count
//    HashMap<Song,Artist> songs=new HashMap<>();
//    int minncount=Integer.MAX_VALUE;
//    Song minimumtopsong;
//    HashMap<String ,Song> findingmap1=new HashMap<>();
//    HashMap<String ,Artist> findingmap2=new HashMap<>();
//    public void AddSong(String songname, String artistname) {
//        Song song = new Song(songname);
//        Artist artist;
//        if (findingmap2.containsKey(artistname)) {
//            artist = findingmap2.get(artistname);
//            artist.allsongs.add(song);
//        } else {
//            artist = new Artist(artistname);
//            findingmap2.put(artistname, artist);
//            artist.allsongs.add(song);
//        }
//        findingmap1.put(songname, song);
//        songs.put(song, artist);
//    }
//    public void AddSong(String songname){
//        Song song =new Song(songname);
//        Artist artist=new Artist("dummy");
//        artist.allsongs.add(song);
//        findingmap1.put(songname,song);
//        songs.put(song ,artist);
//    }
//    public void gettop10song(){
//        for(Song it:top10songs.keySet()){
//            System.out.println(it.title +" - "+top10songs.get(it));
//        }
//    }
//    public void gettop10songbyartist(String artistName) {
//        if (!findingmap2.containsKey(artistName)) {
//            System.out.println("Artist not found: " + artistName);
//            return;
//        }
//        Artist artist = findingmap2.get(artistName);
//        System.out.println("Top 10 songs by " + artistName + ":");
//        artist.gettop10songartist();
//    }
//
//    public void playsong(String s){
//        if(!findingmap1.containsKey(s)) return;
//        Song songname=findingmap1.get(s);
//        if(songname==null) return;
//        songname.playCount++;
//        songs.get(songname).playsongartist(songname);
//        date.playsongdate(date.myObj,songname);
//        if (top10songs.size() < 10) {
//            if (top10songs.containsKey(songname)) {
//                top10songs.put(songname, top10songs.get(songname) + 1);
//            } else {
//                top10songs.put(songname, songname.playCount);
//            }
//        } else if (minncount < songname.playCount) {
//            top10songs.remove(minimumtopsong);
//            top10songs.put(songname, songname.playCount);
//        }
//
//        // Recalculate the minimum play count and minimum top song
//        minncount = Integer.MAX_VALUE;
//        minimumtopsong = null;
//        for (Song it : top10songs.keySet()) {
//            if (minncount > it.playCount) {
//                minncount = it.playCount;
//                minimumtopsong = it;
//            }
//        }
//    }
//    public void retrivesong(String artistName){
//        if (!findingmap2.containsKey(artistName)) {
//            System.out.println("Artist not found: " + artistName);
//            return;
//        }
//        Artist artist = findingmap2.get(artistName);
//        artist.retreive();
//    }
//    public void GotoNextDay(){
//        date.nextDay();
//    }
//    public void gettop10songbydate(LocalDate d){
//        date.gettop10songsdate(d);
//    }
//}