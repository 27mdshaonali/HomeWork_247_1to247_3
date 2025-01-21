package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
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

public class HomeWork232_5 extends AppCompatActivity {

    public static String HW232_5TITLE = "";
    public static String HW232_5SUBTITLE = "";
    TextView HW232_5Title, HW232_5SubTitle, resultTextView, resultTextView2;
    EditText userInputted;
    Button checkPalindromeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2325);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializing();

        HW232_5Title.setText(HW232_5TITLE);
        HW232_5SubTitle.setText(HW232_5SUBTITLE);

        checkPalindromeButton.setOnClickListener(v -> checkPalindrome());

    }

    public void initializing() {

        HW232_5Title = findViewById(R.id.HW232_5Title);
        HW232_5SubTitle = findViewById(R.id.HW232_5SubTitle);
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2);
        userInputted = findViewById(R.id.userInputted);
        checkPalindromeButton = findViewById(R.id.checkPalindromeButton);

    }

    @SuppressLint("SetTextI18n")
    public void checkPalindrome() {
        String input = userInputted.getText().toString();

        if (input.isEmpty()) {
            resultTextView.setVisibility(View.GONE);
            userInputted.setError("Please enter a word or number");
        }

        try {

            String normalizeInput = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            StringBuilder reversedInput = new StringBuilder(normalizeInput).reverse();

            if (normalizeInput.equals(reversedInput.toString())) {
                resultTextView.setVisibility(TextView.VISIBLE);

                resultTextView.setText("The input \"" + normalizeInput + "\" is a palindrome!");
            } else {
                resultTextView.setVisibility(TextView.VISIBLE);
                resultTextView.setText("The input \"" + normalizeInput + "\" is a not palindrome!");
            }

        } catch (Exception e) {
            resultTextView.setVisibility(View.GONE);
            Toast.makeText(this, "Please enter a word or number", Toast.LENGTH_SHORT).show();
        }

    }

}