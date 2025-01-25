package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JamesSongsList extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ListView listView;
    TextView artistName;
    ImageView artistImage;

    private MediaPlayer mediaPlayer; // Single MediaPlayer instance
    private ImageView currentlyPlayingButton; // Tracks the currently playing button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_james_songs_list);

        initialize();

        // Get artist details from the intent
        String artistNameStr = getIntent().getStringExtra("title");
        String artistImageUrl = getIntent().getStringExtra("image_url");

        artistName.setText(artistNameStr);
        Picasso.get().load(artistImageUrl).placeholder(R.drawable.shaon).into(artistImage);

        populateData();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
    }

    public void initialize() {
        listView = findViewById(R.id.listView);
        artistName = findViewById(R.id.artistName);
        artistImage = findViewById(R.id.artistImage);
        mediaPlayer = new MediaPlayer(); // Initialize MediaPlayer
        currentlyPlayingButton = null; // Initially, no song is playing
    }

    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item1.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%95%e0%a6%ac%e0%a6%bf%e0%a6%a4%e0%a6%be%20%e0%a6%a4%e0%a7%81%e0%a6%ae%e0%a6%bf%20%e0%a6%b8%e0%a7%8d%e0%a6%ac%e0%a6%aa%e0%a7%8d%e0%a6%a8%e0%a6%9a%e0%a6%be%e0%a6%b0%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%b9%e0%a6%af%e0%a6%bc%e0%a7%87%20_%20Kobita%20_%20James%20_%20Lyrics.mp3");
        item1.put("song_name", "কবিতা তুমি স্বপ্নচারিনী হয়ে Kobita James Lyrics");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item2.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/BABA-%e0%a6%ac%e0%a6%be%e0%a6%ac%e0%a6%be%20_Baba%20Kotodin%20Dekhina%20Tomay_James_Guitar%20Chord%20_%20Lyrics.mp3");
        item2.put("song_name", "BABA-বাবা _Baba Kotodin Dekhina Tomay_James_Guitar Chord _ Lyrics");
        item2.put("song_type", "Folk");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item3.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Maa%20by%20James%20_%20%e0%a6%ae%e0%a6%be-%20%e0%a6%9c%e0%a7%87%e0%a6%ae%e0%a6%b8%e0%a7%8d%20_James%20Bangladesh%20%5bLyrics%5d%20_MusicLovers.mp3");
        item3.put("song_name", "Maa by James _ মা- জেমস্ _James Bangladesh [Lyrics] _MusicLovers");
        item3.put("song_type", "Pop");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item4.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%86%e0%a6%b0%e0%a7%8b%20%e0%a6%95%e0%a6%bf%e0%a6%9b%e0%a7%81%e0%a6%95%e0%a7%8d%e0%a6%b7%e0%a6%a3%20%e0%a6%95%e0%a6%bf%20%e0%a6%b0%e0%a6%ac%e0%a7%87%20%e0%a6%ac%e0%a6%a8%e0%a7%8d%e0%a6%a7%e0%a7%81%e0%a5%a4%e0%a6%9c%e0%a7%87%e0%a6%ae%e0%a6%b8%e0%a5%a4%e0%a5%a4%20Aro%20kichukkhon%20ki%20roibe%20bondhu%20__%20Etc%20youtuber.mp3");
        item4.put("song_name", "আরো কিছুক্ষণ কি রবে বন্ধু।জেমস।। Aro kichukkhon ki roibe bondhu __ Etc youtuber");
        item4.put("song_type", "Rock");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item5.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%a4%e0%a7%81%e0%a6%87%20%e0%a6%95%e0%a7%8b%e0%a6%a5%e0%a6%be%e0%a6%af%e0%a6%bc%20%e0%a6%af%e0%a6%be%e0%a6%b8%e0%a6%b0%e0%a7%87%20_%20James.mp3");
        item5.put("song_name", "তুই কোথায় যাসরে _ James");
        item5.put("song_type", "Folk");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item6.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/%e0%a6%aa%e0%a7%8d%e0%a6%b0%e0%a7%87%e0%a6%ae%20%e0%a6%af%e0%a6%ae%e0%a7%81%e0%a6%a8%e0%a6%be%e0%a6%b0%20%e0%a6%9c%e0%a6%b2%e0%a7%87%e0%a5%a4Prem%20Jomunar%20Jole%e0%a5%a4James%e0%a5%a4Bangla%20Song%20Lyrics.mp3");
        item6.put("song_name", "প্রেম যমুনার জলে।Prem Jomunar Jole।James।Bangla Song Lyrics");
        item6.put("song_type", "Pop");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item7.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Adh%20Boyosi%20Manus%20Ami%20Majh%20Boyosi%20Mon%20By%20James.mp3");
        item7.put("song_name", "Adh Boyosi Manus Ami Majh Boyosi Mon By James");
        item7.put("song_type", "Rock");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item8.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Dukhini%20Dukkho%20Koro%20Na%20By%20James%20--%20%e0%a6%9a%e0%a7%87%e0%a7%9f%e0%a7%87%20%e0%a6%a6%e0%a7%87%e0%a6%96%e0%a7%8b%20%e0%a6%89%e0%a6%a0%e0%a7%87%e0%a6%9b%e0%a7%87%20%e0%a6%a8%e0%a6%a4%e0%a7%81%e0%a6%a8%20%e0%a6%b8%e0%a7%81%e0%a6%b0%e0%a7%8d%e0%a6%af%20--%20Ceye%20Dekho%20Uthese%20Notun%20Suryo%e2%99%aaGuru.mp3");
        item8.put("song_name", "Dukhini Dukkho Koro Na By James -- চেয়ে দেখো উঠেছে নতুন সুর্য -- Ceye Dekho Uthese Notun Suryo♪Guru");
        item8.put("song_type", "Folk");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item9.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Ei%20Bukta%20Cire%20__%20%e0%a6%8f%e0%a6%87%20%e0%a6%ac%e0%a7%81%e0%a6%95%e0%a6%9f%e0%a6%be%20%e0%a6%9a%e0%a6%bf%e0%a6%b0%e0%a7%87%20__%20James%20__%20%20NHASO%20Release.mp3");
        item9.put("song_name", "Ei Bukta Cire __ এই বুকটা চিরে __ James __  NHASO Release");
        item9.put("song_type", "Pop");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item10.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Jibonta%20Cigarette%20Er%20Chai%20__%20%e0%a6%9c%e0%a6%bf%e0%a6%ac%e0%a6%a8%e0%a6%9f%e0%a6%be%20%e0%a6%9b%e0%a6%bf%e0%a6%97%e0%a6%be%e0%a6%b0%e0%a7%87%e0%a6%9f%20%e0%a6%8f%e0%a6%b0%20%e0%a6%9b%e0%a6%be%e0%a6%87,%20%20%e0%a6%ab%e0%a7%81%20%e0%a6%a6%e0%a6%bf%e0%a6%a4%e0%a7%87%20%e0%a6%a4%e0%a6%be%e0%a6%95%e0%a7%87%20%e0%a6%89%e0%a7%9c%e0%a6%be%e0%a6%87.mp3");
        item10.put("song_name", "Jibonta Cigarette Er Chai __ জিবনটা ছিগারেট এর ছাই,  ফু দিতে তাকে উড়াই");
        item10.put("song_type", "Rock");
        arrayList.add(item10);

        HashMap<String, String> item11 = new HashMap<>();
        item11.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item11.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Nandini%20Nandini%20By%20James%20!!%20%e0%a6%a8%e0%a6%a8%e0%a7%8d%e0%a6%a6%e0%a6%bf%e0%a6%a8%e0%a7%80%20%e0%a6%9c%e0%a7%87%e0%a6%ae%e0%a6%b8%20!!%20Nandini%20Nandini%20Nagorik%20Nandini%20By%20James.mp3");
        item11.put("song_name", "Nandini Nandini By James !! নন্দিনী জেমস !! Nandini Nandini Nagorik Nandini By James");
        item11.put("song_type", "Folk");
        arrayList.add(item11);

        HashMap<String, String> item12 = new HashMap<>();
        item12.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item12.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Nibedita%20By%20James%20!!%20%e0%a6%a8%e0%a6%bf%e0%a6%ac%e0%a7%87%e0%a6%a6%e0%a6%bf%e0%a6%a4%e0%a6%be%20!!%20Nibedita%20Nibedon%20Tomake%20ei%20Agun%20Niye%20Khela%20Khela%20Bondho%20Koro.mp3");
        item12.put("song_name", "Nibedita By James !! নিবেদিতা !! Nibedita Nibedon Tomake ei Agun Niye Khela Khela Bondho Koro");
        item12.put("song_type", "Pop");
        arrayList.add(item12);

        HashMap<String, String> item13 = new HashMap<>();
        item13.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item13.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Nibedita%20By%20James%20!!%20%e0%a6%a8%e0%a6%bf%e0%a6%ac%e0%a7%87%e0%a6%a6%e0%a6%bf%e0%a6%a4%e0%a6%be%20!!%20Nibedita%20Nibedon%20Tomake%20ei%20Agun%20Niye%20Khela%20Khela%20Bondho%20Koro.mp3");
        item13.put("song_name", "Nibedita By James !! নিবেদিতা !! Nibedita Nibedon Tomake ei Agun Niye Khela Khela Bondho Koro");
        item13.put("song_type", "Pop");
        arrayList.add(item13);

        HashMap<String, String> item14 = new HashMap<>();
        item14.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item14.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Nodi%20(%e0%a6%ad%e0%a7%81%e0%a6%b2%e0%a7%87%20%e0%a6%af%e0%a6%be%e0%a6%93%20%e0%a6%86%e0%a6%ae%e0%a6%be%e0%a6%95%e0%a7%87%20%e0%a6%a8%e0%a6%a6%e0%a7%80)%20by%20Nogor%20Baul%20James%20II%20Guru%20James.mp3");
        item14.put("song_name", "Nodi (ভুলে যাও আমাকে নদী) by Nogor Baul James II Guru James");
        item14.put("song_type", "Pop");
        arrayList.add(item14);

        HashMap<String, String> item15 = new HashMap<>();
        item15.put("artist_image_url", "http://192.168.0.103/HomeWork%20247.2/Images/James/James%20Song%20Cover.jpg");
        item15.put("audio_url", "http://192.168.0.103/HomeWork%20247.2/Songs/James/Pagla%20Hawa%20by%20James%20-%20%e0%a6%aa%e0%a6%be%e0%a6%97%e0%a6%b2%e0%a6%be%20%e0%a6%b9%e0%a6%be%e0%a6%93%e0%a6%af%e0%a6%bc%e0%a6%be%20%e0%a6%9c%e0%a7%87%e0%a6%ae%e0%a6%b8%20-Ore%20Ore%20hawa%20%5bLyrics%5d.mp3");
        item15.put("song_name", "Pagla Hawa by James - পাগলা হাওয়া জেমস -Ore Ore hawa [Lyrics]");
        item15.put("song_type", "Pop");
        arrayList.add(item15);

        // Additional song data can be added here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Ensure that the MediaPlayer is properly released
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // Adapter for the song list
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.music_list_layout, parent, false);

            ImageView artistSongImage = myView.findViewById(R.id.artistSongImage);
            TextView songName = myView.findViewById(R.id.songName);
            TextView songDescription = myView.findViewById(R.id.songDescription);
            ImageView playButton = myView.findViewById(R.id.playButton);

            HashMap<String, String> song = arrayList.get(position);

            String artistImageUrl = song.get("artist_image_url");
            String audioUrl = song.get("audio_url");
            String songTitle = song.get("song_name");
//            String songType = song.get("song_type");

            Picasso.get().load(artistImageUrl).placeholder(R.drawable.shaon).into(artistSongImage);
            songName.setText(songTitle);
//            songDescription.setText(songType);

            playButton.setTag("PLAY_NOW");
            playButton.setImageResource(R.drawable.play_icon2);

            playButton.setOnClickListener(v -> {
                try {
                    // If the same song is clicked again, toggle play/pause
                    if (currentlyPlayingButton != null && currentlyPlayingButton == playButton) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();
                            playButton.setImageResource(R.drawable.play_icon2); // Change to play icon
                            playButton.setTag("PLAY_NOW");
                        } else {
                            mediaPlayer.start();
                            playButton.setImageResource(R.drawable.pause_icon); // Change to pause icon
                            playButton.setTag("PLAYING");
                        }
                        return; // Exit if the same button is clicked (toggle play/pause)
                    }

                    // If a different song is clicked, stop the current song and start the new one
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }

                    mediaPlayer.reset(); // Reset the media player

                    // Set the data source to the new song and prepare it for playing
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepareAsync(); // Start preparing the media

                    // Start playing once prepared
                    mediaPlayer.setOnPreparedListener(mp -> {
                        mp.start(); // Start the new song after preparation
                        playButton.setImageResource(R.drawable.pause_icon); // Change to pause icon
                        playButton.setTag("PLAYING");

                        if (currentlyPlayingButton != null && currentlyPlayingButton != playButton) {
                            currentlyPlayingButton.setImageResource(R.drawable.play_icon2); // Reset previous button
                            currentlyPlayingButton.setTag("PLAY_NOW");
                        }

                        currentlyPlayingButton = playButton; // Set the new button as currently playing
                    });

                    // Reset the button after playback completes
                    mediaPlayer.setOnCompletionListener(mp -> {
                        playButton.setImageResource(R.drawable.play_icon2);
                        playButton.setTag("PLAY_NOW");
                        currentlyPlayingButton = null;
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return myView;
        }
    }
}
