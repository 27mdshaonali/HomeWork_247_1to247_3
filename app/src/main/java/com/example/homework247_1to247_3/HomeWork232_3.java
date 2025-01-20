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

public class HomeWork232_3 extends AppCompatActivity {

    public static String HW232_3TITLE = "Default Title";
    public static String HW232_3SUBTITLE = "Default Subtitle";
    TextView HW232_3Title, HW232_3SubTitle, resultTextView, resultTextView2;
    EditText userInputtedNumber;
    Button getSeriesAndSumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2323);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW232_3Title.setText(HW232_3TITLE);
        HW232_3SubTitle.setText(HW232_3SUBTITLE);

        getSeriesAndSumButton.setOnClickListener(view -> getSeriesAndSum());
    }

    public void initialize() {

        HW232_3Title = findViewById(R.id.HW232_3Title);
        HW232_3SubTitle = findViewById(R.id.HW232_3SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        getSeriesAndSumButton = findViewById(R.id.getSeriesAndSumButton);

    }


    @SuppressLint("SetTextI18n")
    public void getSeriesAndSum() {

        String userInput = userInputtedNumber.getText().toString();

        if (userInput.isEmpty()) {
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
            userInputtedNumber.setError("Please enter a number");
            return;
        }

        try {

            long n = Long.parseLong(userInput);

            long sum = 0;
            long seriesNumber = 0;
            StringBuilder seriesNumbers = new StringBuilder();

            if (n > 0 && n <= 9) {

                for (int i = 1; i <= n; i++) {
                    // Construct the next term in the series
                    seriesNumber = seriesNumber * 10 + n;
                    sum += seriesNumber;
                    seriesNumbers.append(seriesNumber).append(" ");
                }

                resultTextView.setVisibility(View.VISIBLE);
                resultTextView2.setVisibility(View.VISIBLE);

                resultTextView.setText("Series of numbers are: " + seriesNumbers.toString().trim());
                resultTextView2.setText("Sum of the series is: " + sum);

            } else {
                resultTextView.setVisibility(View.GONE);
                resultTextView2.setVisibility(View.GONE);
                userInputtedNumber.setError("Please enter a number between 0 and 9");
            }


        } catch (NumberFormatException e) {
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
            userInputtedNumber.setError("Please enter a valid number");
        }

    }


}