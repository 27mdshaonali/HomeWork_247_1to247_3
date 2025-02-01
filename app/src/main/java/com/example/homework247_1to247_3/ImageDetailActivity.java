package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class ImageDetailActivity extends AppCompatActivity {

    public static String DIS_NAME = "";

    private ImageView imageView;
    private TextView textView, detailTextViewDistrictName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, insets.getInsets(WindowInsetsCompat.Type.systemBars()).right, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        imageView = findViewById(R.id.detailImageView);
        textView = findViewById(R.id.detailTextView);
        detailTextViewDistrictName = findViewById(R.id.detailTextViewDistrictName);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image_url");
        String text = intent.getStringExtra("text");

        textView.setText(text);
        Picasso.get().load(imageUrl).into(imageView);

        detailTextViewDistrictName.setText(DIS_NAME);
    }
}
