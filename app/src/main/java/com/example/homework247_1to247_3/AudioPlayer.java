package com.example.homework247_1to247_3;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class AudioPlayer extends AppCompatActivity {

    public static String MUSIC_SOURCE = "";
    public static String SONG_NAME = "";
    public static String IMAGE_URL = "";

    TextView currentTime, totalTime, songName;
    SeekBar seekBar;
    RoundedImageView btnPause, audioArtistImage;
    static MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    ObjectAnimator rotate;

    public Runnable updater = new Runnable() {
        @Override
        public void run() {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                long currentDuration = mediaPlayer.getCurrentPosition();
                seekBar.setProgress((int) (((float) currentDuration / mediaPlayer.getDuration()) * 100));
                currentTime.setText(millisecondsToString(currentDuration));
                handler.postDelayed(this, 1000);
            }
        }
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_audio_player);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();
        songName.setText(SONG_NAME);
        Picasso.get().load(IMAGE_URL).placeholder(R.drawable.shaon).into(audioArtistImage);
        rotatingImage();
        seekBar.setMax(100);

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        prepareMediaPlayer();
        mediaPlayer.start();
        rotate.start();

        btnPause.setImageResource(R.drawable.pause_icon);
        updateSeekBar();

        btnPause.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    rotate.pause();
                    btnPause.setImageResource(R.drawable.play_icon2);
                } else {
                    mediaPlayer.start();
                    rotate.resume();
                    btnPause.setImageResource(R.drawable.pause_icon);
                    updateSeekBar();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    int playPosition = (mediaPlayer.getDuration() * progress) / 100;
                    mediaPlayer.seekTo(playPosition);
                    currentTime.setText(millisecondsToString(mediaPlayer.getCurrentPosition()));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(updater);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateSeekBar();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            rotate.pause();
        }
    }

    public void prepareMediaPlayer() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(MUSIC_SOURCE);
            mediaPlayer.prepare();
            totalTime.setText(millisecondsToString(mediaPlayer.getDuration()));
        } catch (Exception e) {
            Toast.makeText(AudioPlayer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void initialize() {
        currentTime = findViewById(R.id.currentTime);
        totalTime = findViewById(R.id.totalDuration);
        songName = findViewById(R.id.songName);
        seekBar = findViewById(R.id.seekBar);
        btnPause = findViewById(R.id.btnPause);
        audioArtistImage = findViewById(R.id.audioArtistImage);
    }

    public void updateSeekBar() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            int progress = (int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100);
            seekBar.setProgress(progress);
            handler.postDelayed(updater, 1000);
        }
    }

    public String millisecondsToString(long milliseconds) {
        String timerString = "";
        String secondString;

        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (hours > 0) {
            timerString = hours + ":";
        }
        secondString = (seconds < 10) ? "0" + seconds : "" + seconds;

        timerString = timerString + minutes + ":" + secondString;
        return timerString;
    }

    public void rotatingImage() {
        rotate = ObjectAnimator.ofFloat(audioArtistImage, "rotation", 0f, 360f);
        rotate.setDuration(4000);
        rotate.setRepeatCount(ObjectAnimator.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.pause();
    }
}
