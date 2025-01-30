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

public class KanakChapaLailaSongsList extends AppCompatActivity {

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
        setContentView(R.layout.activity_kanak_chapa);
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
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/%e0%a6%86%e0%a6%ae%e0%a6%bf%20%e0%a6%ae%e0%a7%87%e0%a6%b2%e0%a6%be%20%e0%a6%a5%e0%a7%87%e0%a6%95%e0%a7%87%20%e0%a6%a4%e0%a6%be%e0%a6%b2%20%e0%a6%aa%e0%a6%be%e0%a6%a4%e0%a6%be%e0%a6%b0%20-%20%e0%a6%95%e0%a6%a8%e0%a6%95%20%e0%a6%9a%e0%a6%be%e0%a6%81%e0%a6%aa%e0%a6%be%20--%20Ami%20Mela%20Theke%20Taal%20Paatar%20-%20Kanak%20Chapa.mp3");
        item1.put("song_name", "আমি মেলা থেকে তাল পাতার - কনক চাঁপা -- Ami Mela Theke Taal Paatar - Kanak Chapa");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/%e0%a6%a4%e0%a7%8b%e0%a6%ae%e0%a6%be%e0%a6%b0%e0%a7%87%20%e0%a6%b2%e0%a7%87%e0%a6%97%e0%a7%87%e0%a6%9b%e0%a7%87%20%e0%a6%8f%e0%a6%a4%20%e0%a6%af%e0%a7%87%20%e0%a6%ad%e0%a6%be%e0%a6%b2%e0%a7%8b%20-%20Tomare%20Legeche%20Eto%20Je%20Valo.mp3");
        item2.put("song_name", "তোমারে লেগেছে এত যে ভালো - Tomare Legeche Eto Je Valo");
        item2.put("song_type", "Rock");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Aj%20bekele%20tmr%20dake%20chiti%20pelam.mp3");
        item3.put("song_name", "Aj bekele tmr dake chiti pelam");
        item3.put("song_type", "Rock");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item4.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Aj%20tobe.mp3");
        item4.put("song_name", "Aj tobe");
        item4.put("song_type", "Rock");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item5.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Akash%20Eto%20Meghla%20by%20kanak%20Chapa%20with%20subtitles.mp3");
        item5.put("song_name", "Akash Eto Meghla by kanak Chapa with subtitles" );
        item5.put("song_type", "Rock");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item6.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Ami%20Abujer%20Moto%20Eke%20Kare%20Si%20Kanak%20Chapa%20EHCE.mp3");
        item6.put("song_name", "Ami Abujer Moto Eke Kare Si Kanak Chapa EHCE");
        item6.put("song_type", "Rock");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item7.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Bangla%20song%202020%20%20Khola%20Akash%20-%20Konok%20Chapa%20-%20%e0%a6%96%e0%a7%8b%e0%a6%b2%e0%a6%be%20%e0%a6%86%e0%a6%95%e0%a6%be%e0%a6%b6%20-%20%e0%a6%95%e0%a6%a8%e0%a6%95%20%e0%a6%9a%e0%a6%be%e0%a6%aa%e0%a6%be%20(%20%e0%a6%ae%e0%a6%b9%e0%a6%b8%e0%a6%bf%e0%a6%a8%20).mp3");
        item7.put("song_name", "Bangla song 2020  Khola Akash - Konok Chapa - খোলা আকাশ - কনক চাপা ( মহসিন )");
        item7.put("song_type", "Rock");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item8.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Bhalobasha%20Bhalobasha%20Thako%20Tumi%20Dure%20-%20Kanak%20Chapa%20-%20Movie%20Song%20-%20Channel%20i.mp3");
        item8.put("song_name", "Bhalobasha Bhalobasha Thako Tumi Dure - Kanak Chapa - Movie Song - Channel i");
        item8.put("song_type", "Rock");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item9.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Chotto%20Ekta%20Jibon%20Niye%20-%20Kanak%20Chapa%20-%20Movie%20Song%20-%20Channel%20i.mp3");
        item9.put("song_name", "Chotto Ekta Jibon Niye - Kanak Chapa - Movie Song - Channel i");
        item9.put("song_type", "Rock");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item10.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Ogo%20Bristi%20Amar%20%e0%a5%a4%20%e0%a6%93%20%e0%a6%97%e0%a7%8b%20%e0%a6%ac%e0%a7%83%e0%a6%b7%e0%a7%8d%e0%a6%9f%e0%a6%bf%20%e0%a6%86%e0%a6%ae%e0%a6%be%e0%a6%b0%20%e0%a5%a4%20%20Kanak%20Chapa%20%e0%a5%a4%20%20Digital%20Sound%20%e0%a5%a4%20%20Kashem%20Studio.mp3");
        item10.put("song_name", "Ogo Bristi Amar । ও গো বৃষ্টি আমার ।  Kanak Chapa ।  Digital Sound ।  Kashem Studio");
        item10.put("song_type", "Rock");
        arrayList.add(item10);

        HashMap<String, String> item11 = new HashMap<>();
        item11.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item11.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Tumi%20nahoy%20rohite%20kachhe%20%20%20Harano%20diner%20gan%20%20%20%20%20YouTube.mp3");
        item11.put("song_name", "Tumi nahoy rohite kachhe   Harano diner gan     YouTube");
        item11.put("song_type", "Rock");
        arrayList.add(item11);

        HashMap<String, String> item12 = new HashMap<>();
        item12.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Kanak%20Chapa/Kanak%20Chapa%202.jpg");
        item12.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Kanak%20Chapa/Amon%20ekta%20jhinuk%20khuje%20pelam%20na%20kanakchapa%20%5bmain%20singer%20nirmola%20misro%20%5d.mp3");
        item12.put("song_name", "Amon ekta jhinuk khuje pelam na kanakchapa [main singer nirmola misro ]");
        item12.put("song_type", "Rock");
        arrayList.add(item12);

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

            linearLayout.setOnClickListener(v -> {

                AudioPlayer.MUSIC_SOURCE = stringAudioUrl;
                AudioPlayer.SONG_NAME = stringSongName;
                AudioPlayer.IMAGE_URL = stringSongImage;

                startActivity(new Intent(KanakChapaLailaSongsList.this, AudioPlayer.class));

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