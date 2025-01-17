package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    TextView HW214_1Title, HW214_1SubTitle, resultTextView;
    EditText userInputtedNumber;
    Button checkNumberButton;

    @SuppressLint("SetTextI18n")
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

        initialize();

        HW214_1Title.setText(HW214_1TITLE);
        HW214_1SubTitle.setText(HW214_1SUBTITLE);

        checkNumberButton.setOnClickListener(v -> {

            String userInput = userInputtedNumber.getText().toString();

            try {

                if (!userInput.isEmpty()) {

                    int number = Integer.parseInt(userInput);

                    if (number % 5 == 0 && number % 11 == 0) {

                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your entered number is " + number + ". The number is divisible by both 5 and 11.");

                    } else if (number % 5 == 0) {

                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your entered number is " + number + ". The number is divisible by 5. But not divisible by 11. Try another number.");

                    } else if (number % 11 == 0) {

                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your entered number is " + number + ". The number is divisible by 11. But not divisible by 5. Try another number.");

                    } else {

                        resultTextView.setVisibility(View.VISIBLE);
                        resultTextView.setText("Your entered number is " + number + ". The number is not divisible by both 5 and 11. Try another number.");

                    }

                }


            } catch (NumberFormatException e) {
                resultTextView.setError("Please enter a number");
            }

        });


    } //=========================== onCreate Ends ==========================

    public void initialize() {

        adView = findViewById(R.id.adView);
        HW214_1Title = findViewById(R.id.HW214_1Title);
        HW214_1SubTitle = findViewById(R.id.HW214_1SubTitle);

        resultTextView = findViewById(R.id.resultTextView);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        checkNumberButton = findViewById(R.id.checkNumberButton);

    }

}