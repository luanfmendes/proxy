package org.example;

public class VideoServiceProxy implements VideoService{
    private RealVideoService realVideoService;
    private boolean isPremiumUser;

    public VideoServiceProxy(boolean isPremiumUser) {
        this.isPremiumUser = isPremiumUser;
        this.realVideoService = new RealVideoService();
    }
    @Override
    public void playVideo(String videoName) {
        if (isPremiumUser) {
            realVideoService.playVideo(videoName);
        } else {
            System.out.println("Acesso negado. Apenas usuários premium podem assistir a este vídeo.");
        }
    }
}
