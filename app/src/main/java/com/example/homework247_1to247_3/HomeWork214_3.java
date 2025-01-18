package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork214_3 extends AppCompatActivity {

    public static String HW214_3TITLE = "";
    public static String HW214_3SUBTITLE = "";

    TextView HW214_3Title, HW214_3SubTitle, result;
    EditText userInputtedNumber;
    Button checkDayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2143);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW214_3Title.setText(HW214_3TITLE);
        HW214_3SubTitle.setText(HW214_3SUBTITLE);
        checkDayButton.setOnClickListener(view -> calculateDay());

    }


    public void initialize() {

        HW214_3Title = findViewById(R.id.HW214_3Title);
        HW214_3SubTitle = findViewById(R.id.HW214_3SubTitle);
        result = findViewById(R.id.resultTextView);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        checkDayButton = findViewById(R.id.checkDayButton);

    }

    @SuppressLint("SetTextI18n")
    public void calculateDay() {

        try {

            int number = Integer.parseInt(userInputtedNumber.getText().toString());

            if (userInputtedNumber.length() != 0) {
                if (number >= 1 && number <= 7) {
                    if (number == 3) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Monday");

                    } else if (number == 4) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Tuesday");

                    } else if (number == 5) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Wednesday");

                    } else if (number == 6) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Thursday");

                    } else if (number == 7) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Friday");

                    } else if (number == 1) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Saturday");

                    } else {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered number is " + number + ". It is Sunday");
                    }

                } else {
                    result.setVisibility(View.GONE);
                    userInputtedNumber.setError("Enter number between 1 to 7");
                }

            } else {
                result.setVisibility(View.GONE);
                userInputtedNumber.setError("Enter number between 1 to 7");
            }

        } catch (Exception e) {
            result.setVisibility(View.GONE);
            userInputtedNumber.setError("Enter a valid number");
        }

    }

}