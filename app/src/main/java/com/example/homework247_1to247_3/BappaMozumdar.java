package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b9%e0%a6%ac%e0%a7%87%20%e0%a6%ac%e0%a7%81%e0%a7%9c%e0%a6%bf%20-%20%e0%a6%ac%e0%a6%be%e0%a6%aa%e0%a7%8d%e0%a6%aa%e0%a6%be%20%e0%a6%ae%e0%a6%9c%e0%a7%81%e0%a6%ae%e0%a6%a6%e0%a6%be%e0%a6%b0%20_%20Tumi%20Hobe%20Buri%20-%20%20Bappa%20Majumdar.mp3");
        item1.put("song_name", "তুমি হবে বুড়ি - বাপ্পা মজুমদার _ Tumi Hobe Buri -  Bappa Majumdar");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/%e0%a6%a4%e0%a7%8b%e0%a6%ae%e0%a6%be%e0%a6%b0%20%e0%a6%ac%e0%a6%be%e0%a6%a1%e0%a6%bc%e0%a6%bf%e0%a6%b0%20%e0%a6%b0%e0%a6%99%e0%a7%87%e0%a6%b0%20%e0%a6%ae%e0%a7%87%e0%a6%b2%e0%a6%be%e0%a6%af%e0%a6%bc%20-%20%e0%a6%ac%e0%a6%be%e0%a6%aa%e0%a7%8d%e0%a6%aa%e0%a6%be%20%e0%a6%ae%e0%a6%9c%e0%a7%81%e0%a6%ae%e0%a6%a6%e0%a6%be%e0%a6%b0%20Tomar%20Barir%20Ronger%20Melay%20-%20Bappa%20Majumdar.mp3");
        item2.put("song_name", "তোমার বাড়ির রঙের মেলায় - বাপ্পা মজুমদার Tomar Barir Ronger Melay - Bappa Majumdar");
        item2.put("song_type", "Rock");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Bangla%20Song%20-%20Kadche%20Akash%20-%20Bappa%20Mazumder%20-%20Lyrical%20Video%20-%20Official%20-%20%e2%98%a2%e2%98%a2%20EXCLUSIVE%20%e2%98%a2%e2%98%a2.mp3");
        item3.put("song_name", "Bangla Song - Kadche Akash - Bappa Mazumder - Lyrical Video - Official - ☢☢ EXCLUSIVE ☢☢");
        item3.put("song_type", "Rock");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item4.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Bus.mp3");
        item4.put("song_name", "Bus");
        item4.put("song_type", "Rock");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item5.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Chokh%20Jora.mp3");
        item5.put("song_name", "Chokh Jora");
        item5.put("song_type", "Rock");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item6.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Elomelo%20Hoye%20Gelo-%20Bappa%20Mazumder-%20Bee%20Emmz%20Workstation-%202021.mp3");
        item6.put("song_name", "Elomelo Hoye Gelo- Bappa Mazumder- Bee Emmz Workstation- 2021");
        item6.put("song_type", "Rock");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item7.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Hoyto%20Ar%20Hobe%20Na.mp3");
        item7.put("song_name", "Hoyto Ar Hobe Na");
        item7.put("song_type", "Rock");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item8.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Kate%20Din%20Tobu.mp3");
        item8.put("song_name", "Kate Din Tobu");
        item8.put("song_type", "Rock");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item9.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Ke%20Je%20Amar.mp3");
        item9.put("song_name", "Ke Je Amar");
        item9.put("song_type", "Rock");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item10.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Nill%20Akash.mp3");
        item10.put("song_name", "Bappa Mozumdar Nill Akash");
        item10.put("song_type", "Rock");
        arrayList.add(item10);

        HashMap<String, String> item11 = new HashMap<>();
        item11.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Bappa%20Mazumdar/Bappa_Mazumder.jpg");
        item11.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Bappa%20Mazumdar/Raatprohori.mp3");
        item11.put("song_name", "Raatprohori");
        item11.put("song_type", "Rock");
        arrayList.add(item11);


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
            LinearLayout linearLayout = myView.findViewById(R.id.cardItemView);

            String hashMapImageUrl = arrayList.get(i).get("artist_image_url");
            String hashMapAudioUrl = arrayList.get(i).get("audio_url");
            String hashMapSongName = arrayList.get(i).get("song_name");
            String hashMapSongDescription = arrayList.get(i).get("song_type");

            Picasso.get().load(hashMapImageUrl).placeholder(R.drawable.shaon).into(artistSongImage);
            artistSongName.setText(hashMapSongName);

            linearLayout.setOnClickListener(v -> {

                AudioPlayer.MUSIC_SOURCE = hashMapAudioUrl;
                AudioPlayer.SONG_NAME = hashMapSongName;
                AudioPlayer.IMAGE_URL = hashMapImageUrl;

                startActivity(new Intent(BappaMozumdar.this, AudioPlayer.class));

            });

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