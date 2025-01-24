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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_james_songs_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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

    // Initialize views
    public void initialize() {
        listView = findViewById(R.id.listView);
        artistName = findViewById(R.id.artistName);
        artistImage = findViewById(R.id.artistImage);
        mediaPlayer = new MediaPlayer(); // Initialize MediaPlayer
        currentlyPlayingButton = null; // Initially, no song is playing
    }

    // Populate the list with song data
    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/james.jpg");
        item1.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item1.put("song_name", "James");
        item1.put("song_type", "Rock");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore_2.png");
        item2.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item2.put("song_name", "James 2");
        item2.put("song_type", "Folk");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
        item3.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item3.put("song_name", "James 3");
        item3.put("song_type", "Pop");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/james.jpg");
        item4.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item4.put("song_name", "James");
        item4.put("song_type", "Rock");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore_2.png");
        item5.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item5.put("song_name", "James 2");
        item5.put("song_type", "Folk");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
        item6.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item6.put("song_name", "James 3");
        item6.put("song_type", "Pop");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/james.jpg");
        item7.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item7.put("song_name", "James");
        item7.put("song_type", "Rock");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore_2.png");
        item8.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item8.put("song_name", "James 2");
        item8.put("song_type", "Folk");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
        item9.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item9.put("song_name", "James 3");
        item9.put("song_type", "Pop");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/james.jpg");
        item10.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item10.put("song_name", "James");
        item10.put("song_type", "Rock");
        arrayList.add(item10);

        HashMap<String, String> item11 = new HashMap<>();
        item11.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore_2.png");
        item11.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item11.put("song_name", "James 2");
        item11.put("song_type", "Folk");
        arrayList.add(item11);

        HashMap<String, String> item12 = new HashMap<>();
        item12.put("artist_image_url", "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
        item12.put("audio_url", "http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3");
        item12.put("song_name", "James 3");
        item12.put("song_type", "Pop");
        arrayList.add(item12);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            String songType = song.get("song_type");

            Picasso.get().load(artistImageUrl).placeholder(R.drawable.shaon).into(artistSongImage);
            songName.setText(songTitle);
            songDescription.setText(songType);

            playButton.setTag("PLAY_NOW");
            playButton.setImageResource(R.drawable.play_icon);

            playButton.setOnClickListener(v -> {
                try {
                    // Stop and reset the current MediaPlayer
                    if (mediaPlayer != null) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                        }
                        mediaPlayer.reset();
                    }

                    // Update UI for the previously playing button
                    if (currentlyPlayingButton != null && currentlyPlayingButton != playButton) {
                        currentlyPlayingButton.setImageResource(R.drawable.play_icon);
                        currentlyPlayingButton.setTag("PLAY_NOW");
                    }

                    // Set the new audio source and play
                    if (playButton.getTag().equals("PLAY_NOW")) {
                        mediaPlayer.setDataSource(audioUrl);
                        mediaPlayer.prepare();
                        mediaPlayer.start();

                        playButton.setImageResource(R.drawable.pause_icon);
                        playButton.setTag("PLAYING");
                        currentlyPlayingButton = playButton;

                        mediaPlayer.setOnCompletionListener(mp -> {
                            // Handle completion (optional: reset UI, etc.)
                            playButton.setImageResource(R.drawable.play_icon);
                            playButton.setTag("PLAY_NOW");
                            currentlyPlayingButton = null;
                        });
                    } else if (playButton.getTag().equals("PLAYING")) {
                        mediaPlayer.pause();
                        playButton.setImageResource(R.drawable.play_icon);
                        playButton.setTag("PLAY_NOW");
                        currentlyPlayingButton = null;
                    }
                } catch (IOException | IllegalStateException e) {
                    // Handle exceptions gracefully
                    e.printStackTrace();
                }
            });

            return myView;
        }
    }
}