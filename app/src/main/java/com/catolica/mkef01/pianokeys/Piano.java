package com.catolica.mkef01.pianokeys;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Piano extends AppCompatActivity {

    private SoundPool soundPool;
    private int DO,RE,MI,FA,SOL,LA,SI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            soundPool = new SoundPool.Builder().setMaxStreams(7).setAudioAttributes(audioAttributes).build();
        }else{
            soundPool = new SoundPool(6,AudioManager.STREAM_MUSIC,0);
        }

        DO = soundPool.load(this,R.raw.teclado,1);
        RE = soundPool.load(this,R.raw.teclare,1);
        MI = soundPool.load(this,R.raw.teclami,1);
        FA = soundPool.load(this,R.raw.teclafa,1);
        SOL = soundPool.load(this,R.raw.teclasol,1);
        LA = soundPool.load(this,R.raw.teclala,1);
        SI = soundPool.load(this,R.raw.teclasi,1);
    }

    public void btnDO(View v){
        soundPool.play(DO,1,1,0,0,1);
    }
    public void btnRE(View v){
        soundPool.play(RE,1,1,0,0,1);
    }
    public void btnMI(View v){
        soundPool.play(MI,1,1,0,0,1);
    }
    public void btnFA(View v){
        soundPool.play(FA,1,1,0,0,1);
    }
    public void btnSOL(View v){
        soundPool.play(SOL,1,1,0,0,1);
    }
    public void btnLA(View v){
        soundPool.play(LA,1,1,0,0,1);
    }
    public void btnSI(View v){
        soundPool.play(SI,1,1,0,0,1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
