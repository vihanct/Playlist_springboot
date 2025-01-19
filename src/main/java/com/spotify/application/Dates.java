//package com.spotify.application;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//
//
//public class Dates{
//    LocalDate myObj;
//    HashMap<LocalDate, HashMap<Song, Integer>> map = new HashMap<>(); // date, top10songs
//    HashMap<LocalDate, Song> minimummap = new HashMap<>();
//    HashMap<LocalDate, Integer> minimumcount = new HashMap<>();
//
//    public Dates() {
//        myObj = LocalDate.now();
//    }
//    public void nextDay() {
//        System.out.println("local date earlier was " + myObj);
//        myObj = myObj.plusDays(1);
//        System.out.println("local date now is " + myObj);
//    }
//    public void gettop10songsdate(LocalDate d) {
//        if (map.containsKey(d)) {
//            for (Song it : map.get(d).keySet()) {
//                System.out.println(it.title + " - " + it.playCount);
//            }
//        } else {
//            System.out.println("No songs played on this date.");
//        }
//    }
//    public void playsongdate(LocalDate d, Song songname) {
//        map.putIfAbsent(d, new HashMap<>());
//        HashMap<Song, Integer> top10songs = map.get(d);
//        Integer minncount = minimumcount.getOrDefault(d, Integer.MAX_VALUE); //if no value is there then default is returned
//        Song minimumtopsong = minimummap.get(d);
//        if (top10songs.size() < 10) {
//            if (top10songs.containsKey(songname)) {
//                top10songs.put(songname, top10songs.get(songname) + 1);
//                if (minimumtopsong == songname) minncount++;
//            } else {
//                top10songs.put(songname, songname.playCount);
//                if (songname.playCount > minncount) {
//                    minncount = Integer.MAX_VALUE;
//                    minimumtopsong = null;
//                    for (Song it : top10songs.keySet()) {
//                        if (minncount > it.playCount) {
//                            minncount = it.playCount;
//                            minimumtopsong = it;
//                        }
//                    }
//                }
//            }
//        } else if (songname.playCount > minncount) {
//            top10songs.remove(minimumtopsong);
//            top10songs.put(songname, songname.playCount);
//            minncount = Integer.MAX_VALUE;
//            minimumtopsong = null;
//            for (Song it : top10songs.keySet()) {
//                if (minncount > it.playCount) {
//                    minncount = it.playCount;
//                    minimumtopsong = it;
//                }
//            }
//        }
//        map.put(d, top10songs);
//        minimumcount.put(d, minncount);
//        minimummap.put(d, minimumtopsong);
//    }
//}