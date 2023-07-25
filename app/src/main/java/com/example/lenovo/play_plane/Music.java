package com.example.lenovo.play_plane;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by Lenovo on 2021/12/13.
 */

public class Music extends Service {
    private MediaPlayer mediaPlayer;
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mediaPlayer == null) {
            // R.raw.mmp是资源文件，MP3格式的
            mediaPlayer = MediaPlayer.create(this, R.raw.yw);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        //    if(mediaPlayer2==null){
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
        mediaPlayer.release();
    }
}
