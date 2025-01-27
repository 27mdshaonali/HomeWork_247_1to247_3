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

public class BappaMozumdar extends AppCompatActivity {
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    ImageView artistImage;
    TextView artistName;
    ListView listView;
    MediaPlayer mediaPlayer;
    ImageView currentlyPlayingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bappa_mozumdar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        String stringArtistImageUrl = getIntent().getStringExtra("image_url");
        String stringArtistName = getIntent().getStringExtra("title");

        Picasso.get().load(stringArtistImageUrl).placeholder(R.drawable.shaon).into(artistImage);
        artistName.setText(stringArtistName);

        populateData();
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    }

    public void initialize() {

        artistImage = findViewById(R.id.artistImage);
        artistName = findViewById(R.id.artistName);
        listView = findViewById(R.id.listView);
        mediaPlayer = new MediaPlayer();
        currentlyPlayingButton = null;

    }

    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mozumdar/Bappa%20Mozumdar%202.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/%e0%a6%86%e0%a6%ae%e0%a6%bf%20%e0%a6%ae%e0%a7%87%e0%a6%b2%e0%a6%be%20%e0%a6%a5%e0%a7%87%e0%a6%95%e0%a7%87%20%e0%a6%a4%e0%a6%be%e0%a6%b2%20%e0%a6%aa%e0%a6%be%e0%a6%a4%e0%a6%be%e0%a6%b0%20-%20%e0%a6%95%e0%a6%a8%e0%a6%95%20%e0%a6%9a%e0%a6%be%e0%a6%81%e0%a6%aa%e0%a6%be%20--%20Ami%20Mela%20Theke%20Taal%20Paatar%20-%20Kanak%20Chapa.mp3");
        item1.put("song_name", "Bappa Mozumdar");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mozumdar/Bappa%20Mozumdar%202.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/%e0%a6%86%e0%a6%ae%e0%a6%bf%20%e0%a6%ae%e0%a7%87%e0%a6%b2%e0%a6%be%20%e0%a6%a5%e0%a7%87%e0%a6%95%e0%a7%87%20%e0%a6%a4%e0%a6%be%e0%a6%b2%20%e0%a6%aa%e0%a6%be%e0%a6%a4%e0%a6%be%e0%a6%b0%20-%20%e0%a6%95%e0%a6%a8%e0%a6%95%20%e0%a6%9a%e0%a6%be%e0%a6%81%e0%a6%aa%e0%a6%be%20--%20Ami%20Mela%20Theke%20Taal%20Paatar%20-%20Kanak%20Chapa.mp3");
        item2.put("song_name", "Bappa Mozumdar");
        item2.put("song_type", "Rock");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mozumdar/Bappa%20Mozumdar%202.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/%e0%a6%86%e0%a6%ae%e0%a6%bf%20%e0%a6%ae%e0%a7%87%e0%a6%b2%e0%a6%be%20%e0%a6%a5%e0%a7%87%e0%a6%95%e0%a7%87%20%e0%a6%a4%e0%a6%be%e0%a6%b2%20%e0%a6%aa%e0%a6%be%e0%a6%a4%e0%a6%be%e0%a6%b0%20-%20%e0%a6%95%e0%a6%a8%e0%a6%95%20%e0%a6%9a%e0%a6%be%e0%a6%81%e0%a6%aa%e0%a6%be%20--%20Ami%20Mela%20Theke%20Taal%20Paatar%20-%20Kanak%20Chapa.mp3");
        item3.put("song_name", "Bappa Mozumdar");
        item3.put("song_type", "Rock");
        arrayList.add(item3);

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

            ImageView artistSongImage = myView.findViewById(R.id.artistSongImage);
            TextView artistSongName = myView.findViewById(R.id.songName);
            TextView artistSongDescription = myView.findViewById(R.id.songDescription);
            ImageView playButton = myView.findViewById(R.id.playButton);

            String hashMapImageUrl = arrayList.get(i).get("artist_image_url");
            String hashMapAudioUrl = arrayList.get(i).get("audio_url");
            String hashMapSongName = arrayList.get(i).get("song_name");
            String hashMapSongDescription = arrayList.get(i).get("song_type");

            Picasso.get().load(hashMapImageUrl).placeholder(R.drawable.shaon).into(artistSongImage);
            artistSongName.setText(hashMapSongName);

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
                        mediaPlayer.setDataSource(hashMapAudioUrl);
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