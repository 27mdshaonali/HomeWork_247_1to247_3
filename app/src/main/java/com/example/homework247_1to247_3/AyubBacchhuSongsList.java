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

import java.util.ArrayList;
import java.util.HashMap;

public class AyubBacchhuSongsList extends AppCompatActivity {

    private final ArrayList<HashMap<String, String>> songsList = new ArrayList<>();
    private ListView listView;
    private TextView artistName;
    private ImageView artistImage;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ayub_bacchhu_songs_list);

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        populateSongsData();

        // Set the custom adapter
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        // Get artist details from intent
        String artistNameStr = getIntent().getStringExtra("title");
        String artistImageUrl = getIntent().getStringExtra("image_url");

        artistName.setText(artistNameStr);
        Picasso.get().load(artistImageUrl).placeholder(R.drawable.shaon).into(artistImage);
    }

    // Initialize UI components
    private void initializeViews() {
        listView = findViewById(R.id.listView);
        artistName = findViewById(R.id.artistName);
        artistImage = findViewById(R.id.artistImage);
    }

    // Populate the list with songs data
    private void populateSongsData() {
        addSong("http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3",
                "Ayub Bacchhu", "Rock",
                "http://binarybird.xyz/Audio%20Player%20Images/play_icon.png");

        addSong("http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3",
                "Ayub Bacchhu 2", "Pop",
                "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore_2.png");

        addSong("http://binarybird.xyz/songs/Dogtown%20-%20National%20Sweetheart.mp3",
                "Ayub Bacchhu 3", "Pop",
                "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
    }

    // Helper method to add songs to the list
    private void addSong(String audioUrl, String songName, String songType, String playButtonUrl) {
        HashMap<String, String> song = new HashMap<>();
        song.put("audio_url", audioUrl);
        song.put("song_name", songName);
        song.put("song_type", songType);
        song.put("play_button", playButtonUrl);
        songsList.add(song);
    }

    // Custom adapter for displaying the songs
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return songsList.size();
        }

        @Override
        public Object getItem(int position) {
            return songsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Reuse the view for better performance
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.music_list_layout, parent, false);
            }

            // Bind data to UI components
            ImageView musicImage = convertView.findViewById(R.id.artistSongImage);
            TextView songName = convertView.findViewById(R.id.songName);
            TextView songDescription = convertView.findViewById(R.id.songDescription);
            ImageView playButton = convertView.findViewById(R.id.playButton);

            HashMap<String, String> song = songsList.get(position);

            songName.setText(song.get("song_name"));
            songDescription.setText(song.get("song_type"));


            return convertView;
        }
    }
}
