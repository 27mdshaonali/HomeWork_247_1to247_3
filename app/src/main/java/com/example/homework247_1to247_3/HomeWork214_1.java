package com.example.homework247_1to247_3;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork214_1 extends AppCompatActivity {

    public static String HW214_1TITLE = "";
    public static String HW214_1SUBTITLE = "";

    LinearLayout adView;
    TextView HW214_1Title, HW214_1SubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2141);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adView = findViewById(R.id.adView);
        HW214_1Title = findViewById(R.id.HW214_1Title);
        HW214_1SubTitle = findViewById(R.id.HW214_1SubTitle);

        HW214_1Title.setText(HW214_1TITLE);
        HW214_1SubTitle.setText(HW214_1SUBTITLE);


    }
}