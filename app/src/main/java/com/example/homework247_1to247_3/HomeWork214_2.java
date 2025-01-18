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

public class HomeWork214_2 extends AppCompatActivity {

    public static String HW214_2TITLE = "";
    public static String HW214_2SUBTITLE = "";
    TextView HW214_2Title, HW214_2SubTitle, result;
    EditText userInputtedNumber;
    Button checkLeapYearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2142);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        HW214_2Title.setText(HW214_2TITLE);
        HW214_2SubTitle.setText(HW214_2SUBTITLE);
        checkLeapYearButton.setOnClickListener(v -> calculatingLeapYear());


    }


    public void initialize() {

        HW214_2Title = findViewById(R.id.HW214_2Title);
        HW214_2SubTitle = findViewById(R.id.HW214_2SubTitle);
        result = findViewById(R.id.resultTextView);
        userInputtedNumber = findViewById(R.id.userInputtedNumber);
        checkLeapYearButton = findViewById(R.id.checkLeapYearButton);

    }

    @SuppressLint("SetTextI18n")
    public void calculatingLeapYear() {

        String stringYear = userInputtedNumber.getText().toString();

        try {

            int intYear = Integer.parseInt(stringYear);

            if (!stringYear.isEmpty()) {

                if ((intYear % 4 == 0 && intYear % 100 != 0) || (intYear % 400 == 0)) {

                    result.setVisibility(View.VISIBLE);
                    result.setText("Your entered year is " + intYear + ". is a leap year");

                } else {

                    result.setVisibility(View.VISIBLE);
                    result.setText("Your entered year is " + intYear + ". It is not a leap year");

                }

            } else {
                userInputtedNumber.setError("Please enter a number");
            }


        } catch (Exception e) {

            result.setText("Please enter a valid number");
        }


    }

}