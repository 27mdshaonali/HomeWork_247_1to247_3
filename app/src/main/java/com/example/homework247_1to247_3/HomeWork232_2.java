package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork232_2 extends AppCompatActivity {

    // Public static variables for title and subtitle
    public static String HW232_2TITLE = "Default Title";
    public static String HW232_2SUBTITLE = "Default Subtitle";

    // UI Elements
    private TextView HW232_2Title, HW232_2SubTitle, resultTextView, resultTextView2;
    private EditText userInputtedNumber;
    private Button getEvenNumberAndSumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work2322);

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        // Set title and subtitle
        HW232_2Title.setText(HW232_2TITLE);
        HW232_2SubTitle.setText(HW232_2SUBTITLE);

        // Button click listener
        getEvenNumberAndSumButton.setOnClickListener(view -> nTermsOfEvenNumberAndSum());
    }

    // Initialize UI elements
    private void initialize() {
        HW232_2Title = findViewById(R.id.HW232_2Title);
        HW232_2SubTitle = findViewById(R.id.HW232_2SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        getEvenNumberAndSumButton = findViewById(R.id.getEvenNumberAndSumButton);
    }

    // Function to calculate and display even numbers and their sum
    @SuppressLint("SetTextI18n")
    private void nTermsOfEvenNumberAndSum() {
        String userInputtedNumberString = userInputtedNumber.getText().toString().trim();

        // Validate input
        if (userInputtedNumberString.isEmpty()) {
            userInputtedNumber.setError("Please enter a number");
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
            return;
        }

        try {
            int userInputtedNumberInt = Integer.parseInt(userInputtedNumberString);

            if (userInputtedNumberInt <= 0) {
                userInputtedNumber.setError("Please enter a positive number");
                resultTextView.setVisibility(View.GONE);
                resultTextView2.setVisibility(View.GONE);
                return;
            }

            // Reset result text views
            resultTextView.setText("");
            resultTextView2.setText("");

            int sum = 0;
            StringBuilder evenNumbers = new StringBuilder();

            // Generate even numbers and calculate the sum
            for (int i = 1; i <= userInputtedNumberInt; i++) {
                int evenNumber = 2 * i;
                sum += evenNumber;
                evenNumbers.append(evenNumber).append(" ");
            }

            // Display even numbers in resultTextView
            resultTextView.setText("Even Numbers are: " + evenNumbers.toString().trim());
            resultTextView.setVisibility(View.VISIBLE);

            // Display the final sum in resultTextView2
            resultTextView2.setText("Sum of the series is: " + sum);
            resultTextView2.setVisibility(View.VISIBLE);

            // Show a toast with the entered number
            //Toast.makeText(this, "Your entered number is " + userInputtedNumberInt, Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            userInputtedNumber.setError("Please enter a valid number");
            resultTextView.setVisibility(View.GONE);
            resultTextView2.setVisibility(View.GONE);
        }
    }
}
