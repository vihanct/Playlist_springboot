//package com.spotify.application;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Artist {
//    String artistname;
//    HashMap<Song, Integer> top10songs = new HashMap<>();
//    List<Song> allsongs=new ArrayList<>();
//    int minncount = Integer.MAX_VALUE;
//    Song minimumtopsong;
//    public void retreive(){
//        for(Song it:allsongs){
//            System.out.println(it.title);
//        }
//    }
//    public Artist(String artistname) {
//        this.artistname = artistname;
//    }
//    public void gettop10songartist(){
////        List<Song> result=new ArrayList<>();
//        for(Song it:top10songs.keySet()){
//            System.out.println(it.title +" - "+top10songs.get(it));
////            result.add(it);
//        }
////        return result;
//    }
//    public void playsongartist(Song songname){
//        if(top10songs.size()<10) {
//            if (top10songs.containsKey(songname)) {
//                top10songs.put(songname, top10songs.get(songname) + 1);
//                if(minimumtopsong==songname) minncount++;
//            } else {
//                top10songs.put(songname, songname.playCount);
//                if(songname.playCount>minncount){
//                    minncount=Integer.MAX_VALUE;
//                    minimumtopsong=null;
//                    for(Song it:top10songs.keySet()){
//                        if(minncount>it.playCount){
//                            minncount=it.playCount;
//                            minimumtopsong=songname;
//                        }
//                    }
//                }
//            }
//        }
//        else if(songname.playCount>minncount){
//            //already 10 songs are there
//            //need to find new minimum
//            top10songs.remove(minimumtopsong);
//            top10songs.put(songname,songname.playCount);
//            minncount=Integer.MAX_VALUE;
//            minimumtopsong=null;
//            for(Song it:top10songs.keySet()){
//                if(minncount>it.playCount){
//                    minncount=it.playCount;
//                    minimumtopsong=songname;
//                }
//            }
//        }
//    }
//
//}