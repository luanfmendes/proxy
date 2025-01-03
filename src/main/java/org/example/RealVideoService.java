package org.example;

public class RealVideoService implements VideoService{
    @Override
    public void playVideo(String videoName) {
        System.out.println("Reproduzindo vídeo:" + videoName);
    }
}
