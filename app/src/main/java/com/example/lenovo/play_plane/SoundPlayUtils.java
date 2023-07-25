package com.example.lenovo.play_plane;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 *
 * @author zsl
 * @blog http://blog.csdn.net/yy1300326388
 *
 */
public class SoundPlayUtils {
    // SoundPool对象
    public static SoundPool mSoundPlayer = new SoundPool(10,
            AudioManager.STREAM_SYSTEM, 5);
    public static SoundPlayUtils soundPlayUtils;
    // 上下文
    static Context mContext;

    /**
     * 初始化
     *
     * @param context
     */
    public static SoundPlayUtils init(Context context) {
        if (soundPlayUtils == null) {
            soundPlayUtils = new SoundPlayUtils();
        }

        // 初始化声音
        mContext = context;
        mSoundPlayer.load(mContext, R.raw.zd, 1);// 1
        mSoundPlayer.load(mContext, R.raw.boom, 1);// 2
        mSoundPlayer.load(mContext, R.raw.gameover, 1);// 3
        mSoundPlayer.load(mContext, R.raw.jp, 1);// 4
        return soundPlayUtils;
    }

    /**
     * 播放声音
     *
     * @param soundID
     */
    public static void play(int soundID,float left,float right) {
        mSoundPlayer.play(soundID, left, right, 0, 0, 1);
    }

}
