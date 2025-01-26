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

public class AyubBacchhuSongsList extends AppCompatActivity {

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

    // Populate the list with songs data
    public void populateData() {

        HashMap<String, String> item1 = new HashMap<>();
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/%e0%a6%85%e0%a6%ad%e0%a6%bf%e0%a6%ae%e0%a6%be%e0%a6%a8%20%e0%a6%a8%e0%a6%bf%e0%a7%9f%e0%a7%87%20-%20Lyrics%20-%20Oviman%20Niye%20-%20%e0%a6%86%e0%a6%87%e0%a6%af%e0%a6%bc%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20Ayub%20Bachchu%20-%20LRB.mp3");
        item1.put("song_name", "অভিমান নিয়ে - Lyrics - Oviman Niye - আইয়ুব বাচ্চু - Ayub Bachchu - LRB");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/%e0%a6%86%e0%a6%ae%e0%a6%bf%20%e0%a6%95%e0%a6%b7%e0%a7%8d%e0%a6%9f%20%e0%a6%aa%e0%a7%87%e0%a6%a4%e0%a7%87%20%e0%a6%ad%e0%a6%be%e0%a6%b2%e0%a7%8b%e0%a6%ac%e0%a6%be%e0%a6%b8%e0%a6%bf%20%20-%20Ayub%20Bachchu%20-%20Mp3%20Music%2024.mp3");
        item2.put("song_name", "আমি কষ্ট পেতে ভালোবাসি  - Ayub Bachchu - Mp3 Music 24");
        item2.put("song_type", "Folk");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/%e0%a6%a4%e0%a6%bf%e0%a6%a8%20%e0%a6%aa%e0%a7%81%e0%a6%b0%e0%a7%81%e0%a6%b7...%e0%a6%86%e0%a6%ae%e0%a6%be%e0%a6%b0%20%e0%a6%a4%e0%a6%bf%e0%a6%a8%20%e0%a6%aa%e0%a7%81%e0%a6%b0%e0%a7%81%e0%a6%b7%20-%20%e0%a6%86%e0%a6%87%e0%a7%9f%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20%e0%a5%a4.mp3");
        item3.put("song_name", "তিন পুরুষ...আমার তিন পুরুষ - আইয়ব বাচ্চু ।");
        item3.put("song_type", "Folk");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item4.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/%e0%a6%a4%e0%a7%8b%e0%a6%ae%e0%a6%be%e0%a6%b0%20%e0%a6%95%e0%a6%be%e0%a6%b0%e0%a6%a8%e0%a7%87%20-%20Lyrics%20-%20Tomar%20Karone%20-%20%e0%a6%86%e0%a6%87%e0%a6%af%e0%a6%bc%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20Ayub%20Bachchu%20I%20LRB%20-%20Bangla%20Song%20-%201080p.mp3");
        item4.put("song_name", "তোমার কারনে - Lyrics - Tomar Karone - আইয়ুব বাচ্চু - Ayub Bachchu I LRB - Bangla Song");
        item4.put("song_type", "Folk");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item5.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Amito%20Preme%20Porini%20Ayub%20Bachchu.mp3");
        item5.put("song_name", "Amito Preme Porini Ayub Bachchu");
        item5.put("song_type", "Folk");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item6.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Ayub%20Bachchu-Ekta%20Din%20Chol%20Nodir%202022%20%e0%a6%86%e0%a6%87%e0%a6%af%e0%a6%bc%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81-%e0%a6%8f%e0%a6%95%e0%a6%9f%e0%a6%be%e0%a6%a6%e0%a6%bf%e0%a6%a8%20%e0%a6%9a%e0%a6%b2%20%e0%a6%a8%e0%a6%a6%e0%a7%80%e0%a6%b0%20%e0%a6%89%e0%a6%aa%e0%a6%b0%20%e0%a6%98%e0%a6%b0%20%e0%a6%ac%e0%a6%be%e0%a6%a7%e0%a6%bf%20%e0%a6%ae%e0%a7%8b%e0%a6%b0%e0%a6%be.mp3");
        item6.put("song_name", "Ayub Bachchu-Ekta Din Chol Nodir 2022 আইয়ুব বাচ্চু-একটাদিন চল নদীর উপর ঘর বাধি মোরা");
        item6.put("song_type", "Folk");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item7.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Ek%20Akash%20Tara%20-%20Shawkat%20Ft.%20Ayub%20Bachchu%20-%20%e0%a6%86%e0%a6%87%e0%a7%9f%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20%e0%a6%8f%e0%a6%95%20%e0%a6%86%e0%a6%95%e0%a6%be%e0%a6%b6%20%e0%a6%a4%e0%a6%be%e0%a6%b0%e0%a6%be%20-%20Music%20Video.mp3");
        item7.put("song_name", "Baro Mash - বার মাস - Ayub Bachchu - LRB - Ami baro mash tomay valobashi - Lyrics Video");
        item7.put("song_type", "Folk");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item8.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Ek%20Akash%20Tara%20-%20Shawkat%20Ft.%20Ayub%20Bachchu%20-%20%e0%a6%86%e0%a6%87%e0%a7%9f%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20%e0%a6%8f%e0%a6%95%20%e0%a6%86%e0%a6%95%e0%a6%be%e0%a6%b6%20%e0%a6%a4%e0%a6%be%e0%a6%b0%e0%a6%be%20-%20Music%20Video.mp3");
        item8.put("song_name", "Bonolota shen by ayub bacchu bangla song");
        item8.put("song_type", "Folk");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item9.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Ek%20Chala%20Tiner%20Ghor%20%20%20Ayub%20Bachchu%20%20%20LRB%20%20%20Bd%20song%20mp3%20full%20with%20Lyrics.mp3");
        item9.put("song_name", "Ek Akash Tara - Shawkat Ft. Ayub Bachchu - আইয়ুব বাচ্চু - এক আকাশ তারা - Music Video");
        item9.put("song_type", "Folk");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item10.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Meye%20-%20%e0%a6%ae%e0%a7%87%e0%a7%9f%e0%a7%87%20-%20%20Ayub%20Bachchu%20-%20Niaz%20Ahmed%20Aungshu%20-%20AB%20Kitchen.mp3");
        item10.put("song_name", "Ek Chala Tiner Ghor   Ayub Bachchu   LRB   Bd song mp3 full with Lyrics");
        item10.put("song_type", "Folk");
        arrayList.add(item10);

        HashMap<String, String> item11 = new HashMap<>();
        item11.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item11.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Mone%20Ache%20Naki%20Nai.%20-%20%e0%a6%ae%e0%a6%a8%e0%a7%87%20%e0%a6%86%e0%a6%9b%e0%a7%87%20%e0%a6%a8%e0%a6%be%e0%a6%95%e0%a6%bf%20%e0%a6%a8%e0%a6%be%e0%a6%87.%20-%20LRB%20-%20Ayub%20Bachchu%20-%20%e0%a6%ae%e0%a6%a8%e0%a7%87%20%e0%a6%86%e0%a6%9b%e0%a7%87%20%e0%a6%a8%e0%a6%be%e0%a6%95%e0%a6%bf%20%e0%a6%a8%e0%a6%be%e0%a6%87%20-%20AB%20Kitchen.mp3");
        item11.put("song_name", "Meye - মেয়ে -  Ayub Bachchu - Niaz Ahmed Aungshu - AB Kitchen");
        item11.put("song_type", "Folk");
        arrayList.add(item11);

        HashMap<String, String> item12 = new HashMap<>();
        item12.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item12.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Nodir%20Buke%20Chad%20-%20Shawkat%20Ft.%20Ayub%20Bachchu%20-%20%e0%a6%a8%e0%a6%a6%e0%a7%80%e0%a6%b0%20%e0%a6%ac%e0%a7%81%e0%a6%95%e0%a7%87%20%e0%a6%9a%e0%a6%be%e0%a6%81%e0%a6%a6%20-%20%e0%a6%86%e0%a6%87%e0%a7%9f%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20Music%20Video.mp3");
        item12.put("song_name", "Mone Ache Naki Nai. - মনে আছে নাকি নাই. - LRB - Ayub Bachchu - মনে আছে নাকি নাই - AB Kitchen");
        item12.put("song_type", "Folk");
        arrayList.add(item12);

        HashMap<String, String> item13 = new HashMap<>();
        item13.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item13.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/O%20Amar%20Sokhi%20%20%20Aiyub%20Bachu%20with%20Lyric.mp3");
        item13.put("song_name", "Nodir Buke Chad - Shawkat Ft. Ayub Bachchu - নদীর বুকে চাঁদ - আইয়ুব বাচ্চু - Music Video");
        item13.put("song_type", "Folk");
        arrayList.add(item13);

        HashMap<String, String> item14 = new HashMap<>();
        item14.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item14.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Sei%20tumi%20keno%20eto%20ochena%20hole%20-%20Ayub%20Bachchu%20-%20LRB%20-%20%e0%a6%b8%e0%a7%87%e0%a6%87%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%95%e0%a7%87%e0%a6%a8%20%e0%a6%8f%e0%a6%a4%e0%a7%8b%20%e0%a6%85%e0%a6%9a%e0%a7%87%e0%a6%a8%e0%a6%be%20%e0%a6%b9%e0%a6%b2%e0%a7%87.mp3");
        item14.put("song_name", "O Amar Sokhi   Aiyub Bachu with Lyric");
        item14.put("song_type", "Folk");
        arrayList.add(item14);

        HashMap<String, String> item15 = new HashMap<>();
        item15.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item15.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Tomar%20Chokhe%20Dekhle%20-%20Shawkat%20Ft.%20Ayub%20Bachchu%20-%20%e0%a6%a4%e0%a7%8b%e0%a6%ae%e0%a6%be%e0%a6%b0%20%e0%a6%9a%e0%a7%8b%e0%a6%96%e0%a7%87%20%e0%a6%a6%e0%a7%87%e0%a6%96%e0%a6%b2%e0%a7%87%20-%20%e0%a6%86%e0%a6%87%e0%a7%9f%e0%a7%81%e0%a6%ac%20%e0%a6%ac%e0%a6%be%e0%a6%9a%e0%a7%8d%e0%a6%9a%e0%a7%81%20-%20Music%20Video.mp3");
        item15.put("song_name", "Sei tumi keno eto ochena hole - Ayub Bachchu - LRB - সেই তুমি কেন এতো অচেনা হলে");
        item15.put("song_type", "Folk");
        arrayList.add(item15);

        HashMap<String, String> item16 = new HashMap<>();
        item16.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item16.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/Ural%20Debo%20Akashe%20-%20%e0%a6%89%e0%a7%9c%e0%a6%be%e0%a6%b2%20%e0%a6%a6%e0%a7%87%e0%a6%ac%20%e0%a6%86%e0%a6%95%e0%a6%be%e0%a6%b6%e0%a7%87%20-%20Ayub%20Bachchu%20-%20%e0%a6%aa%e0%a7%8d%e0%a6%b0%e0%a7%87%e0%a6%ae%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%95%e0%a6%bf%20..mp3");
        item16.put("song_name", "Tomar Chokhe Dekhle - Shawkat Ft. Ayub Bachchu - তোমার চোখে দেখলে - আইয়ুব বাচ্চু");
        item16.put("song_type", "Folk");
        arrayList.add(item16);

        HashMap<String, String> item17 = new HashMap<>();
        item17.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/Ayub%20Bacchu/Ayub%20Bacchu.jpg");
        item17.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/Ayub%20Bacchu/bonolota%20shen%20by%20ayub%20bacchu%20bangla%20song.mp3");
        item17.put("song_name", "Ural Debo Akashe - উড়াল দেব আকাশে - Ayub Bachchu - প্রেম তুমি কি .");
        item17.put("song_type", "Folk");
        arrayList.add(item17);


        // Additional song data can be added here
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
