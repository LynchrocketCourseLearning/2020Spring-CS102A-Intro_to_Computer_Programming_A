package sound;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Music {
    private AudioClip au;
    private String url;

    public void setMusic(String url){
        this.url=url;
        playMusic();
    }
    //创建音乐
    public void playMusic(){
        try {
            File f = new File(url); //url这里放音乐路径。
            au = Applet.newAudioClip(f.toURI().toURL());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No such file exists!");
        }
    }
    //控制音乐的方法
    public void controlMusic(int n) {
        switch (n) {
            case 1:
                au.play();//开始播放
                break;
            case 2:
                au.stop(); //停止播放
                break;
            case 3:
                au.loop();//循环播放
                break;
            default:
                break;
        }
    }


}
