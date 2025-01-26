package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RunaLailaSongsList extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ImageView artistImage;
    TextView artistName;
    ListView listView;
    ImageView currentlyPlayingButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_runa_laila);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        String imageUrl = getIntent().getStringExtra("image_url");
        String artistNameStr = getIntent().getStringExtra("title");

        Picasso.get().load(imageUrl).placeholder(R.drawable.shaon).into(artistImage);
        artistName.setText(artistNameStr);

        populateData();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    }

    public void initialize() {
        artistImage = findViewById(R.id.artistImage);
        artistName = findViewById(R.id.artistName);
        listView = findViewById(R.id.listView);
        currentlyPlayingButton = null;
        mediaPlayer = new MediaPlayer();

    }

    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Runa%20Laila/Runa%20Laila.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%95%e0%a6%ac%e0%a6%bf%e0%a6%a4%e0%a6%be%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b8%e0%a7%8d%e0%a6%ac%e0%a6%aa%e0%a7%8d%e0%a6%a8%e0%a6%9a%e0%a6%be%e0%a6%b0%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%b9%e0%a6%af%e0%a6%bc%e0%a7%87%20_%20Kobita%20_%20James%20_%20Lyrics.mp3");
        item1.put("song_name", "Song Name 1");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Runa%20Laila/Runa%20Laila.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%95%e0%a6%ac%e0%a6%bf%e0%a6%a4%e0%a6%be%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b8%e0%a7%8d%e0%a6%ac%e0%a6%aa%e0%a7%8d%e0%a6%a8%e0%a6%9a%e0%a6%be%e0%a6%b0%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%b9%e0%a6%af%e0%a6%bc%e0%a7%87%20_%20Kobita%20_%20James%20_%20Lyrics.mp3");
        item2.put("song_name", "Song Name 2");
        item2.put("song_type", "Rock");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Runa%20Laila/Runa%20Laila.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%95%e0%a6%ac%e0%a6%bf%e0%a6%a4%e0%a6%be%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b8%e0%a7%8d%e0%a6%ac%e0%a6%aa%e0%a7%8d%e0%a6%a8%e0%a6%9a%e0%a6%be%e0%a6%b0%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%b9%e0%a6%af%e0%a6%bc%e0%a7%87%20_%20Kobita%20_%20James%20_%20Lyrics.mp3");
        item3.put("song_name", "Song Name 3");
        item3.put("song_type", "Rock");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Runa%20Laila/Runa%20Laila.jpg");
        item4.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%95%e0%a6%ac%e0%a6%bf%e0%a6%a4%e0%a6%be%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b8%e0%a7%8d%e0%a6%ac%e0%a6%aa%e0%a7%8d%e0%a6%a8%e0%a6%9a%e0%a6%be%e0%a6%b0%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%b9%e0%a6%af%e0%a6%bc%e0%a7%87%20_%20Kobita%20_%20James%20_%20Lyrics.mp3");
        item4.put("song_name", "Song Name 4");
        item4.put("song_type", "Rock");
        arrayList.add(item4);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

        mediaPlayer.release();
        mediaPlayer = null;

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View myView = inflater.inflate(R.layout.music_list_layout, viewGroup, false);

            LinearLayout linearLayout = myView.findViewById(R.id.cardItemView);
            TextView songName = myView.findViewById(R.id.songName);
            TextView songType = myView.findViewById(R.id.songDescription);
            ImageView songImage = myView.findViewById(R.id.artistSongImage);
            ImageView playButton = myView.findViewById(R.id.playButton);

            String stringSongName = arrayList.get(i).get("song_name");
            String stringSongType = arrayList.get(i).get("song_type");
            String stringSongImage = arrayList.get(i).get("artist_image_url");
            String stringAudioUrl = arrayList.get(i).get("audio_url");

            Picasso.get().load(stringSongImage).placeholder(R.drawable.shaon).into(songImage);
            songName.setText(stringSongName);

            playButton.setTag("PLAY_NOW");
            playButton.setImageResource(R.drawable.play_icon2);

            playButton.setOnClickListener(v -> {

                try {

                    if (currentlyPlayingButton != null && currentlyPlayingButton == playButton) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();
                            playButton.setImageResource(R.drawable.play_icon2);
                            playButton.setTag("PLAY_NOW");
                        } else {
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            playButton.setImageResource(R.drawable.pause_icon);
                            playButton.setTag("PLAYING");
                        }

                    } else {

                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                        }

                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(stringAudioUrl);
                        mediaPlayer.prepareAsync();

                        mediaPlayer.setOnPreparedListener(mp -> {
                            mp.start();
                            playButton.setImageResource(R.drawable.pause_icon);
                            playButton.setTag("PLAYING");

                            if (currentlyPlayingButton != null && currentlyPlayingButton != playButton) {
                                currentlyPlayingButton.setImageResource(R.drawable.play_icon2);
                                currentlyPlayingButton.setTag("PLAY_NOW");

                            }

                            currentlyPlayingButton = playButton;

                        });

                        mediaPlayer.setOnCompletionListener(mp -> {
                            playButton.setTag("PLAY_NOW");
                            playButton.setImageResource(R.drawable.play_icon2);
                            currentlyPlayingButton = null;

                        });

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }


            });

            return myView;
        }
    }

}