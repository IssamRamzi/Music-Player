package com.ramzi.Main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.xml.xpath.XPath;

public class Music {
    private String title, artist, album, path;
    private int duration;
    private Clip clip; // Store the Clip as a class member

    private static boolean playing;
    public Music(String path){
        this.path = path;
    }
    public Music(String title, String artist, String album, String path, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.path = path;
        this.duration = duration;
    }

    public void getMusicDetails() {
        System.out.println("Title : " + this.title + "\nArtist : " + this.artist + "\nDuration : " + this.duration);
    }

    public void play() {
        this.reset();
        try {
            File musicPath = new File(this.path);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip(); // Store the Clip object
                clip.open(audioInput);
                clip.start();
                Music.playing = true;
            } else System.out.println("Music Not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // Pause the audio if it's currently playing
        }
    }
    public void resume(){
        if(clip !=null && !clip.isRunning()){
            clip.start();
        }
    }
    public void reset(){
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
    }
}
