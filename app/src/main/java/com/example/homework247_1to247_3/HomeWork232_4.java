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

public class HomeWork232_4 extends AppCompatActivity {

    public static String HW232_4TITLE = "Default Title";
    public static String HW232_4SUBTITLE = "Default Subtitle";
    TextView HW232_4Title, HW232_4SubTitle, resultTextView, resultTextView2;
    EditText userInputtedNumber;
    Button getSquireAndSumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2324);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW232_4Title.setText(HW232_4TITLE);
        HW232_4SubTitle.setText(HW232_4SUBTITLE);

        getSquireAndSumButton.setOnClickListener(view -> getSquireAndSum());

    }

    public void initialize() {

        HW232_4Title = findViewById(R.id.HW232_4Title);
        HW232_4SubTitle = findViewById(R.id.HW232_4SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        getSquireAndSumButton = findViewById(R.id.getSquireAndSumButton);

    }

    @SuppressLint("SetTextI18n")
    public void getSquireAndSum() {

        String userInput = userInputtedNumber.getText().toString();

        if (userInput.isEmpty()) {
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
            userInputtedNumber.setError("Please enter a number");
            return;
        }

        try {

            int n = Integer.parseInt(userInput);

            int sum = 0;
            StringBuilder seriesNumbers = new StringBuilder();

            if (n > 0) {

                for (int i = 1; i <= n; i++) {
                    int squire = i * i; // Calculate the integer square root
                    sum += squire; // Add to the sum

                    // Append the square root to the StringBuilder
                    if (i > 1) {
                        seriesNumbers.append(", ");
                    }
                    seriesNumbers.append(squire);
                }

                resultTextView.setVisibility(View.VISIBLE);
                resultTextView2.setVisibility(View.VISIBLE);

                resultTextView.setText("The square natural numbers up to " + n + " terms are: " + seriesNumbers);
                resultTextView2.setText("The sum of square natural numbers is: " + sum);

            } else {
                resultTextView.setVisibility(View.GONE);
                resultTextView2.setVisibility(View.GONE);
                userInputtedNumber.setError("Please enter a positive number");
            }

        } catch (NumberFormatException e) {
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
            userInputtedNumber.setError("Please enter a valid number");
        }
    }


}