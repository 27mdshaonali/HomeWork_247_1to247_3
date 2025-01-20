package com.example.homework247_1to247_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeWork232_1 extends AppCompatActivity {

    public static String HW232_1TITLE = "";
    public static String HW232_1SUBTITLE = "";
    TextView HW232_1Title, HW232_1SubTitle, resultTextView;
    EditText userInputtedNumber;
    Button getMultiplicationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2321);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();
        HW232_1Title.setText(HW232_1TITLE);
        HW232_1SubTitle.setText(HW232_1SUBTITLE);

        getMultiplicationButton.setOnClickListener(v -> getMultiplicationTable());
    }

    public void initialize() {
        HW232_1Title = findViewById(R.id.HW232_1Title);
        HW232_1SubTitle = findViewById(R.id.HW232_1SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        getMultiplicationButton = findViewById(R.id.getMultiplicationButton);
    }

    public void getMultiplicationTable() {
        String number = userInputtedNumber.getText().toString().trim();

        if (number.isEmpty()) {
            resultTextView.setVisibility(View.GONE); // Hide the result TextView if no input is provided
            userInputtedNumber.setError("Please enter a number");
            return;
        }

        try {
            int num = Integer.parseInt(number);

            // Include the "Your entered number is" message at the start of the result
            StringBuilder result = new StringBuilder("Your entered number is " + num + ". The multiplication table of " + num + " is:\n");

            // Generate multiplication table
            for (int i = 1; i <= 10; i++) {
                result.append(num).append(" X ").append(i).append(" = ").append(num * i).append("\n");
            }

            resultTextView.setVisibility(View.VISIBLE); // Ensure result TextView is visible
            resultTextView.setText(result.toString()); // Set the formatted multiplication table text

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }
    }
}
