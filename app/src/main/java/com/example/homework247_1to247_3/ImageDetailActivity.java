package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ImageDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        imageView = findViewById(R.id.detailImageView);
        textView = findViewById(R.id.detailTextView);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image_url");
        String text = intent.getStringExtra("text");

        textView.setText(text);
        Picasso.get().load(imageUrl).into(imageView);
    }
}
